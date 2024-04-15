package P2_Colaborativa_Equipo4_Herencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//Asd

public class Club {
    private String nombre;
    private ArrayList<Miembro> miembros = new ArrayList<>();
    private String deporte;
    private double valoracion;
    private int ranking;

    public Club(String nombre, ArrayList<Miembro> miembros, String deporte, double valoracion, int ranking) {
        this.nombre = nombre;
        this.miembros = miembros;
        this.deporte = deporte;
        this.valoracion = valoracion;
        this.ranking = ranking;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Miembro> getMiembros() {
        return miembros;
    }

    public String getDeporte() {
        return deporte;
    }

    public double getValoracion() {
        return valoracion;
    }

    public int getRanking() {
        return ranking;
    }

    public void setMiembros(ArrayList<Miembro> miembros) {
        this.miembros = miembros;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public static ArrayList<Club> cargarClubes(String fichero, List<Miembro> miembros) throws IOException {
        ArrayList<Club> clubes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String line;
        while((line = br.readLine()) != null) {
            String[] datos = line.split(";");
            clubes.add(new Club(datos[1], miembrosEquipo(miembros, datos[1]), datos[0], valoracionEquipo(miembrosEquipo(miembros, datos[1])), Integer.parseInt(datos[2])));
        }
        br.close();
        return clubes;
    }

    public static ArrayList<Miembro> miembrosEquipo(List<Miembro> miembros, String equipo) {
        ArrayList<Miembro> miembrosEquipo = new ArrayList<>();
        for(Miembro m : miembros) {
            if(m.getEquipo().equalsIgnoreCase(equipo)) {
                miembrosEquipo.add(m);
            }
        }
        return miembrosEquipo;
    }

    public static double valoracionEquipo(ArrayList<Miembro> miembros) {
        return miembros.stream().filter(m -> m.getCargo().equalsIgnoreCase("jugador")).mapToDouble(m -> ((Jugador) m).getValor()).sum();
    }
}
