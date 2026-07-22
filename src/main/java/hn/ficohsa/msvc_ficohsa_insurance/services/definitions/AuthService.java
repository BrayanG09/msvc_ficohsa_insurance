package hn.ficohsa.msvc_ficohsa_insurance.services.definitions;

import hn.ficohsa.msvc_ficohsa_insurance.dtos.auth.AuthRequestDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.auth.AuthResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;

public interface AuthService {
  AuthResponseDTO verify(AuthRequestDTO request) throws FicohsaInsuranceException;
}
