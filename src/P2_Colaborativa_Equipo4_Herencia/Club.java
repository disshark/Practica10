package P2_Colaborativa_Equipo4_Herencia;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//Asd

public class Club {
    public static List<Deporte> deportes = new ArrayList<>(Arrays.asList(
            new Deporte("Sepak Takraw", 3),
            new Deporte("Voleibol", 6),
            new Deporte("Rugby Subacuatico", 11)
    ));
    private String nombre;
    private Director director;
    private Map<Deporte, ArrayList<Miembro>> deporte;
    private double valoracion;
    private int ranking;
    private int partidoGanado;
    private int presupuesto;

    public Club(String nombre, Director director, Map<Deporte, ArrayList<Miembro>> deporte, double valoracion, int ranking, int partidoGanado, int presupuesto) {
        this.nombre = nombre;
        this.director = director;
        this.deporte = deporte;
        this.valoracion = valoracion;
        this.ranking = ranking;
        this.partidoGanado = partidoGanado;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }
    public Map<Deporte, ArrayList<Miembro>> getDeporte() {
        return deporte;
    }

    public double getValoracion() {
        return valoracion;
    }

    public int getRanking() {
        return ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getPartidoGanado() {
        return partidoGanado;
    }

    public void setPartidoGanado(int partidoGanado) {
        this.partidoGanado = partidoGanado;
    }

    /**
     * Metodo para cargar los clubes
     * @param fichero
     * @param miembros
     * @return clubes
     * @throws IOException
     */
    public static ArrayList<Club> cargarClubes(String fichero, List<Miembro> miembros) throws IOException {
        ArrayList<Club> clubes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String line;
        while((line = br.readLine()) != null) {
            String[] datos = line.split(";");
            clubes.add(new Club(datos[0], Director.buscarDirector(miembros, datos[0]), Miembro.cogerMiembros(datos[0], miembros), valoracionEquipo(miembros), Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), Integer.parseInt(datos[3])));
        }
        br.close();
        return clubes;
    }

    /**
     * Metodo para aniadir los miembros del equipo
     * @param miembros
     * @param equipo
     * @return miembrosEquipos
     */
    public static ArrayList<Miembro> miembrosEquipo(List<Miembro> miembros, String equipo) {
        ArrayList<Miembro> miembrosEquipo = new ArrayList<>();
        for(Miembro m : miembros) {
            if(m.getEquipo().equalsIgnoreCase(equipo)) {
                miembrosEquipo.add(m);
            }
        }
        return miembrosEquipo;
    }

    /**
     * Metodo para saber el valor del equipo
     * @param miembros
     * @return valores
     */
    public static double valoracionEquipo(List<Miembro> miembros) {
        return miembros.stream().filter(m -> m.getCargo().equalsIgnoreCase("jugador")).mapToDouble(m -> ((Jugador) m).getValor()).sum();
    }

    /**
     * Metodo para buscar un deporte
     * @param deporte
     * @return deporte
     */
    public static Deporte buscarDeporte(String deporte) {
        for(Deporte d : deportes) {
            if(deporte.equalsIgnoreCase(d.getNombre())) {
                return d;
            }
        }
        return null;
    }

    /**
     * Metodo para comprobar si existe el equipo
     * @param club
     * @param clubes
     * @return boolean
     */
    public static boolean comprobarClub(String club, List<Club> clubes) {
        for (Club c : clubes) {
            if (c.getNombre().equalsIgnoreCase(club)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para buscar el club
     * @param club
     * @param clubes
     * @return club
     */
    public static Club buscarClub(String club, List<Club> clubes) {
        for (Club c : clubes) {
            if (c.getNombre().equalsIgnoreCase(club)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Metodo para actualizar los datos del club
     * @param clubes
     * @throws IOException
     */
    public static void actualizarClub(List<Club> clubes) throws IOException {
        if (clubes.isEmpty()) {
            System.out.println("La lista de clubes está vacía.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Club.txt"))) {
            for (Club c : clubes) {
                bw.write(c.getNombre() + ";" + c.getRanking() + ";" + c.getPartidoGanado() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo Club.txt: " + e.getMessage());
            throw e;
        }
    }
}
