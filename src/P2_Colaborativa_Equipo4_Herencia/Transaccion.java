package P2_Colaborativa_Equipo4_Herencia;

import java.io.*;
import java.util.List;

public class Transaccion {
    private Miembro jugador1;
    private Miembro jugador2;

    public Transaccion(Miembro jugador1, Miembro jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public Miembro getJugador1() {
        return jugador1;
    }

    public Miembro getJugador2() {
        return jugador2;
    }

    /**
     * Metodo para actualizar las transacciones
     * @param transacciones
     * @throws IOException
     */
    public static void actualizarTransacciones(List<Transaccion> transacciones) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Transacciones.txt", true));
        if(!transacciones.isEmpty()) {
            for (Transaccion t : transacciones) {
                bw.write(t.jugador1.getNombre()+";"+t.jugador2.getNombre()+"\n");
            }
        }
        bw.close();
    }

    /**
     * Metodo para buscar transacciones
     * @param club
     * @param miembros
     * @param clubes
     * @return transaccion
     * @throws IOException
     */
    public static Transaccion buscarTransaccion(String club, List<Miembro> miembros, List<Club> clubes) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Transacciones.txt"));
        StringBuilder historial = new StringBuilder(); //Variable donde guarda todos los historiales de las transacciones
        String line;
        while ((line = br.readLine()) != null) {
            historial.append(line).append("\n"); //Agregar datos a historial
        }
        br.close();
        if (!historial.isEmpty()) { //Comprobar si el historial esta vacio
            String[] datos = historial.toString().split("\n");
            for(int i = datos.length; i > 0; i--) {
                String[] dato = datos[i - 1].split(";");
                for (Miembro m : Club.buscarClub(club, clubes).getMiembros()) {
                    if(m.getCargo().equalsIgnoreCase("Jugador")) {
                        if(dato[0].equalsIgnoreCase(m.getNombre())) {
                            Miembro jugador1 = Jugador.buscarJugador(dato[0], miembros);
                            Miembro jugador2 = Jugador.buscarJugador(dato[1], miembros);
                            return new Transaccion(jugador1, jugador2);
                        } else if (dato[1].equalsIgnoreCase(m.getNombre())) {
                            Miembro jugador1 = Jugador.buscarJugador(dato[1], miembros);
                            Miembro jugador2 = Jugador.buscarJugador(dato[0], miembros);
                            return new Transaccion(jugador1, jugador2);
                        }
                    }
                }
            }
        }
        return null;
    }
}
