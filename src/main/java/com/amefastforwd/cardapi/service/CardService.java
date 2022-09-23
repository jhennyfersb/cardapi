package com.amefastforwd.cardapi.service;

import com.amefastforwd.cardapi.controller.request.CreateCardRequest;
import com.amefastforwd.cardapi.exception.EntityNotFoundException;
import com.amefastforwd.cardapi.model.Card;
import com.amefastforwd.cardapi.repository.CardOriginRepository;
import com.amefastforwd.cardapi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardService {
    private final CardRepository cardRepository;
    private CardOriginRepository cardOriginRepository;
    @Autowired
    public CardService(CardRepository cardRepository,CardOriginRepository cardOriginRepository) {
        this.cardRepository = cardRepository;
        this.cardOriginRepository = cardOriginRepository;
    }

    public Card findById(int id) throws EntityNotFoundException {
        return this.cardRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Card id [" + id + "] not found."));
    }
    public Card createCard(CreateCardRequest cardRequest) throws EntityNotFoundException {
        var cardOrigin = cardOriginRepository.findById(cardRequest.getOriginId())
                .orElseThrow(() -> new EntityNotFoundException("Card origin id ["+ cardRequest.getOriginId() + "] not found" ));
        var card = new Card();

        card.setName(cardRequest.getName());
        card.setDescription(cardRequest.getDescription());
        card.setImageUrl(cardRequest.getImageUrl());
        card.setStrength(cardRequest.getStrenght());
        card.setGear(cardRequest.getGear());
        card.setSkill(cardRequest.getSkill());
        card.setSpeed(cardRequest.getSpeed());
        card.setIntellect(cardRequest.getIntellect());
        card.setCardOrigin(cardOrigin);
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdateAt(LocalDateTime.now());
                return cardRepository.save(card);
    }

    public void deleteById(int id) {
        cardRepository.deleteById(id);
    }
}
