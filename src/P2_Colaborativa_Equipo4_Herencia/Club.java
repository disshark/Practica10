package P2_Colaborativa_Equipo4_Herencia;

import java.util.ArrayList;

public class Club {
    private int id;
    private String nombre;
    private ArrayList<Miembro> miembros = new ArrayList<>();
    private String deporte;
    private double valoracion;
    private int ranking;

    public Club(int id, String nombre, ArrayList<Miembro> miembros, String deporte, double valoracion, int ranking) {
        this.id = id;
        this.nombre = nombre;
        this.miembros = miembros;
        this.deporte = deporte;
        this.valoracion = valoracion;
        this.ranking = ranking;
    }

    public int getId() {
        return id;
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
}
