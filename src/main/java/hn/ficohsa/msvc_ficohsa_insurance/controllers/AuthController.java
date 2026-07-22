package hn.ficohsa.msvc_ficohsa_insurance.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.ficohsa.msvc_ficohsa_insurance.dtos.auth.AuthRequestDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.auth.AuthResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.common.ResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;
import hn.ficohsa.msvc_ficohsa_insurance.services.definitions.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/verify")
  public ResponseEntity<ResponseDTO<AuthResponseDTO>> verify(@Valid @RequestBody AuthRequestDTO request)
      throws FicohsaInsuranceException {
    return ResponseEntity.ok(ResponseDTO.success(this.authService.verify(request)));
  }
}
