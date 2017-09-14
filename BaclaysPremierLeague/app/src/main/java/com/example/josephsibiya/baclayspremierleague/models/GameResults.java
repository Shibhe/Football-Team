package com.example.josephsibiya.baclayspremierleague.models;

/**
 * Created by josephsibiya on 2017/09/04.
 */

public class GameResults {

    private String goalsHomeTeam;
    private String goalsAwayTeam;
    private GameResults halftime;

    public String getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(String goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public String getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(String goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public GameResults getHalftime() {
        return halftime;
    }

    public void setHalftime(GameResults halftime) {
        this.halftime = halftime;
    }
}
