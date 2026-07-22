package hn.ficohsa.msvc_ficohsa_insurance.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.ficohsa.msvc_ficohsa_insurance.dtos.common.ResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.dtos.insurance.InsuranceResponseDTO;
import hn.ficohsa.msvc_ficohsa_insurance.exceptions.FicohsaInsuranceException;
import hn.ficohsa.msvc_ficohsa_insurance.services.definitions.InsuranceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class InsuranceController {
  private final InsuranceService insuranceService;

  @GetMapping
  public ResponseEntity<ResponseDTO<Page<InsuranceResponseDTO>>> findAll(
      @PageableDefault(page = 0, size = 10, sort = "insuranceName") Pageable pageable) throws FicohsaInsuranceException {

    return ResponseEntity.ok(ResponseDTO.success(this.insuranceService.findAll(pageable)));
  }
}
