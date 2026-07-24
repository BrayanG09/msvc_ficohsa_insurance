package hn.ficohsa.msvc_ficohsa_insurance.dtos.auth;

import hn.ficohsa.msvc_ficohsa_insurance.documentation.dtos.AuthResponseDTODoc;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = AuthResponseDTODoc.DESCRIPTION)
public class AuthResponseDTO {

  @Schema(description = AuthResponseDTODoc.TOKEN, example = AuthResponseDTODoc.TOKEN_EXAMPLE)
  private String token;
}
