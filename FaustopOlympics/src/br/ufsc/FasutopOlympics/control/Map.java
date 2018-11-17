package br.ufsc.FasutopOlympics.control;

import java.util.concurrent.ThreadLocalRandom;

import br.ufsc.FasutopOlympics.actors.NetworkActor;
import br.ufsc.FasutopOlympics.model.MapDto;
import br.ufsc.FasutopOlympics.model.Player;
import br.ufsc.FasutopOlympics.model.TILETYPE;
import br.ufsc.FasutopOlympics.model.Tile;

public class Map{
	
	private Player player1;
	private Player player2;
	private Tile[][] tiles;
	private int size;
	private NetworkActor nActor;
	
	public Map() {
		nActor = new NetworkActor(this);
		this.setSize(6);
		tiles = new Tile[size][size];
	}
	
	private void generateTiles(){
		for(int y = 0; y > size; y++) {
			for(int x = 0; x > size; x++) {
				
				Tile novo = new Tile(y, x);
				int def = ThreadLocalRandom.current().nextInt(1,5);
				switch (def) {
					case 1: 
						novo.setTileType(TILETYPE.QUESTION);
						novo.generateQuestion();
						break;
					case 2:
						novo.setTileType(TILETYPE.OBSTACLE);
						novo.setValid(false);
						break;
					case 3:
						novo.setTileType(TILETYPE.BLANK);
						break;
					case 4:
						novo.setTileType(TILETYPE.PRIZE);
						novo.setPrize();
				}
				tiles[y][x] = novo;
			}
		}
		
	}
	
	public void connect() {
		nActor.conectar(player1.getName(), "localhost");
	}
	
	public void start() {
		nActor.iniciarPartidaRede();
	}
	
	public void prepareMatch() {
		generateTiles();
		placePlayers();
		//TODO updateFront?
	}
	
	private int randomCoordinates() {
		return ThreadLocalRandom.current().nextInt(0,6);
	}

	private void placePlayers() {
		player1.setY(randomCoordinates());
		player1.setX(randomCoordinates());
		//TODO send to front, probably check to see if it's valid
		player2.setY(randomCoordinates());
		player2.setX(randomCoordinates());
		//TODO same thing
		
	}

	public boolean sendMove(int y, int x) {
		if (nActor.isMyTurn()) {
			boolean ok = move(y, x);
			if (ok) {
				nActor.enviarJogada(this);
			}
			return ok;
		} else {
			return false;
		}
	}
	
	private boolean move(int y, int x) {
		// TODO implement move logic
		return false;
	}

	public void receiveMove(MapDto dto) {
		this.setPlayer1(dto.getPlayer1());
		this.setPlayer2(dto.getPlayer2());
		this.setTiles(dto.getTiles());
		//TODO updateFront?
	}

	
	//-----------------------=Getters & Setters=---------------------------
	
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
