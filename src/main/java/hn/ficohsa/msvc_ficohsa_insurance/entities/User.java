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
@Table(name = "users", schema = "ficohsa")
public class User extends AuditEntity {

    @Id
    @UuidGenerator
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Quotation> quotations = new ArrayList<>();

}
