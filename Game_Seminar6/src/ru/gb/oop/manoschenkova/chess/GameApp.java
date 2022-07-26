package ru.gb.oop.manoschenkova.chess;

import ru.gb.oop.manoschenkova.chess.board.Board;

public class GameApp {

	public static void main(String[] args) {

		Board board = new Board();
		// TODO move to BoardBuilder
		board.placeFiguresOnOriginalPlaces();
		// TODO move some figures
		// save
		BoardManager boardManager = new BoardManager("chess-1.txt");
		boardManager.save(board);
		// load
		Board loadedBoard = boardManager.load();
		// save loaded to check
		new BoardManager("chess-2.txt").save(loadedBoard);
	}
}
