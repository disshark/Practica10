package P2_Colaborativa_Equipo4_Herencia;

public class Deporte {
    private String nombre;
    private String numJugador;

    public Deporte(String nombre, String numJugador) {
        this.nombre = nombre;
        this.numJugador = numJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumJugador() {
        return numJugador;
    }
}
