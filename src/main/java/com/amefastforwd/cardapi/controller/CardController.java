package com.amefastforwd.cardapi.controller;

import com.amefastforwd.cardapi.controller.request.CreateCardRequest;
import com.amefastforwd.cardapi.exception.EntityNotFoundException;
import com.amefastforwd.cardapi.model.Card;
import com.amefastforwd.cardapi.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;
    private static final Logger LOG = LoggerFactory.getLogger(CardController.class);

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/{id}")
    public Card findCardById(@PathVariable("id") int id) throws EntityNotFoundException {
        LOG.info("Buscando card com id{}", id);
        return cardService.findById(id);
    }

    @PostMapping
    public Card createCard(@RequestBody CreateCardRequest createRequest) throws EntityNotFoundException {
        LOG.info("Inserindo a card : {}", createRequest);
        return cardService.createCard(createRequest);
    }
    @DeleteMapping("/{id}")
    void deleteId(@PathVariable int id){
        cardService.deleteById(id);
    }

}
