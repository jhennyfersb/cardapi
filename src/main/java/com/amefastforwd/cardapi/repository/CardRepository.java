package com.amefastforwd.cardapi.repository;

import com.amefastforwd.cardapi.model.Card;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CardRepository {
    Optional<Card> findById(int id);

}
