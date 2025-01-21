package com.biaginitests.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biaginitests.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
