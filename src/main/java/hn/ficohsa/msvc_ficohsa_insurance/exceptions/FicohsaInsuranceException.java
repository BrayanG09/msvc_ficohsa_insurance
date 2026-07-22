package hn.ficohsa.msvc_ficohsa_insurance.exceptions;

import hn.ficohsa.msvc_ficohsa_insurance.enums.LevelLogCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.enums.ProjectsCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.interfaces.CodeCatalog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FicohsaInsuranceException extends RuntimeException {
  private ProjectsCatalog project;
  private String type;
  private String process;
  private LevelLogCatalog level;
  private CodeCatalog codeCatalog;
  private String userIdentifier;
  private String metadata;
  private String path;
  private Exception exception;
  private String withCustomMessage;
}
