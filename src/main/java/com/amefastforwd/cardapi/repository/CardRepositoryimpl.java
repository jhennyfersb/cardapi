package com.amefastforwd.cardapi.repository;

import com.amefastforwd.cardapi.model.Card;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CardRepositoryimpl implements CardRepository {

    private final List<Card> cards;

    public CardRepositoryimpl() {
        this.cards = new ArrayList<>();

        Card card = new Card();
        card.setId(1);
        card.setName("Iron Man");
        card.setImageUrl("ironManImageUrl");
        card.setStrength(5);
        card.setSpeed(5);
        card.setGear(5);
        card.setIntellect(8);
        card.setSkill(6);
        card.setCreatedAt(LocalDateTime.now());
        card.setCreatedAt(LocalDateTime.now());

        cards.add(card);

        card = new Card();
        card.setId(2);
        card.setName("Wonder Woman");
        card.setImageUrl("wonderWomanImageUrl");
        card.setStrength(6);
        card.setSpeed(7);
        card.setGear(7);
        card.setIntellect(5);
        card.setSkill(6);
        card.setCreatedAt(LocalDateTime.now());
        card.setCreatedAt(LocalDateTime.now());

        cards.add(card);

    }

    @Override
    public Optional<Card> findById(int id) {
        return cards.stream()
                .filter(card -> card.getId() == id)
                .findFirst();
    }
}
