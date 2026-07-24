package hn.ficohsa.msvc_ficohsa_insurance.dtos.auth;

import hn.ficohsa.msvc_ficohsa_insurance.documentation.dtos.AuthRequestDTODoc;
import hn.ficohsa.msvc_ficohsa_insurance.utils.RegexConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = AuthRequestDTODoc.DESCRIPTION)
public class AuthRequestDTO {

  @NotNull(message = "El nombre de usuario es obligatorio.")
  @NotBlank(message = "El nombre de usuario no puede estar vacío")
  @Size(max = 50, message = "El nombre de usuario no puede tener más de 50 caracteres")
  @Schema(description = AuthRequestDTODoc.USERNAME, example = AuthRequestDTODoc.USERNAME_EXAMPLE)
  private String username;

  @NotNull(message = "La contraseña es obligatoria.")
  @NotBlank(message = "La contraseña no puede estar vacía")
  @Pattern(regexp = RegexConstants.PASSWORD_REGEX, message = "La contraseña debe tener al menos 6 caracteres, incluyendo una letra mayúscula, una letra minúscula, un número y un carácter especial.")
  @Schema(description = AuthRequestDTODoc.PASSWORD, example = AuthRequestDTODoc.PASSWORD_EXAMPLE)
  private String password;
}
