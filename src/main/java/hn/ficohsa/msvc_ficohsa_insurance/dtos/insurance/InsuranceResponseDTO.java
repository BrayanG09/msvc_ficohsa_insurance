package hn.ficohsa.msvc_ficohsa_insurance.dtos.insurance;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceResponseDTO {
  private UUID insuranceId;
  private String insuranceName;
  private String description;
  private BigDecimal price;
  private InsuranceCategoryResponseDTO category;
  private List<InsuranceConditionResponseDTO> conditions;
}
