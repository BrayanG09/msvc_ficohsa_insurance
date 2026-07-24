package hn.ficohsa.msvc_ficohsa_insurance.dtos.quotations;

import java.math.BigDecimal;
import java.util.UUID;

import hn.ficohsa.msvc_ficohsa_insurance.documentation.dtos.QuotationRequestDTODoc;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = QuotationRequestDTODoc.DESCRIPTION)
public class QuotationRequestDTO {

  @NotNull(message = "El seguro es obligatorio")
  @Schema(description = QuotationRequestDTODoc.INSURANCE_ID, example = QuotationRequestDTODoc.INSURANCE_ID_EXAMPLE)
  private UUID insuranceId;

  @NotBlank(message = "El nombre del solicitante es obligatorio")
  @Size(max = 150, message = "El nombre del solicitante no puede superar los 150 caracteres")
  @Schema(description = QuotationRequestDTODoc.APPLICANT_NAME, example = QuotationRequestDTODoc.APPLICANT_NAME_EXAMPLE)
  private String applicantName;

  @NotBlank(message = "La identidad del solicitante es obligatoria")
  @Size(max = 13, message = "La identidad del solicitante no puede superar los 13 caracteres")
  @Schema(description = QuotationRequestDTODoc.APPLICANT_IDENTITY, example = QuotationRequestDTODoc.APPLICANT_IDENTITY_EXAMPLE)
  private String applicantIdentity;

  @Email(message = "El correo electrónico no tiene un formato válido")
  @Size(max = 150, message = "El correo electrónico no puede superar los 150 caracteres")
  @Schema(description = QuotationRequestDTODoc.APPLICANT_EMAIL, example = QuotationRequestDTODoc.APPLICANT_EMAIL_EXAMPLE)
  private String applicantEmail;

  @Size(max = 30, message = "El teléfono no puede superar los 30 caracteres")
  @Schema(description = QuotationRequestDTODoc.APPLICANT_PHONE, example = QuotationRequestDTODoc.APPLICANT_PHONE_EXAMPLE)
  private String applicantPhone;

  @NotNull(message = "El año del vehículo es obligatorio")
  @Min(value = 1900, message = "El año del vehículo debe ser mayor a 1900")
  @Schema(description = QuotationRequestDTODoc.VEHICLE_YEAR, example = QuotationRequestDTODoc.VEHICLE_YEAR_EXAMPLE)
  private Integer vehicleYear;

  @NotBlank(message = "La marca del vehículo es obligatoria")
  @Size(max = 150, message = "La marca del vehículo no puede superar los 150 caracteres")
  @Schema(description = QuotationRequestDTODoc.VEHICLE_BRAND, example = QuotationRequestDTODoc.VEHICLE_BRAND_EXAMPLE)
  private String vehicleBrand;

  @NotBlank(message = "El modelo del vehículo es obligatorio")
  @Size(max = 150, message = "El modelo del vehículo no puede superar los 150 caracteres")
  @Schema(description = QuotationRequestDTODoc.VEHICLE_MODEL, example = QuotationRequestDTODoc.VEHICLE_MODEL_EXAMPLE)
  private String vehicleModel;

  @NotNull(message = "El valor del vehículo es obligatorio")
  @DecimalMin(value = "0.01", message = "El valor del vehículo debe ser mayor a cero")
  @Schema(description = QuotationRequestDTODoc.VEHICLE_VALUE, example = QuotationRequestDTODoc.VEHICLE_VALUE_EXAMPLE)
  private BigDecimal vehicleValue;
}
