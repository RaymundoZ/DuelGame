package com.raymundo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);
        Score score = new Score();
        AI ai = new AI(score);
        GameCore gameCore = new GameCore(stack, scanner, score, ai);
        UI ui = new UI(gameCore, score);
        while (!gameCore.isEnd()) {
            ui.startPlayerTurn(stack.getPlayerCards(),
                    stack.getEnemyCards());
            ui.startEnemyTurn(stack.getPlayerCards(),
                    stack.getEnemyCards());
        }
        ui.endGame();
    }
}
