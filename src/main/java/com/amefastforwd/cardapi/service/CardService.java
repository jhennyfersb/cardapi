package com.amefastforwd.cardapi.service;

import com.amefastforwd.cardapi.model.Card;
import com.amefastforwd.cardapi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Optional<Card> findById(int id) {
        return this.cardRepository.findById(id);
    }
}
