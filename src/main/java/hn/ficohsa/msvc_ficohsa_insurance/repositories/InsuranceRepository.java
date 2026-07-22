package hn.ficohsa.msvc_ficohsa_insurance.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import hn.ficohsa.msvc_ficohsa_insurance.entities.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {
  @EntityGraph(attributePaths = {
      "category",
      "conditions",
      "conditions.condition"
  })
  Page<Insurance> findByEnabledTrue(Pageable pageable);

}
