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
	private Player currentPlayer;
	private static final Map instance = new Map();

	public Map() {
		nActor = new NetworkActor(this);
		this.setSize(6);
		tiles = new Tile[size][size];
		this.remotePassed = false;
		this.localPlayer = new Player();
		this.remotePlayer = new Player();
		this.remotePlayer.setName("Player 2");
		playerActor = PlayerActor.getInstance();
		counter = 36;
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
				int def = ThreadLocalRandom.current().nextInt(1,4);
				switch (def) {
					case 1: 
						novo.setTileType(TILETYPE.QUESTION);
						novo.generateQuestion();
						break;
					case 2:
						if(Math.random() > 0.5) {
							novo.setTileType(TILETYPE.PRIZE_TRAP);
						} else
							novo.setTileType(TILETYPE.BLANK);
						break;
					case 3:
						novo.setTileType(TILETYPE.PRIZE_BONUS);
						novo.setPrize();
						break;
					default:
						novo.setTileType(TILETYPE.BLANK);
						break;
				}
				tiles[y][x] = novo;
			}
		}
		tiles[0][0].setTileType(TILETYPE.BLANK);
		tiles[6][6].setTileType(TILETYPE.BLANK);
	}
	public void connect(String name) {
		try {
			this.localPlayer.setName(name);
			nActor.conectar(name, "localhost");
			playerActor.newGameScreen(localPlayer);
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
	}

	private void placePlayers() {
		localPlayer.setY(0);
		localPlayer.setX(0);
		remotePlayer.setX(5);
		remotePlayer.setY(5);
		currentPlayer = localPlayer;
	}

	public boolean sendMove(int y, int x) {
		if (validatePos(x, y) ) {
			boolean ok = move(y, x);
			if (currentPlayer.equals(localPlayer)) {
				currentPlayer = remotePlayer;
			} else if (currentPlayer.equals(remotePlayer)) {
				currentPlayer = localPlayer;
			}
			return ok;
		} else {
			return false;
		}
	}
	public String winCheck() {
		if(currentPlayer.getScore() >= 500) {
			return "Player '"+currentPlayer.getName() + "' is the Winner with "+currentPlayer.getScore() + " Points!!!";
		}else if(getOtherPlayer().getScore() >= 500) {
			return "Player '"+getOtherPlayer().getName() + "' is the Winner with "+getOtherPlayer().getScore() + " Points!!!";
		}else {
			return null;
		}
	}
	
	private boolean validatePos(int x, int y) {
		int px = currentPlayer.getX();
		int py = currentPlayer.getY();
		int opx = getOtherPlayer().getX();
		int opy = getOtherPlayer().getY();
		if(y == opy && x == opx) {
			return false;
		}
		if(x == px-1 || x == px+1) {
			if(y < py+2 && y > py-2) {
				return true;
			}
		} else if(y == py-1 || y == py+1) {
			if(x < px+2 && x > px-2) {
				return true;
			}
		}
		return false;
	}
	private boolean move(int y, int x) {
		Tile selected = tiles[y][x];
		
		if (selected.isValid() && !currentPlayer.isParalyzed()) {
			//TODO set occupied or invalid?
			TILETYPE type = selected.getTileType();
			
			switch(type) {
				case PRIZE_BONUS:
					currentPlayer.addPoints(50);
					playerActor.getGameScreen().informMessage("PRIZE!! You got 50 points!");
					break;
				case QUESTION:
					QuestionScreen qsc = new QuestionScreen(selected.getQuestion(), currentPlayer);
					qsc.setVisible(true);
					break;
				case PRIZE_TRAP:
					playerActor.getGameScreen().informMessage("Place your Trap!");
					playerActor.trapmode();
					break;
				case TRAPPED:
					currentPlayer.setParalyzed(true);
					break;
				default:
					break;
			}
			currentPlayer.setX(x);
			currentPlayer.setY(y);

			moveTo(selected);
			return true;
		} else {
			playerActor.getGameScreen().informMessage("You got Paralyzed son!");
			playerActor.getGameScreen().updateLabels(getOtherPlayer());
			currentPlayer.setParalyzed(false);
			return false;
		}
	}
	public Player getOtherPlayer() {
		if (currentPlayer.equals(localPlayer)) {
			return remotePlayer;
		} else  {
			return localPlayer;
		}
	}
	private void moveTo(Tile selected) {
		selected.setTileType(TILETYPE.BLANK);
		selected.setTrapped(false);
		selected.setExplored(true);
		this.setCounter(this.getCounter() - 1);
	}

	//Not sure about this one
	
	

	
	public boolean trapTile(int y, int x) {
		Tile selected = tiles[y][x];
		
		if (!selected.getTileType().equals(TILETYPE.OBSTACLE)) {
			selected.setTrapped(true);
			selected.setTileType(TILETYPE.TRAPPED);
			return true;
		} else {
			playerActor.getGameScreen().informMessage("Could not trap Selected Tile");
			return false;
		}
	}

	public void receiveMove(MapDto dto) {
		this.setRemotePlayer(dto.getPlayer2());
		this.setTiles(dto.getTiles());
		this.setRemotePassed(dto.isRemotePassed());
		this.setCounter(dto.getCounter());
//		if (dto.isRemotePassed()) {
//			QuestionScreen qsc = new QuestionScreen(tiles[remotePlayer.getY()][remotePlayer.getX()].getQuestion());
//			qsc.setVisible(true);
//		}
		this.playerActor.getGameScreen().setVisible(true);
		this.playerActor.getGameScreen().repaint();
	}
	


	
	//-----------------------=Getters & Setters=---------------------------\\
	
	public Player getLocalPlayer() {
		return localPlayer;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
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
	public void restart() {
		localPlayer.setScore(0);
		localPlayer.setX(0);
		localPlayer.setY(0);
		remotePlayer.setScore(0);
		remotePlayer.setX(6);
		remotePlayer.setY(6);
		this.currentPlayer = localPlayer;
		playerActor.newGameScreen(localPlayer);
		playerActor.showGameScreen();
		
	}
	

	

	
	
}
