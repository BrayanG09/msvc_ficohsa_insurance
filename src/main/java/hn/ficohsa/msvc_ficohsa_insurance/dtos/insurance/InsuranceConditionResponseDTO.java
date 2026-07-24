package hn.ficohsa.msvc_ficohsa_insurance.dtos.insurance;

import java.util.UUID;

import hn.ficohsa.msvc_ficohsa_insurance.documentation.dtos.InsuranceConditionResponseDTODoc;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = InsuranceConditionResponseDTODoc.DESCRIPTION)
public class InsuranceConditionResponseDTO {

  @Schema(
      description = InsuranceConditionResponseDTODoc.INSURANCE_CONDITION_ID,
      example = InsuranceConditionResponseDTODoc.INSURANCE_CONDITION_ID_EXAMPLE)
  private UUID insuranceConditionId;

  @Schema(
      description = InsuranceConditionResponseDTODoc.DESCRIPTION_FIELD,
      example = InsuranceConditionResponseDTODoc.DESCRIPTION_EXAMPLE)
  private String description;
}
