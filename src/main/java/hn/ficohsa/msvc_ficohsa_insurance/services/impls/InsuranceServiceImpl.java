package hn.ficohsa.msvc_ficohsa_insurance.services.impls;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hn.ficohsa.msvc_ficohsa_insurance.dtos.insurance.InsuranceCategoryResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.insurance.InsuranceConditionResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.insurance.InsuranceResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.entities.Insurance;
import hn.ficohsa.msvc_ficohsa_insurance.entities.InsuranceConditionMapping;
import hn.ficohsa.msvc_ficohsa_insurance.enums.InsuranceCodeCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.LevelLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.ProcessLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.ProjectsCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.TypeLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;
import hn.ficohsa.msvc_ficohsa_insurance.repositories.InsuranceRepository;
import hn.ficohsa.msvc_ficohsa_insurance.services.definitions.InsuranceService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
  private final InsuranceRepository insuranceRepository;

  @Override
  @Transactional(readOnly = true)
  public Page<InsuranceResponseDTO> findAll(Pageable pageable) throws FicohsaInsuranceException {
    try {
      Page<UUID> insuranceIdsPage = this.insuranceRepository.findEnabledInsuranceIds(pageable);

      if (insuranceIdsPage.isEmpty()) {
        return Page.empty(pageable);
      }

      Map<UUID, Insurance> insuranceById = this.insuranceRepository
          .findAllWithDetailsByIdIn(insuranceIdsPage.getContent())
          .stream()
          .collect(Collectors.toMap(Insurance::getInsuranceId, Function.identity()));

      List<InsuranceResponseDTO> content = insuranceIdsPage.getContent()
          .stream()
          .map(insuranceById::get)
          .filter(Objects::nonNull)
          .map(this::toResponse)
          .toList();

      return new PageImpl<>(content, pageable, insuranceIdsPage.getTotalElements());
    } catch (Exception e) {
      throw FicohsaInsuranceException.builder()
          .type(TypeLogCatalog.INSURANCE.name())
          .project(ProjectsCatalog.MSVC_FICOHSA_INSURANCE)
          .process(ProcessLogCatalog.FIND_ALL_INSURANCE_EXCEPTION.name())
          .codeCatalog(InsuranceCodeCatalog.FIND_ALL_INSURANCE_EXCEPTION)
          .level(LevelLogCatalog.ERROR)
          .exception(e)
          .build();
    }
  }

  private InsuranceResponseDTO toResponse(Insurance insurance) {
    return InsuranceResponseDTO.builder()
        .insuranceId(insurance.getInsuranceId())
        .insuranceName(insurance.getInsuranceName())
        .description(insurance.getDescription())
        .price(insurance.getPrice())
        .category(
            InsuranceCategoryResponseDTO.builder()
                .insuranceCategoryId(insurance.getCategory().getInsuranceCategoryId())
                .categoryName(insurance.getCategory().getCategoryName())
                .build())
        .conditions(
            insurance.getConditions()
                .stream()
                .filter(InsuranceConditionMapping::getEnabled)
                .filter(mapping -> mapping.getCondition().getEnabled())
                .map(mapping -> InsuranceConditionResponseDTO.builder()
                    .insuranceConditionId(mapping.getCondition().getInsuranceConditionId())
                    .description(mapping.getCondition().getDescription())
                    .build())
                .toList())
        .build();
  }
}
