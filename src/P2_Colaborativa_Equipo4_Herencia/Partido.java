package P2_Colaborativa_Equipo4_Herencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    public static ArrayList<Partido> cargarPartidos(String fichero) throws IOException {
        ArrayList<Partido> partidos = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String line;
        String equipoGanado = null;
        HashMap<String, Integer> sancionados = new HashMap<>();
        HashMap<String, Integer> goleadores = new HashMap<>();
        while((line = br.readLine()) != null) {

            if(line.startsWith("#")) {
                equipoGanado = line.substring(1);
            } else if (line.startsWith("*")) {
                String[] datos = line.substring(1).split(";");
                sancionados.put(datos[0], Integer.parseInt(datos[1]));
            } else if (line.startsWith("%")) {
                String[] datos = line.substring(1).split(";");
                goleadores.put(datos[0], Integer.parseInt(datos[1]));
            }

            if(line.startsWith("~")) {
                partidos.add(new Partido(equipoGanado, sancionados, goleadores));
                equipoGanado = null;
                sancionados = new HashMap<>();
                goleadores = new HashMap<>();
            }
        }
        br.close();
        return partidos;
    }
}
