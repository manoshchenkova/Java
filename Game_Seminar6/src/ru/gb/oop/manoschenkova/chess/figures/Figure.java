package ru.gb.oop.manoschenkova.chess.figures;

public abstract class Figure {
	
	private Colour colour;

	public Figure(Colour colour) {

		this.colour = colour;
	}

	public String getName() {
		
		return this.getClass().getSimpleName() + " " + this.colour.name();
	}
}
