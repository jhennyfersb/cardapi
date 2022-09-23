package com.amefastforwd.cardapi.repository.impl;

import com.amefastforwd.cardapi.exception.InvalidEntityAttributeException;
import com.amefastforwd.cardapi.model.CardOrigin;
import com.amefastforwd.cardapi.repository.CardOriginRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CardOriginRepositoryImpl implements CardOriginRepository {
    private final List<CardOrigin> cardOrigins = new ArrayList<>();

    @Override
    public Optional<CardOrigin> findById(int id) {
        return cardOrigins.stream()
                .filter(storedCard -> storedCard.getId() == id)
                .findFirst();
    }

    @Override
    public CardOrigin save(CardOrigin cardOrigin) {
        var cardOriginFound = cardOrigins.stream()
                .filter(storedCard -> storedCard.getName().equalsIgnoreCase(cardOrigin.getName()))
                .findFirst();
        if (cardOriginFound.isPresent()) {
            throw new InvalidEntityAttributeException("Card origin name[" + cardOrigin + " ] alredy stored");
        }

        cardOrigin.setId(cardOrigins.size() + 1);
        cardOrigins.add(cardOrigin);
        return cardOrigin;
    }
}
