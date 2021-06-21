package com.raymundo;

import java.util.Scanner;

import static java.lang.Math.abs;

public class GameCore {

    public interface OnErrorListener {
        void printError();
    }

    public enum State {
        ATTACK,
        DEFENCE
    }

    public enum Winner {
        PLAYER,
        ENEMY,
        DRAW
    }

    private Stack stack;
    private Scanner scanner;
    private AI ai;
    private Score score;

    public GameCore(Stack stack, Scanner scanner, Score score, AI ai) {
        this.stack = stack;
        this.scanner = scanner;
        this.score = score;
        this.ai = ai;
    }

    public int requestPlayerCard(OnErrorListener onErrorListener) {
        int card = scanner.nextInt();
        while (!stack.getPlayerCards().contains(card)) {
            onErrorListener.printError();
            card = scanner.nextInt();
        }
        stack.getPlayerCards().remove((Integer) card);
        return card;
    }

    public int requestEnemyCard(State state) {
        int card = ai.chooseCard(state, stack.getPlayerCards(), stack.getEnemyCards());
        stack.getEnemyCards().remove((Integer) card);
        return card;
    }

    public void waitForUser() {
        scanner.next();
    }

    public int calculateResult(State state, int playerCard, int enemyCard) {
        int result = playerCard - enemyCard;
        if (state == State.ATTACK) {
            if (result < 0) {
                score.addEnemyScore(0);
                return 0;
            } else {
                score.addEnemyScore(result);
                return result;
            }
        } else {
            if (result > 0) {
                score.addPlayerScore(0);
                return 0;
            } else {
                score.addPlayerScore(abs(result));
                return abs(result);
            }
        }
    }

    public Winner chooseWinner() {
        int playerScore = score.getPlayerScore();
        int enemyScore = score.getEnemyScore();
        if (playerScore > enemyScore)
            return Winner.ENEMY;
        else if (playerScore < enemyScore)
            return Winner.PLAYER;
        else
            return Winner.DRAW;
    }

    public boolean isEnd() {
        if (stack.getPlayerCards().isEmpty() && stack.getEnemyCards().isEmpty())
            return true;
        else
            return false;
    }

}
