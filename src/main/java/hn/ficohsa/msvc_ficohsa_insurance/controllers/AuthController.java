package hn.ficohsa.msvc_ficohsa_insurance.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.ficohsa.msvc_ficohsa_insurance.documentation.controllers.AuthControllerDoc;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.auth.AuthRequestDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.auth.AuthResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.common.ResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;
import hn.ficohsa.msvc_ficohsa_insurance.services.definitions.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = AuthControllerDoc.TAG_NAME, description = AuthControllerDoc.TAG_DESCRIPTION)
public class AuthController {
  private final AuthService authService;

  @PostMapping("/verify")
  @Operation(
      summary = AuthControllerDoc.VERIFY_SUMMARY,
      description = AuthControllerDoc.VERIFY_DESCRIPTION)
  @SecurityRequirements
  public ResponseEntity<ResponseDTO<AuthResponseDTO>> verify(@Valid @RequestBody AuthRequestDTO request)
      throws FicohsaInsuranceException {
    return ResponseEntity.ok(ResponseDTO.success(this.authService.verify(request)));
  }
}
