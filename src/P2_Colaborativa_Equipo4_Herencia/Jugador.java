package P2_Colaborativa_Equipo4_Herencia;

public class Jugador extends Persona {
	private int dorsal;
	private String posicion;
	private int tantos;
	private int sanciones;
	private int valor;
	private String equipo;
	
	public Jugador(String nombre, String cargo, int dorsal, String posicion, int tantos, int sanciones, int valor, String equipo) {
		super(nombre, cargo);
		this.dorsal = dorsal;
		this.posicion = posicion;
		this.tantos = tantos;
		this.sanciones = sanciones;
		this.valor = valor;
		this.equipo = equipo;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getTantos() {
		return tantos;
	}

	public void setTantos(int tantos) {
		this.tantos = tantos;
	}

	public int getSanciones() {
		return sanciones;
	}

	public void setSanciones(int sanciones) {
		this.sanciones = sanciones;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	
	
	
	
}
