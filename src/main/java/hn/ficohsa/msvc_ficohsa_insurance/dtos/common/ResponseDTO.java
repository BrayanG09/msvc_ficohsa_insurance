package hn.ficohsa.msvc_ficohsa_insurance.dtos.common;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import hn.ficohsa.msvc_ficohsa_insurance.documentation.dtos.ResponseDTODoc;
import hn.ficohsa.msvc_ficohsa_insurance.enums.ResponseCodeCatalog;
import hn.ficohsa.msvc_ficohsa_insurance.interfaces.CodeCatalog;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = ResponseDTODoc.DESCRIPTION)
public class ResponseDTO<T> {

  @Schema(description = ResponseDTODoc.CODE, example = ResponseDTODoc.CODE_EXAMPLE)
  private String code;

  @Schema(description = ResponseDTODoc.MESSAGE, example = ResponseDTODoc.MESSAGE_EXAMPLE)
  private String message;

  @Schema(description = ResponseDTODoc.DESCRIPTION_FIELD, example = ResponseDTODoc.DESCRIPTION_EXAMPLE)
  private String description;

  @Schema(description = ResponseDTODoc.TIMESTAMP, example = ResponseDTODoc.TIMESTAMP_EXAMPLE)
  private LocalDateTime timestamp;

  @Schema(description = ResponseDTODoc.DATA)
  private T data;

  public static <T> ResponseDTO<T> success(T data) {
    CodeCatalog codeCatalog = ResponseCodeCatalog.SUCCESS;

    return ResponseDTO.<T>builder()
        .code(codeCatalog.code())
        .message(codeCatalog.message())
        .description(codeCatalog.description())
        .timestamp(LocalDateTime.now())
        .data(data)
        .build();
  }

  public static <T> ResponseDTO<T> error(CodeCatalog codeCatalog, T data) {
    return ResponseDTO.<T>builder()
        .code(codeCatalog.code())
        .message(codeCatalog.message())
        .description(codeCatalog.description())
        .timestamp(LocalDateTime.now())
        .data(data)
        .build();
  }

  public ResponseDTO<T> withCustomMessage(String customMessage) {
    this.setMessage(customMessage);
    return this;
  }
}
