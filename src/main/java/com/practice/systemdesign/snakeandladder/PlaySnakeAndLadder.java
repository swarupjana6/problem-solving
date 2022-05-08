package com.practice.systemdesign.snakeandladder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PlaySnakeAndLadder {

    public static void main(String[] args) {
        Dice dice = new Dice(1);
        Player playerOne = new Player("Changu", 1);
        Player playerTwo = new Player("Mangu", 2);
        Queue<Player> allPlayers = new LinkedList<>(List.of(playerOne, playerTwo));
        Map<Integer, Snake> snakes = Map.of(10, new Snake(10, 2), 99, new Snake(99, 12));
        Map<Integer, Ladder> ladders = Map.of(5, new Ladder(25, 5), 40, new Ladder(89, 40));
        Map<String, Integer> playerPosition = new HashMap<>(Map.of(playerOne.getPlayerName(), 0, playerTwo.getPlayerName(), 0));
        GameBoard gb = new GameBoard(dice, allPlayers, snakes, ladders, playerPosition, 100);
        gb.startGame();
    }
}
