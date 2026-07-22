package hn.ficohsa.msvc_ficohsa_insurance.dtos.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseDTO {
  private String token;
}
