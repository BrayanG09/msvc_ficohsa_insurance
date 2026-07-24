package hn.ficohsa.msvc_ficohsa_insurance.dtos.insurance;

import java.util.UUID;

import hn.ficohsa.msvc_ficohsa_insurance.documentation.dtos.InsuranceCategoryResponseDTODoc;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = InsuranceCategoryResponseDTODoc.DESCRIPTION)
public class InsuranceCategoryResponseDTO {

  @Schema(
      description = InsuranceCategoryResponseDTODoc.INSURANCE_CATEGORY_ID,
      example = InsuranceCategoryResponseDTODoc.INSURANCE_CATEGORY_ID_EXAMPLE)
  private UUID insuranceCategoryId;

  @Schema(
      description = InsuranceCategoryResponseDTODoc.CATEGORY_NAME,
      example = InsuranceCategoryResponseDTODoc.CATEGORY_NAME_EXAMPLE)
  private String categoryName;
}
