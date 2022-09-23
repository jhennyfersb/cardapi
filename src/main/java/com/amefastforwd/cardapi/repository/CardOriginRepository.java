package com.amefastforwd.cardapi.repository;

import com.amefastforwd.cardapi.model.CardOrigin;

import java.util.Optional;

public interface CardOriginRepository {
    CardOrigin save(CardOrigin cardOrigin);
    Optional<CardOrigin> findById(int id);
}
