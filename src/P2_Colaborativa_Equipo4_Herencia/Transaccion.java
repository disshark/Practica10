package P2_Colaborativa_Equipo4_Herencia;

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

    public void setJugador1(Miembro jugador1) {
        this.jugador1 = jugador1;
    }

    public Miembro getJugador2() {
        return jugador2;
    }

    public void setJugador2(Miembro jugador2) {
        this.jugador2 = jugador2;
    }

}
