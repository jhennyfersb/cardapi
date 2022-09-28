package com.amefastforwd.cardapi.controller;

import com.amefastforwd.cardapi.controller.request.CardRequest;
import com.amefastforwd.cardapi.exception.EntityNotFoundException;
import com.amefastforwd.cardapi.model.Card;
import com.amefastforwd.cardapi.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;
    private static final Logger LOG = LoggerFactory.getLogger(CardController.class);

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/{id}")
    public Card findCardById(@PathVariable("id") int id) throws EntityNotFoundException {
        LOG.info("Buscando card com id{}", id);
        return cardService.findById(id);
    }
    @GetMapping
    public List<Card> listCards() {
        LOG.info("Buscando todos as cartas");
        return cardService.listAll();
    }

    @PostMapping
    public  Card createCard(@RequestBody CardRequest cardRequest){
        LOG.info("Criando carta: [{}]", cardRequest);
        return cardService.createCard(cardRequest);
    }
    @PutMapping("/{id}")
    public Card updateCard(@PathVariable("id") long id,@RequestBody CardRequest cardRequest) throws EntityNotFoundException {
        LOG.info("Atualizando carta com id [{}]", id);
        return cardService.update(id,cardRequest);
    }

    @DeleteMapping("/{id}")
    void deleteCard(@PathVariable("id") long id ){
        LOG.info("Deletando carta com id[{}]", id);
        cardService.delete(id);
    }

}
