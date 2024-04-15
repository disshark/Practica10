package P2_Colaborativa_Equipo4_Herencia;

public class Jugador extends Miembro{
    private int dorsal;
    private String posicion;
    private int tantos;
    private int sanciones;
    private double valor;

    public Jugador(String nombre, String cargo, String equipo, int dorsal, String posicion, int tantos, int sanciones, double valor) {
        super(nombre, cargo, equipo);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.tantos = tantos;
        this.sanciones = sanciones;
        this.valor = valor;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getTantos() {
        return tantos;
    }

    public void setTantos(int tantos) {
        this.tantos = tantos;
    }

    public int getSanciones() {
        return sanciones;
    }

    public void setSanciones(int sanciones) {
        this.sanciones = sanciones;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void recibirSanciones(int sanciones) {
        this.sanciones = sanciones + 1;
    }
    public void  anotarTantos(int tantos)  {
        this.tantos = tantos + 1;
    }
}
