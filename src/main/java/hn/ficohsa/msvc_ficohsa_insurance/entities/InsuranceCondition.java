package hn.ficohsa.msvc_ficohsa_insurance.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Entity
@Table(name = "insurance_conditions", schema = "ficohsa")
public class InsuranceCondition extends AuditEntity {
    @Id
    @UuidGenerator
    @Column(name = "insurance_condition_id")
    private UUID insuranceConditionId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;

    @OneToMany(mappedBy = "condition", fetch = FetchType.LAZY)
    private List<InsuranceConditionMapping> insuranceMappings = new ArrayList<>();
}