package P2_Colaborativa_Equipo4_Herencia;

import java.io.*;


import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Club> clubes = new ArrayList<>();
    public static List<Miembro> miembros = new ArrayList<>();
    private static Scanner scanner = new  Scanner(System.in);
    private static List<Transaccion> transacciones = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        cargarMiembros("Miembros.txt");
        clubes = Club.cargarClubes("Club.txt", miembros);
        System.out.println("Bienvenida a la NavesLiga");
        cargarJornada();
        Club.deportes.forEach(deporte -> {
            System.out.println("------------------"+deporte.getNombre()+"------------------");
            for (Club club : clubes) {
                if(club.getDeporte().getNombre().equalsIgnoreCase(deporte.getNombre())) {
                    System.out.println("*Club: "+club.getNombre());
                    club.getMiembros().stream().filter(c -> c.getCargo().equalsIgnoreCase("Director")).forEach(c -> {
                        System.out.println("\t-Director: "+c.getNombre());
                    });
                    club.getMiembros().stream().filter(c -> c.getCargo().equalsIgnoreCase("Entrenador")).forEach(c -> {
                        System.out.println("\t-Entrenador: "+c.getNombre());
                    });
                    System.out.println("\t-Jugadores:");
                    club.getMiembros().stream().filter(c -> c.getCargo().equalsIgnoreCase("Jugador")).forEach(c -> System.out.println("\t\t+"+c.getNombre()));
                }
            }
        });
        System.out.println("------------------"+"Jugadores titulares para jornada proxima"+"------------------");
        clubes.forEach(club -> {
            System.out.println("*Club: "+club.getNombre());
            jugadorConvocado(club.getNombre());
        });
        boolean salir = false;
        while (!salir) {
            System.out.println("--------------------------");
            System.out.println("Elige el equipo que desees: ");
            clubes.forEach(c -> System.out.println(c.getNombre()));
            String nombrEquipo = scanner.nextLine();

            if (clubes.stream().anyMatch(c -> c.getNombre().equalsIgnoreCase(nombrEquipo))) {
                salir = true;

                verDtsEquipo(nombrEquipo);
                jugadorConvocado(nombrEquipo);
            } else {
                System.out.println("No existe el equipo");
            }

        }
        Partido.cargarPartidos("partidos.txt", miembros, clubes).forEach(partido -> System.out.println(
                partido.getEquipo1() + " VS " + partido.getEquipo2() + "\n" +
                partido.getGanador()
        ));

        actualizarJornada();
        actualizarMiembro();
        actualizarRanking();
    }

    public static void actualizarRanking() throws IOException {
        List<Club> clubsOrdenados = ordenarClubs();
        int rankingVoley = 1;
        int rankingSepak = 1;
        int rankingRugby = 1;
        BufferedWriter bw = new BufferedWriter(new FileWriter("NavesLiga.txt"));
        try (bw) {
           for (Club c : clubsOrdenados) {
               if(c.getDeporte().getNombre().equalsIgnoreCase("voleibol")) {
                   c.setRanking(rankingVoley);
                   rankingVoley++;
               } else if (c.getDeporte().getNombre().equalsIgnoreCase("Sepak Takraw")) {
                   c.setRanking(rankingSepak);
                   rankingSepak++;
               } else {
                   c.setRanking(rankingRugby);
                   rankingRugby++;
               }
               bw.write("#" + c.getDeporte().getNombre());
               bw.write(c.getNombre() + ";" + c.getRanking());
           }
        }
    }


    public  static void cargarDts() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("NavesLiga.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");

        }
        br.close();
    }

    public static void cargarMiembros(String fichero) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String line;
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(";");
            if(datos[1].equalsIgnoreCase("jugador")) {
                miembros.add(new Jugador(datos[0], datos[1], datos[7], Integer.parseInt(datos[2]), datos[3], Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), Integer.parseInt(datos[6])));
            } else if(datos[1].equalsIgnoreCase("entrenador")) {
                miembros.add(new Entrenador(datos[0], datos[1], datos[2]));
            } else if(datos[1].equalsIgnoreCase("director")) {
                miembros.add(new Director(datos[0], datos[1], datos[2]));
            }
        }
        br.close();
    }

    public static void actualizarMiembro() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Miembros.txt"));
        for (Miembro m : miembros) {
            if(m instanceof Jugador) {
                bw.write(m.getNombre()+";"
                        +m.getCargo()+";"
                        +((Jugador) m).getDorsal()+";"
                        +((Jugador) m).getPosicion()+";"
                        +((Jugador) m).getTantos()+";"
                        +((Jugador) m).getSanciones()+";"
                        +((Jugador) m).getValor()+";"
                        +m.getEquipo()+"\n");
            } else if (m instanceof Entrenador) {
                bw.write(m.getNombre()+";"+m.getCargo()+";"+m.getEquipo()+"\n");
            } else if (m instanceof Director) {
                bw.write(m.getNombre()+";"+m.getCargo()+";"+m.getEquipo()+"\n");
            }
        }
        bw.close();
    }

    public  static void verDtsEquipo(String nombrEquipo){
        clubes.stream().filter(c -> c.getNombre().equalsIgnoreCase(nombrEquipo)).forEach(e -> {
            System.out.println("Valoracion: " + e.getValoracion());
            e.getMiembros().stream().filter(m -> m.getCargo().equalsIgnoreCase("Director")).forEach(a -> System.out.println("Director: "+ a.getNombre()));
            e.getMiembros().stream().filter(en -> en.getCargo().equalsIgnoreCase("entrenador")).forEach(et -> System.out.println("Entrenador: " + et.getNombre()));
            System.out.println("--------------------");
            System.out.println("\tJUGADORES");
            System.out.println("--------------------");
            e.getMiembros().stream().filter(j -> j.getCargo().equalsIgnoreCase("jugador")).forEach(jg -> System.out.println(jg.getNombre()));
            System.out.println("Deporte: " + e.getDeporte().getNombre());
        });
    }

    public static void jugadorConvocado(String equipo) {

        int numJugadores = 0;
        for(Club c : clubes) {
            if(c.getNombre().equalsIgnoreCase(equipo)) {
                numJugadores = c.getDeporte().getNumJugador();
            }
        }
        List<Miembro> miembrosOrdenados = ordenarMiembros(equipo);
        System.out.println("-Jugadores convocados:");
        for(int i = 0; i < numJugadores; i++) {
            System.out.println("\t-"+miembrosOrdenados.get(i).getNombre());
        }
    }


    public static ArrayList<Club> ordenarClubs() {
        List<Club> clubsOrdenados = clubes.stream()
                .sorted(Comparator.comparingInt(Club::getPartidoGanado).reversed()) // Ordenar de mayor a menor por partidos ganados
                .collect(Collectors.toList());  // Recolectar en una lista

        return new ArrayList<>(clubsOrdenados);
    }


    public static ArrayList<Miembro> ordenarMiembros(String equipo) {

        List<Miembro> miembrosOrdenados = miembros.stream()
                .filter(m -> m.getEquipo().equalsIgnoreCase(equipo))
                .filter(m -> m.getCargo().equalsIgnoreCase("Jugador"))
                .sorted(Comparator.comparingInt(m -> ((Jugador) m).getValor()).reversed()) // Ordenar de mayor a menor por valor
                .collect(Collectors.toList());  // Recolectar en una lista

        return new ArrayList<>(miembrosOrdenados);
    }

    public static void intercambioJugadores() {

        System.out.println("Selecciona el primer equipo: ");
        String equipo1 = scanner.nextLine();
        System.out.println("Selecciona el segundo equipo: ");
        String equipo2 = scanner.nextLine();
        Jugador jugador1 = null;
        Jugador jugador2 = null;
        boolean comprobarJugador1 = false;
        while (!comprobarJugador1) {
            System.out.println("JUGADORES EQUIPO 1:");
            miembros.stream().filter(m -> m.getEquipo().equalsIgnoreCase(equipo1)).forEach(mi -> System.out.println(mi.getNombre()));
            System.out.println("Que jugado vas a cambiar del equipo "+equipo1);
            jugador1 = Jugador.buscarJugador(scanner.nextLine(), miembros) != null ? Jugador.buscarJugador(scanner.nextLine(), miembros) : null;
            if(jugador1 != null) {
                comprobarJugador1 = true;
            } else {
                System.out.println("No existe este jugador");
            }
        }
        boolean comprobarJugador2 = false;
        while (!comprobarJugador2) {
            System.out.println("JUGADORES EQUIPO 2:");
            miembros.stream().filter(m -> m.getEquipo().equalsIgnoreCase(equipo2)).forEach(mi -> System.out.println(mi.getNombre()));
            System.out.println("Que jugado vas a cambiar del equipo "+equipo2);
            jugador2 = Jugador.buscarJugador(scanner.nextLine(), miembros) != null ? Jugador.buscarJugador(scanner.nextLine(), miembros) : null;
            if(jugador2 != null) {
                comprobarJugador2 = true;
            } else {
                System.out.println("No existe este jugador");
            }
        }
        jugador1.setEquipo(equipo2);
        jugador2.setEquipo(equipo1);
        transacciones.add(new Transaccion(jugador1, jugador2));
    }

    public static void cargarJornada() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Jornada.txt"));
        try {
            // Lee la línea
            String linea = br.readLine();

            // Intenta convertir la línea a un entero
            int jornada = Integer.parseInt(linea);

            // Si llega hasta aquí, la conversión fue exitosa
            System.out.println("La jornada es: " + jornada);
        } catch (NumberFormatException e) {
            System.err.println("El formato del archivo jornada esta incorrecto");
        }
        br.close();
    }

    public static void actualizarJornada() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Jornada.txt"));
        try {
            // Lee la línea
            String linea = br.readLine();

            // Intenta convertir la línea a un entero
            int jornada = Integer.parseInt(linea) + 1;
            BufferedWriter bw = new BufferedWriter(new FileWriter("Jornada.txt"));
            bw.write(jornada);
            bw.close();

        } catch (NumberFormatException e) {
            System.err.println("El formato del archivo jornada esta incorrecto");
        }
        br.close();
    }


}
