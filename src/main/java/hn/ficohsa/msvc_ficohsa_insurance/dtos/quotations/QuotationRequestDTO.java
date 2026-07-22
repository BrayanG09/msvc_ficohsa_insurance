package hn.ficohsa.msvc_ficohsa_insurance.dtos.quotations;

import java.math.BigDecimal;
import java.util.UUID;

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
public class QuotationRequestDTO {
  @NotNull(message = "El seguro es obligatorio")
  private UUID insuranceId;

  @NotBlank(message = "El nombre del solicitante es obligatorio")
  @Size(max = 150, message = "El nombre del solicitante no puede superar los 150 caracteres")
  private String applicantName;

  @NotBlank(message = "La identidad del solicitante es obligatoria")
  @Size(max = 30, message = "La identidad del solicitante no puede superar los 30 caracteres")
  private String applicantIdentity;

  @Email(message = "El correo electrónico no tiene un formato válido")
  @Size(max = 150, message = "El correo electrónico no puede superar los 150 caracteres")
  private String applicantEmail;

  @Size(max = 30, message = "El teléfono no puede superar los 30 caracteres")
  private String applicantPhone;

  @NotNull(message = "El año del vehículo es obligatorio")
  @Min(value = 1900, message = "El año del vehículo debe ser mayor a 1900")
  private Integer vehicleYear;

  @NotBlank(message = "La marca del vehículo es obligatoria")
  @Size(max = 150, message = "La marca del vehículo no puede superar los 150 caracteres")
  private String vehicleBrand;

  @NotBlank(message = "El modelo del vehículo es obligatorio")
  @Size(max = 150, message = "El modelo del vehículo no puede superar los 150 caracteres")
  private String vehicleModel;

  @NotNull(message = "El valor del vehículo es obligatorio")
  @DecimalMin(value = "0.01", message = "El valor del vehículo debe ser mayor a cero")
  private BigDecimal vehicleValue;
}
