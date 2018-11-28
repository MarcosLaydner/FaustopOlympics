package br.ufsc.FasutopOlympics.actors;

import br.ufsc.FasutopOlympics.control.Map;
import br.ufsc.FasutopOlympics.model.Player;
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
	public void showMainMenu() {
		mainScreen.setVisible(true);
	}
	public void showGameScreen() {
		gameScreen.setVisible(true);
	}
	public void connect(String name) {
		Map.getInstance().connect(name);
		
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
}
