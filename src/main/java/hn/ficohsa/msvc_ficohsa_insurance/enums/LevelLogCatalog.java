package hn.ficohsa.msvc_ficohsa_insurance.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LevelLogCatalog {
  INFO("INFO", "Información"),
  WARN("WARN", "Advertencia"),
  ERROR("ERROR", "Error"),
  DEBUG("DEBUG", "Depuración");

  private final String code;
  private final String description;
}
