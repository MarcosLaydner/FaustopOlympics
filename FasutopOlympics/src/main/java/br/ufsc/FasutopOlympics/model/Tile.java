package br.ufsc.FasutopOlympics.model;

public class Tile {
	
	private int line;
	private int column;
	private TILETYPE tileType;
	private Question question;
	private boolean valid;
	private boolean trapped;
	
	public Tile() {
	}
	
	public Tile(int line, int column, TILETYPE tiletype, Question question, boolean valid, boolean trapped) {
		
	}
	
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public TILETYPE getTileType() {
		return tileType;
	}
	public void setTileType(TILETYPE tileType) {
		this.tileType = tileType;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public boolean isTrapped() {
		return trapped;
	}
	public void setTrapped(boolean trapped) {
		this.trapped = trapped;
	}
	
}
