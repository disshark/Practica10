package P2_Colaborativa_Equipo4_Herencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Partido {
    private String equipo1;
    private String equipo2;

    private String ganador;

    private HashMap<String, Integer> sancionados;

    private HashMap<String, Integer> goleadores;

    public Partido(String equipo1, String equipo2, String ganador, HashMap<String, Integer> sancionados, HashMap<String, Integer> goleadores) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.ganador = ganador;
        this.sancionados = sancionados;
        this.goleadores = goleadores;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public String getEquipo1() {
        return equipo1;
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

    /**
     * Metodo para cargar los partidos de la jornada actual
     * @param fichero
     * @param miembros
     * @param clubes
     * @return ArrayList<Partido>
     * @throws IOException
     */
    public static ArrayList<Partido> cargarPartidos(String fichero, List<Miembro> miembros, List<Club> clubes) throws IOException {
        ArrayList<Partido> partidos = new ArrayList<>();
        StringBuilder todosResult = new StringBuilder(); //Donde guarda todos los contenidos del fichero

        BufferedReader br = new BufferedReader(new FileReader(fichero));// Leer el archivo
        String line;
        while((line = br.readLine()) != null) {
            todosResult.append(line).append("\n");//Agregar la linea a la variable
        }
        br.close();
        String[] parrafo = todosResult.toString().split("\n\n");

        for(String s : parrafo) {
            String equipo1 = null;
            String equipo2 = null;
            String equipoGanado = null;
            HashMap<String, Integer> sancionados = new HashMap<>();
            HashMap<String, Integer> goleadores = new HashMap<>();
            for(String l : s.split("\n")) {
                if (l.startsWith("=")) {//Sacar las lineas que empiecen por "=" para indicar que equipos han jugado
                    String[] equipos = l.substring(1).split(";");
                    if (equipos.length == 2) {
                        if (Club.comprobarClub(equipos[0], clubes) && Club.comprobarClub(equipos[1], clubes)) {
                            equipo1 = equipos[0];
                            equipo2 = equipos[1];
                        } else {
                            throw new Error("Hay algun club que no existe en esta liga");
                        }
                    } else {
                        throw new Error("La cantidad de equipos en una partida no es correcto");
                    }

                } else if(l.startsWith("#")) {//Sacar las lineas que empiecen por "#" para indicar el equipo que ha ganado
                    equipoGanado = l.substring(1);
                    if (Club.comprobarClub(equipoGanado, clubes)) {
                        Club.buscarClub(equipoGanado, clubes).setPartidoGanado(Club.buscarClub(equipoGanado, clubes).getPartidoGanado() + 1);
                    } else {
                        throw new Error("No existe el equipo");
                    }
                } else if (l.startsWith("*")) {//Sacar las lineas que empiecen por "*" para indicar el jugador que ha sido sancionados
                    String[] datos = l.substring(1).split(";");
                    sancionados.put(datos[0], Integer.parseInt(datos[1]));
                    Jugador jugador = Jugador.buscarJugador(datos[0], miembros);
                    if(jugador != null) {
                        jugador.setSanciones(jugador.getSanciones() + Integer.parseInt(datos[1]));
                    } else {
                        throw new Error("No existe el jugado");
                    }
                } else if (l.startsWith("%")) { //Sacar las lineas que empiecen por "%" para indicar el jugador que ha marcado
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
            partidos.add(new Partido(equipo1, equipo2, equipoGanado, sancionados, goleadores));
        }
        return partidos;

    }
}
