package P2_Colaborativa_Equipo4_Herencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bolsa {
    private String nombre;
    private int dorsal;
    private String posicion;
    private int tantos;
    private int sanciones;
    private int valor;
    private String deporte;

    public Bolsa(String nombre, int dorsal, String posicion, int tantos, int sanciones, int valor, String deporte) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.tantos = tantos;
        this.sanciones = sanciones;
        this.valor = valor;
        this.deporte = deporte;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getTantos() {
        return tantos;
    }

    public int getSanciones() {
        return sanciones;
    }

    public int getValor() {
        return valor;
    }

    public String getDeporte() {
        return deporte;
    }

    public static ArrayList<Bolsa> cargarBolsa() throws IOException {
        ArrayList<Bolsa> bolsas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("bolsa.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(";");
            bolsas.add(new Bolsa(datos[0], Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), datos[6]));
        }
        return bolsas;
    }
}
