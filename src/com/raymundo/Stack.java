package com.raymundo;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Integer> playerCards;
    private List<Integer> enemyCards;

    public Stack() {
        playerCards = new ArrayList<Integer>();
        enemyCards = new ArrayList<Integer>();
        for (int i = 0; i <= 11; i++) {
            playerCards.add(i);
            enemyCards.add(i);
        }
    }

    public List<Integer> getPlayerCards() {
        return playerCards;
    }

    public List<Integer> getEnemyCards() {
        return enemyCards;
    }

}
