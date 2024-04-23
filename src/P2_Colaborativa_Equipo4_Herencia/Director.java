package P2_Colaborativa_Equipo4_Herencia;

import java.util.List;

public class Director extends Miembro{
    public Director(String nombre, String cargo, String equipo) {
        super(nombre, cargo, equipo);
    }

    @Override
    public String imprimirDatos() {
        return this.getNombre();
    }

    public static Director buscarDirector(List<Miembro> miembros, String equipo) {
        for(Miembro m : miembros) {
            if(m.getCargo().equalsIgnoreCase("Director") && m.getEquipo().equalsIgnoreCase(equipo)) {
                return (Director) m;
            }
        }
        return null;
    }
}
