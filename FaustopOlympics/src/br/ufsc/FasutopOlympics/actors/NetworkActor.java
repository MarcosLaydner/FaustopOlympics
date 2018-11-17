package br.ufsc.FasutopOlympics.actors;

import br.ufsc.FasutopOlympics.control.Map;
import br.ufsc.FasutopOlympics.model.MapDto;
import br.ufsc.FasutopOlympics.model.Player;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class NetworkActor implements OuvidorProxy {

	private Map map;
	private boolean myTurn = false;
	private Proxy proxy;
	
	public NetworkActor(Map map) {
		super();
		this.map = map;
		proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
	}
	
	public String conectar(String nome, String servidor) {
		try {
			proxy.conectar(servidor, nome);
		} catch (JahConectadoException e) {
			e.printStackTrace();
			return "You are already connected";
		} catch (NaoPossivelConectarException e) {
			e.printStackTrace();
			return "Could not connect to the server";
		} catch (ArquivoMultiplayerException e) {
			e.printStackTrace();
			return "Could not find configuration file";
		}
		return "";
	}
	
	public String iniciarPartidaRede() {
		try {
			proxy.iniciarPartida(2);
		} catch (NaoConectadoException e) {
			e.printStackTrace();
			return "You are not connected to the server";
		}
		
		return "";
	}
	
	public void enviarJogada(Map map) {
		MapDto dto = new MapDto(map.getRemotePlayer(), map.getLocalPlayer(), map.getTiles());
		try {
			proxy.enviaJogada(dto);
			myTurn = false;
		} catch (NaoJogandoException e) {
			e.printStackTrace();
		}
	}
	
	public void desconectar() {
		try {
			proxy.desconectar();
		} catch (NaoConectadoException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void iniciarNovaPartida(Integer posicao) {
		if (posicao == 1) {
			setMyTurn(true);
			map.setLocalPlayer(new Player(1));
			map.setRemotePlayer(new Player(2));
		} else if (posicao == 2) {
			setMyTurn(false);
			map.setLocalPlayer(new Player(2));
			map.setRemotePlayer(new Player(1));
		}
		
	}

	@Override
	public void finalizarPartidaComErro(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receberJogada(Jogada jogada) {
		MapDto dto = (MapDto) jogada;
		myTurn = true;
		map.receiveMove(dto);
	}

	@Override
	public void tratarConexaoPerdida() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		// TODO Auto-generated method stub
		
	}

	public boolean isMyTurn() {
		return myTurn;
	}

	public void setMyTurn(boolean myTurn) {
		this.myTurn = myTurn;
	}

}
