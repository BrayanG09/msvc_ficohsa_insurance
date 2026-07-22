package hn.ficohsa.msvc_ficohsa_insurance.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProjectsCatalog {
  MSVC_FICOHSA_INSURANCE("MSVC_FICOHSA_INSURANCE", "Microservicio de seguros de Ficohsa");

  private final String code;
  private final String description;
}
