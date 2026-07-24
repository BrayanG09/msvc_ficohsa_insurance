package hn.ficohsa.msvc_ficohsa_insurance.dtos.quotations;

import java.util.UUID;

import hn.ficohsa.msvc_ficohsa_insurance.documentation.dtos.QuotationResponseDTODoc;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = QuotationResponseDTODoc.DESCRIPTION)
public class QuotationResponseDTO {

  @Schema(description = QuotationResponseDTODoc.QUOTATION_ID, example = QuotationResponseDTODoc.QUOTATION_ID_EXAMPLE)
  private UUID quotationId;
}
