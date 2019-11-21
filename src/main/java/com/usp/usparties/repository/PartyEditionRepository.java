package com.usp.usparties.repository;

import com.usp.usparties.model.PartyEdition;
import com.usp.usparties.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartyEditionRepository extends JpaRepository<PartyEdition, Long> {
    @Query(value = "SELECT pe FROM PartyEdition pe WHERE pe.party.academicCenter.id = ?1")
    List<PartyEdition> findAllByAcademicCenter(Long idAcademicCenter);
}
