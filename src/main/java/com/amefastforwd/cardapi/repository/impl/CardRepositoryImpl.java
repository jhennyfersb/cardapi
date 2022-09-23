package com.amefastforwd.cardapi.repository.impl;

import com.amefastforwd.cardapi.exception.InvalidEntityAttributeException;
import com.amefastforwd.cardapi.model.Card;
import com.amefastforwd.cardapi.repository.CardRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final List<Card> cards = new ArrayList<>();
    @Override
    public Optional<Card> findById(int id) {
        return cards.stream()
                .filter(card -> card.getId() == id)
                .findFirst();
    }

    @Override
    public Card save(Card card) {
        var cardFound = cards.stream()
                .filter(storedCard -> storedCard.getName().equalsIgnoreCase(card.getName()))
                .findFirst();
        if(cardFound.isPresent()){
            throw new InvalidEntityAttributeException("Card name [" + card.getName() + "] alredy stored");
        }
        card.setId(cards.size()+1);
        cards.add(card);
        return card;
    }
    @Override
    public void deleteById(int id) {
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getId() == id){
                cards.remove(cards.get(i));
            }
        }
    }
}
