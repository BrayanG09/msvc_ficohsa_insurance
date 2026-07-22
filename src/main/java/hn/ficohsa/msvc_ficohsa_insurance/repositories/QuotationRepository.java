package hn.ficohsa.msvc_ficohsa_insurance.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.ficohsa.msvc_ficohsa_insurance.entities.Quotation;

public interface QuotationRepository extends JpaRepository<Quotation, UUID> {

}
