package hn.ficohsa.msvc_ficohsa_insurance.services.impls;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hn.ficohsa.msvc_ficohsa_insurance.entities.Log;
import hn.ficohsa.msvc_ficohsa_insurance.enums.LevelLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.ProjectsCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;
import hn.ficohsa.msvc_ficohsa_insurance.interfaces.CodeCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.repositories.LogRepository;
import hn.ficohsa.msvc_ficohsa_insurance.services.definitions.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {
  private final LogRepository logRepository;

  @Override
  @Async("logTaskExecutor")
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void saveAsync(FicohsaInsuranceException exception) {
    try {
      logRepository.save(toEntity(exception));
    } catch (Exception e) {
      log.error("No se pudo almacenar el log de FicohsaInsuranceException", e);
    }
  }

  private Log toEntity(FicohsaInsuranceException exception) {
    Log.LogBuilder builder = Log.builder()
        .project(resolveProject(exception.getProject()))
        .type(blankToNull(exception.getType()))
        .process(blankToNull(exception.getProcess()))
        .level(resolveLevel(exception.getLevel()))
        .userIdentifier(blankToNull(exception.getUserIdentifier()))
        .metadata(blankToNull(exception.getMetadata()))
        .path(blankToNull(exception.getPath()));

    CodeCatalog codeCatalog = exception.getCodeCatalog();
    if (!Objects.isNull(codeCatalog)) {
      builder
          .code(blankToNull(codeCatalog.code()))
          .message(blankToNull(codeCatalog.message()))
          .description(blankToNull(codeCatalog.description()))
          .httpCode(Objects.isNull(codeCatalog.httpCode()) ? null : codeCatalog.httpCode().value());
    }

    extractDataFromException(builder, exception.getException());

    return builder.build();
  }

  private void extractDataFromException(Log.LogBuilder builder, Exception exception) {
    if (Objects.isNull(exception)) {
      return;
    }

    builder
        .exceptionClass(exception.getClass().getName())
        .exceptionMessage(blankToNull(exception.getMessage()))
        .exceptionStackTrace(stackTraceToString(exception));

    Throwable cause = exception.getCause();
    if (!Objects.isNull(cause) && cause != exception) {
      builder
          .exceptionCauseClass(cause.getClass().getName())
          .exceptionCauseMessage(blankToNull(cause.getMessage()));
    }
  }

  private String resolveProject(ProjectsCatalog project) {
    return Objects.isNull(project) ? ProjectsCatalog.MSVC_FICOHSA_INSURANCE.name() : blankToNull(project.getCode());
  }

  private String resolveLevel(LevelLogCatalog level) {
    return Objects.isNull(level) ? LevelLogCatalog.DEBUG.name() : blankToNull(level.getCode());
  }

  private String blankToNull(String value) {
    if (Objects.isNull(value) || value.isBlank()) {
      return null;
    }
    return value;
  }

  private String stackTraceToString(Throwable throwable) {
    StringWriter writer = new StringWriter();
    throwable.printStackTrace(new PrintWriter(writer));
    return writer.toString();
  }
}
