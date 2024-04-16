package P2_Colaborativa_Equipo4_Herencia;

public class Deporte {
    private String nombre;
    private int numJugador;

    public Deporte(String nombre, int numJugador) {
        this.nombre = nombre;
        this.numJugador = numJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumJugador() {
        return numJugador;
    }
}
