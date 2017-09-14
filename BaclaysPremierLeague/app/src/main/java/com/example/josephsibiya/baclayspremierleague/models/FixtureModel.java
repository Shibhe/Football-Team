package com.example.josephsibiya.baclayspremierleague.models;

/**
 * Created by josephsibiya on 2017/09/01.
 */

public class FixtureModel {

    private int id;
    private String date;
    private String status;
    private String matchDay;
    private String odds;
    //private GameResults gameGoals;
    private String homeTeamName;
    private String awayTeamName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(String matchDay) {
        this.matchDay = matchDay;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    /**public GameResults getGameGoals() {
        return gameGoals;
    }

    public void setGameGoals(GameResults gameGoals) {
        this.gameGoals = gameGoals;
    }**/

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }


    public enum Status
    {
        FINISHED,
        TIMED,
        SCHEDULED
    }
}
