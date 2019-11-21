package com.usp.usparties.repository;

import com.usp.usparties.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartyRepository extends JpaRepository<Party, Long> {
    List<Party> findAllByAcademicCenter_Id(Long idAcademicCenter);
}
