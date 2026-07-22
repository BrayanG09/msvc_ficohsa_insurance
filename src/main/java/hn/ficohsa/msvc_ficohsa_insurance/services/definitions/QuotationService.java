package hn.ficohsa.msvc_ficohsa_insurance.services.definitions;

import hn.ficohsa.msvc_ficohsa_insurance.dtos.quotations.QuotationRequestDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.quotations.QuotationResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;

public interface QuotationService {
  QuotationResponseDTO createQuotation(QuotationRequestDTO request) throws FicohsaInsuranceException;
}
