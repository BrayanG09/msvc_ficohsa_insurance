package hn.ficohsa.msvc_ficohsa_insurance.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import hn.ficohsa.msvc_ficohsa_insurance.enums.QuotationStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quotations", schema = "ficohsa")
public class Quotation extends AuditEntity {
    @Id
    @UuidGenerator
    @Column(name = "quotation_id")
    private UUID quotationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id", nullable = false)
    private Insurance insurance;

    @Column(name = "applicant_name", nullable = false, length = 150)
    private String applicantName;

    @Column(name = "applicant_identity", nullable = false, length = 30)
    private String applicantIdentity;

    @Column(name = "applicant_email", length = 150)
    private String applicantEmail;

    @Column(name = "applicant_phone", length = 30)
    private String applicantPhone;

    @Column(name = "vehicle_year", nullable = false)
    private Integer vehicleYear;

    @Column(name = "vehicle_brand", nullable = false, length = 150)
    private String vehicleBrand;

    @Column(name = "vehicle_model", nullable = false, length = 150)
    private String vehicleModel;

    @Column(name = "vehicle_value", nullable = false, precision = 12, scale = 2)
    private BigDecimal vehicleValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private QuotationStatus status;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;
}
