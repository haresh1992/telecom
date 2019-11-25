package com.telecom.repository;

import com.telecom.model.SimCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISimCardRepository extends JpaRepository<SimCard, Long> {

}
