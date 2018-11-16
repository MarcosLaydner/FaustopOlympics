package br.ufsc.FasutopOlympics.model;

import br.ufsc.inf.leobr.cliente.Jogada;

public class MapDto implements Jogada {

	private Player player1;
	private Player player2;
	private Tile[][] tiles;
	
	public MapDto(Player player1, Player player2, Tile[][] tiles) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.tiles = tiles;
	}
	
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Tile[][] getTiles() {
		return tiles;
	}
	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
}
