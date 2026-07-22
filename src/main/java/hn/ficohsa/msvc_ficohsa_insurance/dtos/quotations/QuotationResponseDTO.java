package hn.ficohsa.msvc_ficohsa_insurance.dtos.quotations;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuotationResponseDTO {
  private UUID quotationId;
}
