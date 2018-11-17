package br.ufsc.FasutopOlympics.control;

import java.util.concurrent.ThreadLocalRandom;

import br.ufsc.FasutopOlympics.actors.NetworkActor;
import br.ufsc.FasutopOlympics.model.MapDto;
import br.ufsc.FasutopOlympics.model.Player;
import br.ufsc.FasutopOlympics.model.Question;
import br.ufsc.FasutopOlympics.model.TILETYPE;
import br.ufsc.FasutopOlympics.model.Tile;

public class Map{
	
	private Player localPlayer;
	private Player remotePlayer;
	private Tile[][] tiles;
	private int size;
	private NetworkActor nActor;
	private int counter;
	
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
		counter = size*size;
	}
	
	public void connect(String name) {
		nActor.conectar(name, "localhost");
	}
	
	public void disconnect() {
		nActor.desconectar();
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
		localPlayer.setY(randomCoordinates());
		localPlayer.setX(randomCoordinates());
		//TODO send to front, probably check to see if it's valid
		remotePlayer.setY(randomCoordinates());
		remotePlayer.setX(randomCoordinates());
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
		Tile selected = tiles[y][x];
		if (selected.isValid() && !localPlayer.isParalyzed()) {
			//TODO set occupied or invalid?
			TILETYPE type = selected.getTileType();
			
			switch(type) {
				case TRAPPED:
					localPlayer.setParalyzed(true);
					break;
				case PRIZE_TRAP:
					//TODO Front prompt to place trap
					break;
				case PRIZE_BONUS:
					localPlayer.addPoints(50);//seila quantos pontos bixo
					break;
				case QUESTION:
					//TODO Front prompt to ask question idk
					selected.getQuestion();
					break;
			}
			moveTo(selected);
			return true;
		} else {
			return false;
		}
	}
	private void moveTo(Tile selected) {
		selected.setTileType(TILETYPE.BLANK);
		selected.setTrapped(false);
		selected.setExplored(true);
		this.setCounter(this.getCounter() - 1);
	}

	//Not sure about this one
	public void checkQuestion(String answer, Question question) {
		if (answer.equals(question.getRightopt())) {
			
		}
	}
	
	public void trapTile(int y, int x) {
		Tile selected = tiles[y][x];
		
		if (!selected.getTileType().equals(TILETYPE.OBSTACLE)) {
			selected.setTrapped(true);
			selected.setTileType(TILETYPE.TRAPPED);
		} else {
			//TODO mandar pro front
		}
	}

	public void receiveMove(MapDto dto) {
		this.setLocalPlayer(dto.getPlayer1());
		this.setRemotePlayer(dto.getPlayer2());
		this.setTiles(dto.getTiles());
		//TODO updateFront?
	}

	
	//-----------------------=Getters & Setters=---------------------------\\
	
	public Player getLocalPlayer() {
		return localPlayer;
	}

	public void setLocalPlayer(Player player1) {
		this.localPlayer = player1;
	}

	public Player getRemotePlayer() {
		return remotePlayer;
	}

	public void setRemotePlayer(Player player2) {
		this.remotePlayer = player2;
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

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
}