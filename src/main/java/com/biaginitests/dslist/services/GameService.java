package com.biaginitests.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.biaginitests.dslist.dto.GameDTO;
import com.biaginitests.dslist.dto.GameMinDTO;
import com.biaginitests.dslist.entities.Game;
import com.biaginitests.dslist.projections.GameMinProjection;
import com.biaginitests.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // Informa que o método não faz alteração
    public GameDTO findById(Long id) {
        
        try {
            Game result = gameRepository.findById(id).get();
            GameDTO dto = new GameDTO(result);
            return dto;
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        
        
        
        
    }

    @Transactional(readOnly = true) // Informa que o método não faz alteração
    public List<GameMinDTO> findAll() { //GameMinDTO
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true) // Informa que o método não faz alteração
    public List<GameMinDTO> findByList(Long listId) { //GameMinDTO
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
