package hn.ficohsa.msvc_ficohsa_insurance.services.definitions;

import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;

public interface LogService {
  void saveAsync(FicohsaInsuranceException exception);
}
