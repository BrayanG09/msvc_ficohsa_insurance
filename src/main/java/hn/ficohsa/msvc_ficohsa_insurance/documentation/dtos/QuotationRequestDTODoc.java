package hn.ficohsa.msvc_ficohsa_insurance.documentation.dtos;

public final class QuotationRequestDTODoc {

  public static final String DESCRIPTION = "Datos necesarios para registrar una cotizacion vehicular.";
  public static final String INSURANCE_ID = "Identificador UUID del producto de seguro a cotizar.";
  public static final String APPLICANT_NAME = "Nombre completo del solicitante. Maximo 150 caracteres.";
  public static final String APPLICANT_IDENTITY = "Documento de identidad del solicitante. Maximo 13 caracteres.";
  public static final String APPLICANT_EMAIL = "Correo electronico del solicitante. Opcional.";
  public static final String APPLICANT_PHONE = "Telefono de contacto del solicitante. Opcional. Maximo 30 caracteres.";
  public static final String VEHICLE_YEAR = "Anio de fabricacion del vehiculo. Debe ser mayor o igual a 1900.";
  public static final String VEHICLE_BRAND = "Marca del vehiculo. Maximo 150 caracteres.";
  public static final String VEHICLE_MODEL = "Modelo del vehiculo. Maximo 150 caracteres.";
  public static final String VEHICLE_VALUE = "Valor comercial del vehiculo. Debe ser mayor a cero.";

  public static final String INSURANCE_ID_EXAMPLE = "3fa85f64-5717-4562-b3fc-2c963f66afa6";
  public static final String APPLICANT_NAME_EXAMPLE = "Brayan Alvarez";
  public static final String APPLICANT_IDENTITY_EXAMPLE = "0803200000084";
  public static final String APPLICANT_EMAIL_EXAMPLE = "10brayanalvarez@gmail.com";
  public static final String APPLICANT_PHONE_EXAMPLE = "94863990";
  public static final String VEHICLE_YEAR_EXAMPLE = "2022";
  public static final String VEHICLE_BRAND_EXAMPLE = "Ford";
  public static final String VEHICLE_MODEL_EXAMPLE = "Mustang";
  public static final String VEHICLE_VALUE_EXAMPLE = "350000.00";

  private QuotationRequestDTODoc() {
  }
}
