package P2_Colaborativa_Equipo4_Herencia;

import java.util.*;

public abstract class Miembro {
    private String nombre;
    private String cargo;
    private String equipo;

    public Miembro(String nombre, String cargo, String equipo) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public abstract String imprimirDatos();

    public static Map<Deporte, ArrayList<Miembro>> cogerMiembros(String equipo, List<Miembro> miembros) {
        Map<Deporte, ArrayList<Miembro>> map = new HashMap<>();
        ArrayList<String> deportes = getDeportesEquipo(equipo, miembros);
        for (String d : deportes) {
            Deporte deporte = Club.buscarDeporte(d);
            ArrayList<Miembro> miembrosDeporte = new ArrayList<>();
            for (Miembro m : miembros) {
                if(m instanceof Entrenador e && e.getEquipo().equalsIgnoreCase(equipo) && e.getDeporte().equalsIgnoreCase(d))  {
                    miembrosDeporte.add(m);
                } else if (m instanceof Jugador j && j.getEquipo().equalsIgnoreCase(equipo) && j.getDeporte().equalsIgnoreCase(d)) {
                    miembrosDeporte.add(m);
                }
            }
            map.put(deporte, miembrosDeporte);
        }
        return map;
    }

    private static ArrayList<String> getDeportesEquipo(String equipo, List<Miembro> miembros) {
        ArrayList<String> deportes = new ArrayList<>();
        for (Miembro m : miembros) {
            if(m instanceof Entrenador e && e.getEquipo().equalsIgnoreCase(equipo)) {
                if(!deportes.contains(e.getDeporte())) {
                    deportes.add(e.getDeporte());
                }
            } else if (m instanceof Jugador j && j.getEquipo().equalsIgnoreCase(equipo)) {
                if(!deportes.contains(j.getDeporte())) {
                    deportes.add(j.getDeporte());
                }
            }
        }
        return deportes;
    }
}
