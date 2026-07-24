package hn.ficohsa.msvc_ficohsa_insurance.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.ficohsa.msvc_ficohsa_insurance.documentation.OpenApiDoc;
import hn.ficohsa.msvc_ficohsa_insurance.documentation.controllers.QuotationsControllerDoc;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.common.ResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.quotations.QuotationRequestDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.quotations.QuotationResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;
import hn.ficohsa.msvc_ficohsa_insurance.services.definitions.QuotationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/quotations")
@RequiredArgsConstructor
@Tag(name = QuotationsControllerDoc.TAG_NAME, description = QuotationsControllerDoc.TAG_DESCRIPTION)
@SecurityRequirement(name = OpenApiDoc.SECURITY_SCHEME_NAME)
public class QuotationsController {
  private final QuotationService quotationService;

  @PostMapping
  @Operation(
      summary = QuotationsControllerDoc.CREATE_SUMMARY,
      description = QuotationsControllerDoc.CREATE_DESCRIPTION)
  public ResponseEntity<ResponseDTO<QuotationResponseDTO>> create(
      @Valid @RequestBody QuotationRequestDTO request) throws FicohsaInsuranceException {

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(ResponseDTO.success(this.quotationService.createQuotation(request)));
  }
}
