package com.usp.usparties.repository;

import com.usp.usparties.model.TicketPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketPostRepository extends JpaRepository<TicketPost, Long> {
    List<TicketPost> findAllBySalesman_Id(Long id);
}
