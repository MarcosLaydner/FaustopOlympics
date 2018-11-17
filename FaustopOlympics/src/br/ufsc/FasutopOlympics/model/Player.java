package br.ufsc.FasutopOlympics.model;

public class Player {
	
	private String name;
	private int id;
	private int score;
	private boolean winner;
	private int y;
	private int x;
	private boolean paralyzed;
	
	public Player(int id) {
		this.id = id;
		this.score = 0;
		this.winner = false;
		this.paralyzed = false;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public boolean isParalyzed() {
		return paralyzed;
	}

	public void setParalyzed(boolean paralyzed) {
		this.paralyzed = paralyzed;
	}
}