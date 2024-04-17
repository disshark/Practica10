package P2_Colaborativa_Equipo4_Herencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public static ArrayList<Partido> cargarPartidos(String fichero, List<Miembro> miembros) throws IOException {
        ArrayList<Partido> partidos = new ArrayList<>();
        StringBuilder todosResult = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String line;
        while((line = br.readLine()) != null) {
            todosResult.append(line).append("\n");
        }
        br.close();
        String[] parrafo = todosResult.toString().split("\n\n");

        for(String s : parrafo) {
            String equipoGanado = null;
            HashMap<String, Integer> sancionados = new HashMap<>();
            HashMap<String, Integer> goleadores = new HashMap<>();
            for(String l : s.split("\n")) {
                if(l.startsWith("#")) {
                    equipoGanado = l.substring(1);
                    for(Deporte d : Club.deportes) {
                        if(!d.getNombre().equalsIgnoreCase(equipoGanado)){
                            throw new Error("No existe el equipo");
                        }
                    }
                } else if (l.startsWith("*")) {
                    String[] datos = l.substring(1).split(";");
                    sancionados.put(datos[0], Integer.parseInt(datos[1]));
                    Jugador jugador = Jugador.buscarJugador(datos[0], miembros);
                    if(jugador != null) {
                        jugador.setSanciones(jugador.getSanciones() + Integer.parseInt(datos[1]));
                    } else {
                        throw new Error("No existe el jugado");
                    }
                } else if (l.startsWith("%")) {
                    String[] datos = l.substring(1).split(";");
                    goleadores.put(datos[0], Integer.parseInt(datos[1]));
                    Jugador jugador = Jugador.buscarJugador(datos[0], miembros);
                    if(jugador != null) {
                        jugador.setTantos(jugador.getTantos() + Integer.parseInt(datos[1]));
                    } else {
                        throw new Error("No existe el jugado");
                    }
                }
            }
            partidos.add(new Partido(equipoGanado, sancionados, goleadores));
        }
        return partidos;

    }
}
