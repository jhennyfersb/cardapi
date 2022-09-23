package com.amefastforwd.cardapi.controller;

import com.amefastforwd.cardapi.controller.request.CreateCardOriginRequest;
import com.amefastforwd.cardapi.exception.EntityNotFoundException;
import com.amefastforwd.cardapi.model.CardOrigin;
import com.amefastforwd.cardapi.service.CardOriginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card-origin")
public class CardOriginController {
    private static final Logger LOG = LoggerFactory.getLogger(CardController.class);

    private final CardOriginService cardOriginService;

    @Autowired
    public CardOriginController(CardOriginService cardOriginService){
        this.cardOriginService = cardOriginService;
    }
    @PostMapping
    public CardOrigin createCardOrigin(@RequestBody CreateCardOriginRequest createCardOriginRequest){
        LOG.info("Inserindo a origim : {}", createCardOriginRequest);
        return cardOriginService.createOriginCard(createCardOriginRequest);
    }
    @GetMapping("{id}")
    public CardOrigin findCardOriginById(@PathVariable("id") int id) throws EntityNotFoundException {
        LOG.info("Buscando origem com id : {}",id);
        return cardOriginService.findById(id);
    }


}
