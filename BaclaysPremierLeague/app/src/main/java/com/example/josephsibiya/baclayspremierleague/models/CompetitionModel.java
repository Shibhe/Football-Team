package com.example.josephsibiya.baclayspremierleague.models;

/**
 * Created by josephsibiya on 2017/08/31.
 */

public class CompetitionModel {

    private int id;
    private String caption;
    private String league;
    private String year;
    private String currentMatchDay;
    private String numberOfMatchDays;
    private String numberOfTeams;
    private String numberOfGames;
    private String lastUpdated;




    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCurrentMatchDay() {
        return currentMatchDay;
    }

    public void setCurrentMatchDay(String currentMatchDay) {
        this.currentMatchDay = currentMatchDay;
    }

    public String getNumberOfMatchDays() {
        return numberOfMatchDays;
    }

    public void setNumberOfMatchDays(String numberOfMatchDays) {
        this.numberOfMatchDays = numberOfMatchDays;
    }

    public String getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(String numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public String getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(String numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
