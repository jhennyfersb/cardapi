package com.amefastforwd.cardapi;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.amefastforwd.cardapi.controller.request.CardRequest;
import com.amefastforwd.cardapi.exception.EntityNotFoundException;
import com.amefastforwd.cardapi.model.CardOrigin;
import com.amefastforwd.cardapi.repository.CardOriginRepository;
import com.amefastforwd.cardapi.repository.CardRepository;
import com.amefastforwd.cardapi.service.CardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class CardServiceTest {
    @Mock
    CardOriginRepository cardOriginRepository;

    @Mock
    CardRepository cardRepository;

    @InjectMocks
    CardService cardService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Retorno erro ao criar card sem origem")
    void shouldReturnErrorCreateCardWhereOriginNotFoud() {
        when(cardOriginRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> cardService.createCard(new CardRequest()));
        verify(cardRepository, never()).save(any());
    }

    @Test
    @DisplayName("Deve criar o card")
    void shouldSaveCardOnCreate() {
        var origin = new CardOrigin();
        origin.setId(1L);

        when(cardOriginRepository.findById(any())).thenReturn(Optional.of(origin));
        when(cardRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        var cardRequest = new CardRequest();
        cardRequest.setName(cardRequest.getName());
        cardRequest.setDescription(cardRequest.getDescription());
        cardRequest.setImageUrl(cardRequest.getImageUrl());
        cardRequest.setStrenght(cardRequest.getStrenght());
        cardRequest.setGear(cardRequest.getGear());
        cardRequest.setSkill(cardRequest.getSkill());
        cardRequest.setSpeed(cardRequest.getSpeed());
        cardRequest.setIntellect(cardRequest.getIntellect());

        var card = cardService.createCard(cardRequest);

        assertEquals(card.getName(), cardRequest.getName());
        assertEquals(card.getDescription(), cardRequest.getDescription());

    }
}
