package br.ufsc.FasutopOlympics.control;

import java.util.concurrent.ThreadLocalRandom;

import br.ufsc.FasutopOlympics.actors.NetworkActor;
import br.ufsc.FasutopOlympics.actors.PlayerActor;
import br.ufsc.FasutopOlympics.model.MapDto;
import br.ufsc.FasutopOlympics.model.Player;
import br.ufsc.FasutopOlympics.model.Question;
import br.ufsc.FasutopOlympics.model.TILETYPE;
import br.ufsc.FasutopOlympics.model.Tile;
import br.ufsc.FasutopOlympics.view.GameScreen;
import br.ufsc.FasutopOlympics.view.QuestionScreen;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class Map{
	
	private Player localPlayer;
	private Player remotePlayer;
	private Tile[][] tiles;
	private int size;
	private NetworkActor nActor;
	private int counter;
	private boolean remotePassed;
	private PlayerActor playerActor;

	private static final Map instance = new Map();

	public Map() {
		nActor = new NetworkActor(this);
		this.setSize(6);
		tiles = new Tile[size][size];
		playerActor = new PlayerActor();
		this.remotePassed = false;
		this.localPlayer = new Player();
	}
	public NetworkActor getNActor() {
		return this.nActor;
	}
	public void showMainMenu() {
		playerActor.showMainMenu();
	}
	public void showGameScreen() {
		playerActor.showGameScreen();
	}
	
	private void generateTiles(){
		for(int y = 0; y < size; y++) {
			for(int x = 0; x < size; x++) {
				
				Tile novo = new Tile(y, x);
				int def = ThreadLocalRandom.current().nextInt(1,7);
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
						novo.setPrize();
						break;
					default:
						novo.setTileType(TILETYPE.BLANK);
						break;
				}
				tiles[y][x] = novo;
			}
		}
		counter = size*size;
		tiles[0][0].setTileType(TILETYPE.BLANK);
		tiles[5][5].setTileType(TILETYPE.BLANK);
		
	}
	public void connect(String name) {
		try {
			this.localPlayer.setName(name);
			nActor.conectar(name, "localhost");
			playerActor.setGameScreen( new GameScreen(localPlayer));
		}catch(NaoPossivelConectarException e11) {
			playerActor.getGameScreen().informMessage(e11.getMessage());
		} catch (JahConectadoException e) {
			playerActor.getGameScreen().informMessage(e.getMessage());
		} catch (ArquivoMultiplayerException e) {
			playerActor.getGameScreen().informMessage(e.getMessage());
		}
		
	}

	
	public void disconnect() throws NaoConectadoException {
		nActor.desconectar();
	}
	
	public void start() throws NaoConectadoException {
		nActor.iniciarPartidaRede();
		
	}
	
	public void prepareMatch() {
		placePlayers();
		generateTiles();
		//TODO updateFront?
		sendMove(localPlayer.getY(), localPlayer.getX());
	}

	private void placePlayers() {
		localPlayer.setY(0);
		localPlayer.setX(0);
		//TODO send to front, probably check to see if it's valid
		remotePlayer.setY(6);
		remotePlayer.setX(6);
		//TODO same thing
		
	}

	public boolean sendMove(int y, int x) {
		if (nActor.isMyTurn() && validatePos(x, y) ) {
			boolean ok = move(y, x);
			if (ok) {
				nActor.enviarJogada(this);
			}
			return ok;
		} else {
			return false;
		}
	}
	public String winCheck() {
		if(localPlayer.getScore() >= 500) {
			return "Player "+localPlayer.getName() + " is the Winner with "+localPlayer.getScore() + " Points!!!";
		}else if(remotePlayer.getScore() >= 500){
			return "Player "+remotePlayer.getName() + " is the Winner with "+remotePlayer.getScore() + " Points!!!";
		}else if(counter == 0) {
			if(localPlayer.getScore() > remotePlayer.getScore()) {
				return "Player "+localPlayer.getName() + " is the Winner with "+localPlayer.getScore() + " Points!!!";
			} else if(localPlayer.getScore() < remotePlayer.getScore()) {
				return "Player "+remotePlayer.getName() + " is the Winner with "+remotePlayer.getScore() + " Points!!!";
			} else {
				return "It's a tie!!! the winner is Faustop!";
			}
		}else {
			return null;
		}
	}
	
	private boolean validatePos(int x, int y) {
		int px = localPlayer.getX();
		int py = localPlayer.getY();
		if(x == px-1 || x == px+1) {
			if(y < py+2 && y > py-2) {
				return true;
			}
		} else if(y == px-1 || y == px+1) {
			if(x < px+2 && x > px-2) {
				return true;
			}
		}
		return false;
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
					playerActor.getGameScreen().trapmode();
					playerActor.getGameScreen().informMessage("You received a trap! Please select where the trap will be placed");
					break;
				case PRIZE_BONUS:
					localPlayer.addPoints(50);//seila quantos pontos bixo
					playerActor.getGameScreen().informMessage("PRIZE!! You got 50 points!");
					break;
				case QUESTION:
					QuestionScreen qsc = new QuestionScreen(selected.getQuestion());
					qsc.setVisible(true);
					break;
				default:
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
			playerActor.getGameScreen().informMessage("Could not trap Selected Tile");
		}
	}

	public void receiveMove(MapDto dto) {
		this.setLocalPlayer(dto.getPlayer1());
		this.setRemotePlayer(dto.getPlayer2());
		this.setTiles(dto.getTiles());
		this.setRemotePassed(dto.isRemotePassed());
		playerActor.setGameScreen(dto.getGameScreen());
		if (dto.isRemotePassed()) {
			answer();
		}
		//TODO repaint(); ??????
	}
	
	private void answer() {
		// TODO answering stuffs must end with following line:
		this.remotePassed = false;		
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
		return this.playerActor.getGameScreen();
	}
	

	

	
	
}
