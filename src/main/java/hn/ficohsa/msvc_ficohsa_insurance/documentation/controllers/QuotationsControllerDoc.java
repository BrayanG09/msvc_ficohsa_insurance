package hn.ficohsa.msvc_ficohsa_insurance.documentation.controllers;

public final class QuotationsControllerDoc {

  public static final String TAG_NAME = "Cotizaciones";
  public static final String TAG_DESCRIPTION = "Registro de cotizaciones de seguros vehiculares.";

  public static final String CREATE_SUMMARY = "Crear una cotizacion vehicular";
  public static final String CREATE_DESCRIPTION = """
      ## Objetivo

      Registra una solicitud de cotizacion asociada al usuario autenticado y a un
      producto de seguro existente.

      ## Flujo

      1. Se identifica al usuario a partir del JWT.
      2. Se valida que el usuario exista y este habilitado.
      3. Se valida que el seguro exista y este habilitado.
      4. Se persiste la cotizacion con estado inicial `PENDING`.

      ## Datos requeridos

      - Identificador del seguro (`insuranceId`)
      - Datos del solicitante (nombre e identidad; correo y telefono opcionales)
      - Datos del vehiculo (año, marca, modelo y valor)

      ## Respuesta exitosa

      Retorna `201 Created` con el identificador de la cotizacion generada
      dentro de `data.quotationId`.

      ## Errores frecuentes

      - Token ausente o invalido.
      - Seguro inexistente o deshabilitado.
      - Usuario inexistente o deshabilitado.
      - Campos invalidos.
      """;

  private QuotationsControllerDoc() {
  }
}
