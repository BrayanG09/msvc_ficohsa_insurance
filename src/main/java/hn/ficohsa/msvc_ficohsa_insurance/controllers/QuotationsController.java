package hn.ficohsa.msvc_ficohsa_insurance.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.ficohsa.msvc_ficohsa_insurance.dtos.common.ResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.quotations.QuotationRequestDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.quotations.QuotationResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;
import hn.ficohsa.msvc_ficohsa_insurance.services.definitions.QuotationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/quotations")
@RequiredArgsConstructor
public class QuotationsController {
  private final QuotationService quotationService;

  @PostMapping
  public ResponseEntity<ResponseDTO<QuotationResponseDTO>> create(
      @Valid @RequestBody QuotationRequestDTO request) throws FicohsaInsuranceException {

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(ResponseDTO.success(this.quotationService.createQuotation(request)));
  }
}
