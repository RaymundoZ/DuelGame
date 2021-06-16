package com.raymundo;

public class Score {
    private int playerScore;
    private int enemyScore;

    public Score() {
        playerScore = 0;
        enemyScore = 0;
    }

    public void addPlayerScore(int score) {
        playerScore += score;
    }

    public void addEnemyScore(int score) {
        enemyScore += score;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getEnemyScore() {
        return enemyScore;
    }
}
