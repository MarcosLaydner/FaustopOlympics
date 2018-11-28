package br.ufsc.FasutopOlympics.control;

import java.util.concurrent.ThreadLocalRandom;

import br.ufsc.FasutopOlympics.actors.NetworkActor;
import br.ufsc.FasutopOlympics.model.MapDto;
import br.ufsc.FasutopOlympics.model.Player;
import br.ufsc.FasutopOlympics.model.Question;
import br.ufsc.FasutopOlympics.model.TILETYPE;
import br.ufsc.FasutopOlympics.model.Tile;
import br.ufsc.FasutopOlympics.view.GameScreen;
import br.ufsc.FasutopOlympics.view.MainScreen;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.FasutopOlympics.view.GameScreen;
import br.ufsc.FasutopOlympics.view.MainScreen;

public class Map{
	
	private static final Map instance = new Map();
	private Player localPlayer;
	private Player remotePlayer;
	private Tile[][] tiles;
	private int size;
	private NetworkActor nActor;
	private int counter;
	private boolean remotePassed;
	private MainScreen mainScreen;
	private GameScreen gameScreen;
	
	public Map() {
		nActor = new NetworkActor(this);
		this.setSize(6);
		tiles = new Tile[size][size];
		this.remotePassed = false;
		mainScreen = new MainScreen();
		gameScreen = new GameScreen();
		this.localPlayer = new Player();
	}
	public void showMainMenu() {
		mainScreen.setVisible(true);
	}
	public void showGameScreen() {
		gameScreen.setVisible(true);
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
						novo.setPrize();
				}
				tiles[y][x] = novo;
			}
		}
		counter = size*size;
	}
	public void connect(String name) {
		this.localPlayer.setName(name);
		nActor.conectar(name, "localhost");
	}
	
	public void disconnect() throws NaoConectadoException {
		nActor.desconectar();
	}
	
	public void start() throws NaoConectadoException {
		nActor.iniciarPartidaRede();
		
	}
	
	public void prepareMatch() {
		generateTiles();
		placePlayers();
		//TODO updateFront?
		gameScreen.setVisible(true);
		sendMove(localPlayer.getY(), localPlayer.getX());
	}

	private void placePlayers() {
		localPlayer.setY(1);
		localPlayer.setX(1);
		//TODO send to front, probably check to see if it's valid
		remotePlayer.setY(6);
		remotePlayer.setX(6);
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
			localPlayer.addPoints(50);
		} else {
			localPlayer.addPoints(-25);
		}
	}
	
	public void pass() {
		//TODO this one will be hard. Or will it? - think i already got it
		// my ideia is: have a boolean "passed" here in map, so you can pass this information through the server
		this.remotePassed = true;
		nActor.enviarJogada(this);
		this.remotePassed = false;
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
		this.setRemotePassed(dto.isRemotePassed());
		this.setGameScreen(dto.getGameScreen());
		if (dto.isRemotePassed()) {
			answer();
		}
		//TODO repaint(); ??????
	}

	
	private void answer() {
		// TODO answering stuffs must end with following line:
		this.remotePassed = false;		
	}
	
	public boolean treatMove(int j, int k) {
		// TODO Auto-generated method stub
		return move(j, k);
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

	public boolean isRemotePassed() {
		return remotePassed;
	}

	public void setRemotePassed(boolean remotePassed) {
		this.remotePassed = remotePassed;
	}

	public static Map getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}

	public GameScreen getGameScreen() {
		return this.gameScreen;
	}
	
	public void setGameScreen(GameScreen gameScreen) {
		 this.gameScreen = gameScreen;
	}
	

	
	
}
