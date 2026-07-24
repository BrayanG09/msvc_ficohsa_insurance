package hn.ficohsa.msvc_ficohsa_insurance.repositories;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hn.ficohsa.msvc_ficohsa_insurance.entities.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {

  @Query("SELECT i.insuranceId FROM Insurance i WHERE i.enabled = true")
  Page<UUID> findEnabledInsuranceIds(Pageable pageable);

  @EntityGraph(attributePaths = {
      "category",
      "conditions",
      "conditions.condition"
  })
  @Query("SELECT DISTINCT i FROM Insurance i WHERE i.insuranceId IN :ids")
  List<Insurance> findAllWithDetailsByIdIn(@Param("ids") Collection<UUID> ids);

}
