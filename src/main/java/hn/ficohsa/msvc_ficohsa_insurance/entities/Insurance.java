package hn.ficohsa.msvc_ficohsa_insurance.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Entity
@Table(name = "insurances", schema = "ficohsa")
public class Insurance extends AuditEntity {

    @Id
    @UuidGenerator
    @Column(name = "insurance_id")
    private UUID insuranceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_category_id", nullable = false)
    private InsuranceCategory category;

    @Column(name = "insurance_name", nullable = false, length = 150)
    private String insuranceName;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;

    @OneToMany(
            mappedBy = "insurance",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<InsuranceConditionMapping> conditions = new ArrayList<>();

}