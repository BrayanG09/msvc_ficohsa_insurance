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
@Table(name = "insurance_categories", schema = "ficohsa")
public class InsuranceCategory extends AuditEntity {
    @Id
    @UuidGenerator
    @Column(name = "insurance_category_id")
    private UUID insuranceCategoryId;

    @Column(name = "category_name", nullable = false, length = 100)
    private String categoryName;

    @Column(name = "description")
    private String description;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Insurance> insurances = new ArrayList<>();

}
