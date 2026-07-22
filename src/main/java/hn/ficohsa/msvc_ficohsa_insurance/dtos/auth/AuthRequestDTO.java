package hn.ficohsa.msvc_ficohsa_insurance.dtos.auth;

import hn.ficohsa.msvc_ficohsa_insurance.utils.RegexConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthRequestDTO {
  @NotNull(message = "El nombre de usuario es obligatorio.")
  @NotBlank(message = "El nombre de usuario no puede estar vacío")
  @Size(max = 50, message = "El nombre de usuario no puede tener más de 50 caracteres")
  private String username;

  @NotNull(message = "La contraseña es obligatoria.")
  @NotBlank(message = "La contraseña no puede estar vacía")
  @Pattern(regexp = RegexConstants.PASSWORD_REGEX, message = "La contraseña debe tener al menos 6 caracteres, incluyendo una letra mayúscula, una letra minúscula, un número y un carácter especial.")
  private String password;
}
