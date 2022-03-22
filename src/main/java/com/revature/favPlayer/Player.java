package com.revature.favPlayer;

public class Player {
    private Integer playerID;
    private String playerName;
    private String sport;
    private Integer number;

    public Player (int playerID, String playerName, String sport, int number) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.sport = sport;
        this.number = number;
    }

    public Player(Integer playerID, String playerName, String sport, Integer number) {
        setPlayerID(playerID);
        setPlayerName(playerName);
        setSport(sport);
        setNumber(number);
    }

    public Integer getPlayerID(){
        return playerID;
    }
    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getSport() {
        return sport;
    }
    public void setSport(String sport) {
        this.sport = sport;
    }

    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number ) {
        this.number = number;
        }

    @Override
    public String toString() {
        return "Player [playerID=" + playerID + ", playerName=" + playerName + ", sport=" + sport + ", number=" + number + "]";
    }
}
