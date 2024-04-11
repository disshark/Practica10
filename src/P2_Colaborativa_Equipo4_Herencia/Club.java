package P2_Colaborativa_Equipo4_Herencia;

import java.util.ArrayList;
import java.util.List;

public class Club {
	private String director;
	private String entrenador;
	private List<Jugador> jugadores = new ArrayList<>();
	private String tpoDport;
	private int valoracion;
	private int ranking;
	
	public Club(String director, String entrenador, List<Jugador> jugadores, String tpoDport, int valoracion, int ranking) {
		this.director = director;
		this.entrenador = entrenador;
		this.jugadores = jugadores;
		this.tpoDport = tpoDport;
		this.valoracion = valoracion;
		this.ranking = ranking;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getTpoDport() {
		return tpoDport;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public String getDirector() {
		return director;
	}

	public String getEntrenador() {
		return entrenador;
	}

	public void setTpoDport(String tpoDport) {
		this.tpoDport = tpoDport;
	}
	
	
}
