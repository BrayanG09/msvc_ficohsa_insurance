package hn.ficohsa.msvc_ficohsa_insurance.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "logs", schema = "ficohsa")
public class Log {
  @Id
  @UuidGenerator
  @Column(name = "log_id")
  private UUID logId; 

  @Column(name = "project", length = 100)
  private String project;

  @Column(name = "type", length = 50)
  private String type;

  @Column(name = "process", length = 100)
  private String process;

  @Column(name = "level", length = 20)
  private String level;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "message", length = 500)
  private String message;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "http_code")
  private Integer httpCode;


  @Column(name = "user_identifier", length = 150)
  private String userIdentifier;

  @Column(name = "metadata", columnDefinition = "TEXT")
  private String metadata;

  @Column(name = "path", length = 500)
  private String path;

  @Column(name = "exception_class", length = 255)
  private String exceptionClass;

  @Column(name = "exception_message", columnDefinition = "TEXT")
  private String exceptionMessage;

  @Column(name = "exception_cause_class", length = 255)
  private String exceptionCauseClass;

  @Column(name = "exception_cause_message", columnDefinition = "TEXT")
  private String exceptionCauseMessage;

  @Column(name = "exception_stack_trace", columnDefinition = "TEXT")
  private String exceptionStackTrace;
  

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  
  @PrePersist
  void onCreate() {
    if (Objects.isNull(createdAt)) {
      createdAt = LocalDateTime.now();
    }
  }
}
