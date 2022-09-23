package com.amefastforwd.cardapi.service;


import com.amefastforwd.cardapi.controller.request.CreateCardOriginRequest;
import com.amefastforwd.cardapi.exception.EntityNotFoundException;
import com.amefastforwd.cardapi.model.CardOrigin;
import com.amefastforwd.cardapi.repository.CardOriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardOriginService {
    private final CardOriginRepository cardOriginRepository;

    @Autowired
    public CardOriginService(CardOriginRepository cardOriginRepository) {
        this.cardOriginRepository = cardOriginRepository;
    }

    public CardOrigin findById(int id) throws EntityNotFoundException {
        return  this.cardOriginRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Card origin id[" + id + "not found]")) ;
    }
    public CardOrigin createOriginCard(CreateCardOriginRequest cardOriginRequest){
        var cardOrigin = new CardOrigin();

        cardOrigin.setName(cardOriginRequest.getName());
        cardOrigin.setDescription(cardOriginRequest.getDescription());
        cardOrigin.setCreator(cardOriginRequest.getCreator());

        cardOrigin.setCreateAt(LocalDateTime.now());
        cardOrigin.setUpdateAt(LocalDateTime.now());

        return cardOriginRepository.save(cardOrigin);
    }
}
