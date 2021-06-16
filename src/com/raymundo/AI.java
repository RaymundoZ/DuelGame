package com.raymundo;

import java.util.List;

public class AI {

    private Score score;

    public AI(Score score) {
        this.score = score;
    }

    public int chooseCard(GameCore.State state, List<Integer> playerCards, List<Integer> enemyCards) {
        if(state == GameCore.State.ATTACK) {
            int max = enemyCards.get(0);
            for(Integer i: enemyCards) {
                if(i > max)
                    max = i;
            }
            return max;
        } else {
            if(score.getPlayerScore() > score.getEnemyScore()) {
                float sum = 0;
                for(Integer i: playerCards)
                    sum += i;
                sum /= playerCards.size();
                sum -= score.getEnemyScore();
                if(!enemyCards.contains((int) sum)) {
                    for(int i = 0; i < enemyCards.size() - 1; i++) {
                        if(enemyCards.get(i) < (int) sum && enemyCards.get(i + 1) > (int) sum) {
                            sum = enemyCards.get(i);
                            return (int) sum;
                        } else
                            sum = enemyCards.get(i);
                    }
                }
                return (int) sum;
            } else if(score.getPlayerScore() < score.getEnemyScore()) {
                float sum = 0;
                for(Integer i: playerCards)
                    sum += i;
                sum /= playerCards.size();
                sum += score.getEnemyScore();
                if(!enemyCards.contains((int) sum)) {
                    for(int i = 0; i < enemyCards.size() - 1; i++) {
                        if(enemyCards.get(i) < (int) sum && enemyCards.get(i + 1) > (int) sum) {
                            sum = enemyCards.get(i);
                            return (int) sum;
                        } else
                            sum = enemyCards.get(i);
                    }
                }
                return (int) sum;
            } else {
                float sum = 0;
                for(Integer i: playerCards)
                    sum += i;
                sum /= playerCards.size();
                if(!enemyCards.contains((int) sum)) {
                    for(int i = 0; i < enemyCards.size() - 1; i++) {
                        if(enemyCards.get(i) < (int) sum && enemyCards.get(i + 1) > (int) sum) {
                            sum = enemyCards.get(i);
                            return (int) sum;
                        } else
                            sum = enemyCards.get(i);
                    }
                }
                return (int) sum;
            }
        }
//        float sum = 0;
//        for(Integer i: playerCards)
//            sum += i;
//        while(sum > 11)
//            sum /= 2;
//        if(!enemyCards.contains((int) sum)) {
//            for(int i = 0; i < enemyCards.size() - 1; i++) {
//                if(sum > enemyCards.get(i) && sum < enemyCards.get(i + 1)) {
//                    sum = enemyCards.get(i);
//                    return (int) sum;
//                }
//            }
//        }
//        return (int)sum;
    }
}
