package com.example.josephsibiya.baclayspremierleague.models;

import android.support.annotation.NonNull;

/**
 * Created by josephsibiya on 2017/09/13.
 */

public class LeagueTable implements Comparable{

    private int position;
    private String teamName;
    private String crestURI;
    private String playedGames;
    private String points;
    private String goals;
    private String goalsAgainst;
    private String goalDifference;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    public String getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(String playedGames) {
        this.playedGames = playedGames;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(String goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public String getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(String goalDifference) {
        this.goalDifference = goalDifference;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        LeagueTable leagueTable = new LeagueTable();
        int table = leagueTable.getPosition();
        return  this.position-table;
    }
}
