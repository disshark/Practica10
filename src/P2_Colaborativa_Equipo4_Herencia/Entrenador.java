package P2_Colaborativa_Equipo4_Herencia;

public class Entrenador extends Miembro{
    private String deporte;
    public Entrenador(String nombre, String cargo, String equipo, String deporte) {
        super(nombre, cargo, equipo);
        this.deporte = deporte;
    }

    public String getDeporte() {
        return deporte;
    }

    @Override
    public String imprimirDatos() {
        return this.getNombre()+" "+this.getDeporte();
    }

}
