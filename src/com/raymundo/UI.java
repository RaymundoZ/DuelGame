package com.raymundo;

import java.util.List;

public class UI {

    private GameCore gameCore;

    public UI(GameCore gameCore) {
        this.gameCore = gameCore;
        System.out.println(
                "// ИГРА НАЧАЛАСЬ! //"
        );
    }

    public void startPlayerTurn(List<Integer> playerCards, List<Integer> enemyCards) {
        int playerCard;
        int enemyCard;
        int result;
        System.out.println(
                "// ВЫ АТАКУЕТЕ // \n" +
                        "Ваша рука: "
        );
        showCards(playerCards);
        System.out.println(
                "Рука противника: "
        );
        showCards(enemyCards);
        System.out.println(
                "Выберите карту"
        );
        playerCard = gameCore.requestPlayerCard();
        enemyCard = gameCore.requestEnemyCard(GameCore.State.DEFENCE);
        System.out.println(
                "// ВЫ СДЕЛАЛИ ВЫБОР: " + playerCard + " // \n" +
                        "// ВЫБОР ПРОТИВНИКА: " + enemyCard + " //"
        );
        result = gameCore.calculateResult(GameCore.State.ATTACK, playerCard, enemyCard);
        System.out.println(
                "// РЕЗУЛЬТАТ РАУНДА // \n" +
                        "Противик получает " + result + " штрафных очков \n" +
                        "// КОНЕЦ ХОДА // \n\n" +
                        "Для продолжения введите любой символ"
        );
        gameCore.waitForUser();
    }

    public void startEnemyTurn(List<Integer> playerCards, List<Integer> enemyCards) {
        int playerCard;
        int enemyCard;
        int result;
        System.out.println(
                "// ВЫ ЗАЩИЩАЕТЕСЬ // \n" +
                        "Ваша рука: "
        );
        showCards(playerCards);
        System.out.println(
                "Рука противника: "
        );
        showCards(enemyCards);
        System.out.println(
                "Выберите карту"
        );
        playerCard = gameCore.requestPlayerCard();
        enemyCard = gameCore.requestEnemyCard(GameCore.State.ATTACK);
        System.out.println(
                "// ВЫ СДЕЛАЛИ ВЫБОР: " + playerCard + " // \n" +
                        "// ВЫБОР ПРОТИВНИКА: " + enemyCard + " //"
        );
        result = gameCore.calculateResult(GameCore.State.DEFENCE, playerCard, enemyCard);
        System.out.println(
                "// РЕЗУЛЬТАТЫ РАУНДА // \n" +
                        "Вы получаете " + result + " штрафных очков \n" +
                        "// КОНЕЦ ХОДА // \n\n" +
                        "Для продолжения введите любой символ"
        );
        gameCore.waitForUser();
    }

    public void endGame() {
        GameCore.Winner winner = gameCore.chooseWinner();
        if (winner == GameCore.Winner.PLAYER)
            System.out.println("Победа игрока!");
        else if (winner == GameCore.Winner.ENEMY)
            System.out.println("Победа противника!");
        else
            System.out.println("Ничья!");
        System.out.println("// КОНЕЦ ИГРЫ //");
    }

    private void showCards(List<Integer> cards) {
        for (Integer i : cards)
            System.out.print(i + " ");
        System.out.println();
    }


}
