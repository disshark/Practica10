package P2_Colaborativa_Equipo4_Herencia;

import java.io.BufferedReader;
import java.util.HashMap;

public class Partido {

    private String ganador;

    private HashMap<String, Integer> sancionados;

    private HashMap<String, Integer> goleadores;

    public Partido(String ganador, HashMap<String, Integer> sancionados, HashMap<String, Integer> goleadores) {
        this.ganador = ganador;
        this.sancionados = sancionados;
        this.goleadores = goleadores;
    }

    public String getGanador() {
        return ganador;
    }

    public HashMap<String, Integer> getSancionados() {
        return sancionados;
    }

    public HashMap<String, Integer> getGoleadores() {
        return goleadores;
    }

    public static Partido cargarPartidos() {
        BufferedReader br = new BufferedReader();
    }
}
