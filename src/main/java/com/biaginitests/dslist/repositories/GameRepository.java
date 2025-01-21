package com.biaginitests.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biaginitests.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
