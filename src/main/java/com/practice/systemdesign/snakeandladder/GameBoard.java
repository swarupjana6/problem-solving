package com.practice.systemdesign.snakeandladder;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

class GameBoard {
    private Dice dice;
    private Queue<Player> nextTurn;
    private Map<Integer, Snake> snakes;
    private Map<Integer, Ladder> ladders;
    private Map<String, Integer> playersCurrentPosition;
    private int boardSize;
    private Set<Integer> snakeHeads;
    private Set<Integer> ladderBottoms;


    GameBoard(Dice dice, Queue<Player> nextTurn, Map<Integer, Snake> snakes, Map<Integer, Ladder> ladders, Map<String, Integer> playersCurrentPosition, int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playersCurrentPosition = playersCurrentPosition;
        this.boardSize = boardSize;
        this.snakeHeads = snakes.keySet();
        this.ladderBottoms = ladders.keySet();
    }

    void startGame() {
        while (nextTurn.size() > 0) {
            Player player = nextTurn.poll();
            int position = playersCurrentPosition.get(player.getPlayerName());
            int diceOutput = dice.rollDice();
            System.out.format("[%d] %s\t rolled dice %d \n", position, player.getPlayerName(), diceOutput);
            int expectedPosition = position + diceOutput;

            if (expectedPosition == boardSize) {
                System.out.println(player.getPlayerName() + " WON the game!!");
                break;
            }
            if (expectedPosition < boardSize) {
                int actualPosition = getActualPosition(player, expectedPosition);
                playersCurrentPosition.put(player.getPlayerName(), actualPosition);
                if (actualPosition == boardSize) {
                    System.out.println(player.getPlayerName() + " WON the game!!");
                    break;
                }
            }

            nextTurn.offer(player);
        }
    }

    private int getActualPosition(Player player, int expectedPosition) {
        int actualPosition = expectedPosition;
        if (positionHasSnake(expectedPosition)) {
            System.out.println(player.getPlayerName() + " Bitten by SNAKE present at: " + expectedPosition);
            actualPosition = snakeBottomPosition(expectedPosition);
        } else if (positionHasLadder(expectedPosition)) {
            System.out.println(player.getPlayerName() + " Got LADDER present at: " + expectedPosition);
            actualPosition = ladderTopPosition(expectedPosition);
        }
        return actualPosition;
    }

    private int ladderTopPosition(int position) {
        return ladders.get(position).getTop();
    }

    private int snakeBottomPosition(int position) {
        return snakes.get(position).getTail();
    }

    private boolean positionHasLadder(int position) {
        return ladderBottoms.contains(position);
    }

    private boolean positionHasSnake(int position) {
        return snakeHeads.contains(position);
    }
}
