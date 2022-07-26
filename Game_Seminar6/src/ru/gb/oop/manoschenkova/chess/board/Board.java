package ru.gb.oop.manoschenkova.chess.board;

import ru.gb.oop.manoschenkova.chess.figures.Colour;
import ru.gb.oop.manoschenkova.chess.figures.Ferz;
import ru.gb.oop.manoschenkova.chess.figures.Figure;
import ru.gb.oop.manoschenkova.chess.figures.Kon;
import ru.gb.oop.manoschenkova.chess.figures.Korol;
import ru.gb.oop.manoschenkova.chess.figures.Ladiya;
import ru.gb.oop.manoschenkova.chess.figures.Peshka;
import ru.gb.oop.manoschenkova.chess.figures.Slon;

import java.util.HashMap;
import java.util.Map;

public class Board {
	
	private Figure[][] board = new Figure[8][8];

	public Board() {
		
	}

	public void placeFiguresOnOriginalPlaces() {
		placeFigure(BoardColumn.A, 2, new Peshka(Colour.WHITE));
		placeFigure(BoardColumn.B, 2, new Peshka(Colour.WHITE));
		placeFigure(BoardColumn.C, 2, new Peshka(Colour.WHITE));
		placeFigure(BoardColumn.D, 2, new Peshka(Colour.WHITE));
		placeFigure(BoardColumn.E, 2, new Peshka(Colour.WHITE));
		placeFigure(BoardColumn.F, 2, new Peshka(Colour.WHITE));
		placeFigure(BoardColumn.G, 2, new Peshka(Colour.WHITE));
		placeFigure(BoardColumn.H, 2, new Peshka(Colour.WHITE));

		placeFigure(BoardColumn.A, 1, new Ladiya(Colour.WHITE));
		placeFigure(BoardColumn.B, 1, new Kon(Colour.WHITE));
		placeFigure(BoardColumn.C, 1, new Slon(Colour.WHITE));
		placeFigure(BoardColumn.D, 1, new Ferz(Colour.WHITE));
		placeFigure(BoardColumn.E, 1, new Korol(Colour.WHITE));
		placeFigure(BoardColumn.F, 1, new Slon(Colour.WHITE));
		placeFigure(BoardColumn.G, 1, new Kon(Colour.WHITE));
		placeFigure(BoardColumn.H, 1, new Ladiya(Colour.WHITE));

		placeFigure(BoardColumn.A, 7, new Peshka(Colour.BLACK));
		placeFigure(BoardColumn.B, 7, new Peshka(Colour.BLACK));
		placeFigure(BoardColumn.C, 7, new Peshka(Colour.BLACK));
		placeFigure(BoardColumn.D, 7, new Peshka(Colour.BLACK));
		placeFigure(BoardColumn.E, 7, new Peshka(Colour.BLACK));
		placeFigure(BoardColumn.F, 7, new Peshka(Colour.BLACK));
		placeFigure(BoardColumn.G, 7, new Peshka(Colour.BLACK));
		placeFigure(BoardColumn.H, 7, new Peshka(Colour.BLACK));

		placeFigure(BoardColumn.A, 8, new Ladiya(Colour.BLACK));
		placeFigure(BoardColumn.B, 8, new Kon(Colour.BLACK));
		placeFigure(BoardColumn.C, 8, new Slon(Colour.BLACK));
		placeFigure(BoardColumn.D, 8, new Ferz(Colour.BLACK));
		placeFigure(BoardColumn.E, 8, new Korol(Colour.BLACK));
		placeFigure(BoardColumn.F, 8, new Slon(Colour.BLACK));
		placeFigure(BoardColumn.G, 8, new Kon(Colour.BLACK));
		placeFigure(BoardColumn.H, 8, new Ladiya(Colour.BLACK));
	}

	public void placeFigure(BoardColumn column, int row, Figure figure) {
		board[row - 1][column.getColumn() - 1] = figure;
	}

	public String toText() {

		Map<Integer, BoardColumn> columnMapper = new HashMap<>();
		for (BoardColumn boardColumn : BoardColumn.values()) {
			columnMapper.put(boardColumn.getColumn() - 1, boardColumn);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Figure figure = board[i][j];
				if(figure != null) {
					BoardColumn column = columnMapper.get(j);
					sb.append(column.name()); // A
					sb.append(" ");
					sb.append(i + 1); // 1
					sb.append(" ");
					sb.append(figure.getName());
					sb.append("\n");
				}
			}
		}
		return sb.toString().trim();
	}
}
