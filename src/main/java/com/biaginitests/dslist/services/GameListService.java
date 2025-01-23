package com.biaginitests.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.biaginitests.dslist.dto.GameListDTO;
import com.biaginitests.dslist.dto.GameMinDTO;
import com.biaginitests.dslist.entities.GameList;
import com.biaginitests.dslist.projections.GameMinProjection;
import com.biaginitests.dslist.repositories.GameListRepository;
import com.biaginitests.dslist.repositories.GameRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // Informa que o método não faz alteração
    public List<GameListDTO> findAll() { //GameMinDTO
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection objTemp = list.remove(sourceIndex);
        list.add(destinationIndex, objTemp);

        int min = sourceIndex < destinationIndex ? sourceIndex:destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex:sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
