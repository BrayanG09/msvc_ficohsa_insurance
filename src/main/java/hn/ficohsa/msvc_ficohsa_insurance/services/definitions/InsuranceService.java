package hn.ficohsa.msvc_ficohsa_insurance.services.definitions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import hn.ficohsa.msvc_ficohsa_insurance.dtos.insurance.InsuranceResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;

public interface InsuranceService {
  Page<InsuranceResponseDTO> findAll(Pageable pageable) throws FicohsaInsuranceException;
}
