package ru.gb.oop.manoschenkova.chess.board;

import ru.gb.oop.manoschenkova.chess.figures.Colour;
import ru.gb.oop.manoschenkova.chess.figures.Ferz;
import ru.gb.oop.manoschenkova.chess.figures.Figure;
import ru.gb.oop.manoschenkova.chess.figures.Kon;
import ru.gb.oop.manoschenkova.chess.figures.Korol;
import ru.gb.oop.manoschenkova.chess.figures.Ladiya;
import ru.gb.oop.manoschenkova.chess.figures.Peshka;
import ru.gb.oop.manoschenkova.chess.figures.Slon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class BoardManager {

	private String fileName;

	public BoardManager(String fileName) {

		this.fileName = fileName;
	}

	public Board load() {
		
		Board board = new Board();

		List<String> lines = loadFromFile();
		for (String line: lines) {
			String[] parts = line.split(" ");
			BoardColumn boardColumn = BoardColumn.valueOf(parts[0]);
			int row = Integer.parseInt(parts[1]);
			Colour colour = Colour.valueOf(parts[3]);
			Figure figure = createFigure(parts[2], colour); 
			
			board.placeFigure(boardColumn, row, figure);
		}
		
		return board;
	}

	private Figure createFigure(String className, Colour colour) {

		switch (className) {
			case "Ladiya": return new Ladiya(colour);
			case "Kon": return new Kon(colour);
			case "Slon": return new Slon(colour);
			case "Ferz": return new Ferz(colour);
			case "Korol": return new Korol(colour);
			case "Peshka": return new Peshka(colour);
			default:
				throw new IllegalArgumentException("Unknown figure class");
		}
	}

	public void save(Board board) {
		
		String textBoard = board.toText();
		writeToFile(textBoard);
	}

	private void writeToFile(String textBoard) {

		try {
			File file = new File(fileName);
			
			try (FileWriter fileWriter = new FileWriter(file, false)) {
				fileWriter.write(textBoard);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private List<String> loadFromFile() {

		try {
			File file = new File(fileName);
			return Files.readAllLines(file.toPath());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
