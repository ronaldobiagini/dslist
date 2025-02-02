package com.biaginitests.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biaginitests.dslist.entities.Game;
import com.biaginitests.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {
    //O comando nativeQuery = true indica que a query está em sql, não jpql, que é o padrão
    @Query(nativeQuery = true, value = """
		SELECT games.id AS id, games.title AS title, games.game_year AS gameYear, games.img_url AS imgUrl,
		games.short_description AS shortDescription, belonging.position
		FROM games
		INNER JOIN belonging ON games.id = belonging.game_id
		WHERE belonging.list_id = :listId
		ORDER BY belonging.position
			""")
    List<GameMinProjection> searchByList(Long listId);
}
