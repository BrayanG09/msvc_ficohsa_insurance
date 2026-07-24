package hn.ficohsa.msvc_ficohsa_insurance.dtos.insurance;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import hn.ficohsa.msvc_ficohsa_insurance.documentation.dtos.InsuranceResponseDTODoc;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = InsuranceResponseDTODoc.DESCRIPTION)
public class InsuranceResponseDTO {

  @Schema(description = InsuranceResponseDTODoc.INSURANCE_ID, example = InsuranceResponseDTODoc.INSURANCE_ID_EXAMPLE)
  private UUID insuranceId;

  @Schema(description = InsuranceResponseDTODoc.INSURANCE_NAME, example = InsuranceResponseDTODoc.INSURANCE_NAME_EXAMPLE)
  private String insuranceName;

  @Schema(description = InsuranceResponseDTODoc.DESCRIPTION_FIELD, example = InsuranceResponseDTODoc.DESCRIPTION_EXAMPLE)
  private String description;

  @Schema(description = InsuranceResponseDTODoc.PRICE, example = InsuranceResponseDTODoc.PRICE_EXAMPLE)
  private BigDecimal price;

  @Schema(description = InsuranceResponseDTODoc.CATEGORY)
  private InsuranceCategoryResponseDTO category;

  @Schema(description = InsuranceResponseDTODoc.CONDITIONS)
  private List<InsuranceConditionResponseDTO> conditions;
}
