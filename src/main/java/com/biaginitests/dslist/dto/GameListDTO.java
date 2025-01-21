package com.biaginitests.dslist.dto;

import com.biaginitests.dslist.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO() {
    }

    public GameListDTO(GameList gameList) {
        this.id = gameList.getId();
        this.name = gameList.getName();
        // Se usasse o BeanUtils, teria que implementar os set's e 
        // importar org.springframework.beans.BeanUtils
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }   
    
}
