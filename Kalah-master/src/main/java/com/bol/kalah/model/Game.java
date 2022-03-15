package com.bol.kalah.model;

import java.util.Arrays;

public class Game {

    public static final int TOTAL_HOUSES = 14;
    public static final int PLAYER_ONE_HOUSE = 6;
    public static final int PLAYER_TWO_HOUSE = 13;
    private int[] houses;

    public Game() {
        houses[PLAYER_ONE_HOUSE] = 0;
        houses[PLAYER_TWO_HOUSE] = 0;
        houses = new int[TOTAL_HOUSES];
        Arrays.fill(houses, 6);
    }

    public int getHouseValue(int index) {
        return houses[index];
    }

    public void setHouseValue(int index, int value) {
        houses[index] = value;
    }

    public void addToHouseValue(int index, int value) {
        houses[index] += value;
    }

    public void addToMainHouseTwoOppositePit(int mainHouse, int houseIndex) {
        houses[mainHouse] += houses[houseIndex] + houses[12 - houseIndex];
    }

    public int[] getHouses() {
        return houses.clone();
    }
}
