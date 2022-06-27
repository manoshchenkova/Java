// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

package ru.gb.java.manoschenkova.queen;

import java.util.ArrayList;
import java.util.Scanner;

public class QueenApp {

    public static boolean findPosition(int queenAmount, ArrayList<Position> queens) {
        if (queens.size() >= queenAmount) {
            return true;
        }

        int row = queens.size() + 1;
        for (int col = 1; col <= queenAmount; col++) {
            Position queenCheck = new Position(row, col);

            boolean attack = false;
            for (Position queen: queens) {
                if (queen.isAttack(queenCheck)) {
                    attack = true;
                    break;
                }
            }
            if (attack) {
                continue;
            }

            queens.add(queenCheck);
            if (findPosition(queenAmount, queens)) {
                return true;
            } else {
                queens.remove(queenCheck);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // Получить размер поля и количество ферзей
        Scanner queenScanner = new Scanner(System.in);
        System.out.println("Please enter the number of queens (min is 4, max is 8)");
        int queenAmount = queenScanner.nextInt();

        if (queenAmount < 4 || queenAmount > 8) {
            System.out.println("Please enter the number between 4 and 8");
            return;
        }

        // рассчитать координаты для заданного количества ферзей по принципу коня

        ArrayList<Position> queenPositions = new ArrayList<>();
        boolean success = findPosition(queenAmount, queenPositions);
        if (!success) {
            System.out.println("Can't place queens");
            return;
        }

        // Сгенерировать матрицу для визуализации
        char[][] chessBoard = new char [queenAmount][queenAmount];
        for (int i = 0; i < queenAmount; i++) {
            for (int j = 0; j < queenAmount; j++) {
                chessBoard[i][j] = 'O';
            }
        }

        // Заполнить матрицу ферзями
        for (Position queen : queenPositions) {
            chessBoard[queen.getRow()-1][queen.getColumn()-1] = 'X';
        }

        // Вывести матрицу на экран
        for (int i = 0; i < queenAmount; i++) {
            for (int j = 0; j < queenAmount; j++) {
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }

    }

}
