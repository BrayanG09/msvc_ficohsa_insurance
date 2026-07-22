package hn.ficohsa.msvc_ficohsa_insurance.entities;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Entity
@Table(name = "insurance_conditions_mapping", schema = "ficohsa")
public class InsuranceConditionMapping {
    @Id
    @UuidGenerator
    @Column(name = "insurance_condition_mapping_id")
    private UUID insuranceConditionMappingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id", nullable = false)
    private Insurance insurance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_condition_id", nullable = false)
    private InsuranceCondition condition;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;
}
