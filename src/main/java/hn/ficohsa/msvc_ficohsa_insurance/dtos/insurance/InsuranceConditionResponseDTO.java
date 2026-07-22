package hn.ficohsa.msvc_ficohsa_insurance.dtos.insurance;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceConditionResponseDTO {
  private UUID insuranceConditionId;
  private String description;
}
