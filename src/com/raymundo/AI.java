package com.raymundo;

import java.util.List;

public class AI {

    private Score score;

    public AI(Score score) {
        this.score = score;
    }

    public int chooseCard(GameCore.State state, List<Integer> playerCards, List<Integer> enemyCards) {
        if (state == GameCore.State.ATTACK)
            return attack(enemyCards);
        else
            return defend(playerCards, enemyCards);

    }

    private int attack(List<Integer> enemyCards) {
        int max = enemyCards.get(0);
        for (Integer i : enemyCards) {
            if (i > max)
                max = i;
        }
        return max;
    }

    private int defend(List<Integer> playerCards, List<Integer> enemyCards) {
        if (score.getPlayerScore() > score.getEnemyScore()) {
            int sum = findAverage(playerCards);
            sum -= score.getEnemyScore();
            return findClosest(sum, enemyCards);
        } else if (score.getPlayerScore() < score.getEnemyScore()) {
            int sum = findAverage(playerCards);
            sum += score.getEnemyScore();
            return findClosest(sum, enemyCards);
        } else {
            int sum = findAverage(playerCards);
            return findClosest(sum, enemyCards);
        }
    }

    private int findClosest(int sum, List<Integer> enemyCards) {
        if (!enemyCards.contains(sum)) {
            for (int i = 0; i < enemyCards.size() - 1; i++) {
                if (enemyCards.get(i) < sum && enemyCards.get(i + 1) > sum) {
                    sum = enemyCards.get(i);
                    return sum;
                } else
                    sum = enemyCards.get(i);
            }
        }
        return sum;
    }

    private int findAverage(List<Integer> playerCards) {
        float sum = 0;
        for (Integer i : playerCards)
            sum += i;
        sum /= playerCards.size();
        return (int) sum;
    }
}