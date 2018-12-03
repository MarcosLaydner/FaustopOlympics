package br.ufsc.FasutopOlympics.actors;

import br.ufsc.FasutopOlympics.control.Map;
import br.ufsc.FasutopOlympics.model.Player;
import br.ufsc.FasutopOlympics.model.TILETYPE;
import br.ufsc.FasutopOlympics.model.Tile;
import br.ufsc.FasutopOlympics.view.GameScreen;
import br.ufsc.FasutopOlympics.view.MainScreen;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class PlayerActor {

	private MainScreen mainScreen;
	private GameScreen gameScreen;
	private Player localPlayer;
	private NetworkActor nActor;
	private static final PlayerActor instance = new PlayerActor();
	
	public PlayerActor() {
		mainScreen = new MainScreen();
	}
	
	public Player getCurrentPlayer() {
		return Map.getInstance().getCurrentPlayer();
	} 
	public void showMainMenu() {
		this.mainScreen.setVisible(true);
	}
	public void showGameScreen() {
		if(gameScreen == null) {
			gameScreen = new GameScreen(localPlayer);
				
		}
		this.gameScreen.setVisible(true);
	}
	public void connect(String name) {
		Map.getInstance().connect(name);
		
	}
	public void trapmode() {
		gameScreen.trapmode();
	}
	public GameScreen getGameScreen() {
		return this.gameScreen;
	}
	public MainScreen getMainScreen() {
		return this.mainScreen;
	}
	public void setGameScreen(GameScreen gsc) {
		this.gameScreen = gsc;
	}
	public static PlayerActor getInstance() {
		return instance;
	}
	public void start() throws NaoConectadoException {
		Map.getInstance().start();
		
	}
	public void disconnect() throws NaoConectadoException {
		Map.getInstance().disconnect();
		
	}
	public void prepareMatch() {
		Map.getInstance().prepareMatch();
	}
	public String winCheck() {
		return Map.getInstance().winCheck();
	}
	public boolean sendMove(int j, int i) {
		return Map.getInstance().sendMove(j, i);
	}
	public Tile[][] getTiles() {
		return Map.getInstance().getTiles();
	}
	public Player getLocalPlayer() {
		return Map.getInstance().getLocalPlayer();
	}
	public void newGameScreen(Player localPlayer) {
		this.gameScreen = new GameScreen(localPlayer);
		
	}
	public Player getRemotePlayer() {
		return Map.getInstance().getRemotePlayer();
				
	}
	public void restart() {
		Map.getInstance().restart();
		
	}

	public Player getOtherPlayer() {
		return Map.getInstance().getOtherPlayer();
		
	}


}
