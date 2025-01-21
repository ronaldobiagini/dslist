package com.biaginitests.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.biaginitests.dslist.entities.Game;

public class GameDTO {
    private Long id;
	private String title;
    private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;	
    private String shortDescription;	
	private String longDescription;

    public GameDTO() {};

    public GameDTO(Game game) {
        BeanUtils.copyProperties(game, this); // Precisa ter get e set
        /*
        this.id = game.getId();
        this.title = game.getTitle();
        this.year = game.getYear();
        this.genre = game.getGenre();
        this.platforms = game.getPlatforms();
        this.score = game.getScore();
        this.imgUrl = game.getImgUrl();
        this.shortDescription = game.getShortDescription();
        this.longDescription = game.getLongDescription();
        */
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    
}
