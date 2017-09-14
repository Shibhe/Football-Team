package com.example.josephsibiya.baclayspremierleague.models;

/**
 * Created by josephsibiya on 2017/08/31.
 */

public class TeamsModel {

    private int Id;
    private String name;
    private String code;
    private  String shortName;
    private  String squadMarketValue;
    private String crestUrl;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public void setSquadMarketValue(String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
