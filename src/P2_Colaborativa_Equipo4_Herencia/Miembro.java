package P2_Colaborativa_Equipo4_Herencia;

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
}
