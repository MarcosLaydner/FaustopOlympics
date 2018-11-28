package br.ufsc.FasutopOlympics.model;

import br.ufsc.FasutopOlympics.view.GameScreen;
import br.ufsc.inf.leobr.cliente.Jogada;

public class MapDto implements Jogada {

	private Player localPlayer;
	private Player remotePlayer;
	private Tile[][] tiles;
	private boolean remotePassed;
	private GameScreen gameScreen;
	
	public MapDto(Player player1, Player player2, Tile[][] tiles, boolean remotePassed, GameScreen gameScreen) {
		super();
		this.localPlayer = player1;
		this.remotePlayer = player2;
		this.tiles = tiles;
		this.setRemotePassed(remotePassed);
		this.gameScreen = gameScreen;
	}
	
	public Player getPlayer1() {
		return localPlayer;
	}
	public void setPlayer1(Player player1) {
		this.localPlayer = player1;
	}
	public Player getPlayer2() {
		return remotePlayer;
	}
	public void setPlayer2(Player player2) {
		this.remotePlayer = player2;
	}
	public Tile[][] getTiles() {
		return tiles;
	}
	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public boolean isRemotePassed() {
		return remotePassed;
	}

	public void setRemotePassed(boolean remotePassed) {
		this.remotePassed = remotePassed;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
}
