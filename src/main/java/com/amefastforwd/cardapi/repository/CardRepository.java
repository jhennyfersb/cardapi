package com.amefastforwd.cardapi.repository;

import com.amefastforwd.cardapi.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CardRepository extends JpaRepository<Card, Long> {

}
