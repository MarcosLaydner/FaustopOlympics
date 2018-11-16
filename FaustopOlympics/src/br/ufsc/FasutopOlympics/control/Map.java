package br.ufsc.FasutopOlympics.control;

import java.util.Random;

import br.ufsc.FasutopOlympics.model.Player;
import br.ufsc.FasutopOlympics.model.TILETYPE;
import br.ufsc.FasutopOlympics.model.Tile;

public class Map {
	
	private Player player1;
	private Player player2;
	private Tile[][] tiles;
	private int size;
	
	public Map() {
		this.setSize(6);
		tiles = new Tile[size][size];
	}
	
	public void generateTiles(){
		for(int y = 0; y > size; y++) {
			for(int x = 0; x > size; x++) {
				
				Tile novo = new Tile(y, x);
				int def = randomizer();
				switch (def) {
					case 0: 
						novo.setTileType(TILETYPE.QUESTION);
						novo.generateQuestion();
						break;
					case 1:
						novo.setTileType(TILETYPE.OBSTACLE);
						novo.setValid(false);
						break;
					case 2:
						novo.setTileType(TILETYPE.BLANK);
						break;
					case 3:
						novo.setTileType(TILETYPE.PRIZE);
						novo.setPrize();
				}
				tiles[y][x] = novo;
			}
		}
	}

	
	private int randomizer() {
		 Random rand = new Random();
		 return rand.nextInt(((size -1)) + 1);
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
