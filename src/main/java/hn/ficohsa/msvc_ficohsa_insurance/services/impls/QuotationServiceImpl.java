package hn.ficohsa.msvc_ficohsa_insurance.services.impls;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hn.ficohsa.msvc_ficohsa_insurance.dtos.quotations.QuotationRequestDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.quotations.QuotationResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.entities.Insurance;
import hn.ficohsa.msvc_ficohsa_insurance.entities.Quotation;
import hn.ficohsa.msvc_ficohsa_insurance.entities.User;
import hn.ficohsa.msvc_ficohsa_insurance.enums.AuthCodeCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.LevelLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.ProcessLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.ProjectsCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.QuotationCodeCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.QuotationStatus;
import hn.ficohsa.msvc_ficohsa_insurance.enums.TypeLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;
import hn.ficohsa.msvc_ficohsa_insurance.repositories.InsuranceRepository;
import hn.ficohsa.msvc_ficohsa_insurance.repositories.QuotationRepository;
import hn.ficohsa.msvc_ficohsa_insurance.repositories.UserRepository;
import hn.ficohsa.msvc_ficohsa_insurance.services.definitions.QuotationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuotationServiceImpl implements QuotationService {
  private final QuotationRepository quotationRepository;
  private final InsuranceRepository insuranceRepository;
  private final UserRepository userRepository;

  @Override
  @Transactional
  public QuotationResponseDTO createQuotation(QuotationRequestDTO request) throws FicohsaInsuranceException {
    String username = null;

    try {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      username = authentication.getName();

      Optional<User> userOptional = this.userRepository.findByUsername(username);
      if (userOptional.isEmpty()) {
        throw FicohsaInsuranceException.builder()
            .process(ProcessLogCatalog.USERNAME_NOT_FOUND.name())
            .codeCatalog(QuotationCodeCatalog.USERNAME_NOT_FOUND)
            .level(LevelLogCatalog.WARN)
            .build();
      }

      if (!userOptional.get().getEnabled()) {
        throw FicohsaInsuranceException.builder()
            .process(ProcessLogCatalog.DISABLED.name())
            .codeCatalog(AuthCodeCatalog.DISABLED)
            .level(LevelLogCatalog.WARN)
            .build();
      }

      Optional<Insurance> insuOptional = this.insuranceRepository.findById(request.getInsuranceId());
      if (insuOptional.isEmpty()) {
        throw FicohsaInsuranceException.builder()
            .process(ProcessLogCatalog.INSURANCE_NOT_FOUND.name())
            .codeCatalog(QuotationCodeCatalog.INSURANCE_NOT_FOUND)
            .level(LevelLogCatalog.WARN)
            .build();
      }

      if (!insuOptional.get().getEnabled()) {
        throw FicohsaInsuranceException.builder()
            .process(ProcessLogCatalog.INSURANCE_DISABLED.name())
            .codeCatalog(QuotationCodeCatalog.INSURANCE_DISABLED)
            .level(LevelLogCatalog.WARN)
            .build();
      }

      Quotation quotation = new Quotation();
      quotation.setUser(userOptional.get());
      quotation.setInsurance(insuOptional.get());
      quotation.setApplicantName(request.getApplicantName());
      quotation.setApplicantIdentity(request.getApplicantIdentity());
      quotation.setApplicantEmail(request.getApplicantEmail());
      quotation.setApplicantPhone(request.getApplicantPhone());
      quotation.setVehicleYear(request.getVehicleYear());
      quotation.setVehicleBrand(request.getVehicleBrand());
      quotation.setVehicleModel(request.getVehicleModel());
      quotation.setVehicleValue(request.getVehicleValue());
      quotation.setStatus(QuotationStatus.PENDING);
      quotation.setEnabled(true);

      Quotation savedQuotation = quotationRepository.save(quotation);

      return QuotationResponseDTO.builder()
          .quotationId(savedQuotation.getQuotationId())
          .build();
    } catch (FicohsaInsuranceException e) {
      e.setProject(ProjectsCatalog.MSVC_FICOHSA_INSURANCE);
      e.setType(TypeLogCatalog.QUOTATION.name());
      e.setUserIdentifier(username);

      throw e;
    } catch (Exception e) {
      throw FicohsaInsuranceException.builder()
          .userIdentifier(username)
          .project(ProjectsCatalog.MSVC_FICOHSA_INSURANCE)
          .type(TypeLogCatalog.QUOTATION.name())
          .process(ProcessLogCatalog.EXCEPTION.name())
          .codeCatalog(QuotationCodeCatalog.EXCEPTION_CREATE)
          .level(LevelLogCatalog.ERROR)
          .exception(e)
          .build();
    }
  }

}
