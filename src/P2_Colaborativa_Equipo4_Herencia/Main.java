package P2_Colaborativa_Equipo4_Herencia;

import java.awt.*;
import java.io.BufferedReader;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Club> clubes = new ArrayList<>();
    public static List<Miembro> miembros = new ArrayList<>();
    private static Scanner scanner = new  Scanner(System.in);

    public static void main(String[] args) throws IOException {
        cargarMiembros("Miembros.txt");
        clubes = Club.cargarClubes("Club.txt", miembros);
        boolean salir = false;
        while (!salir) {
            System.out.println("Elige el equipo que desees");
            clubes.forEach(c -> {
                System.out.println(c.getNombre());
            });
            String nombrEquipo = scanner.nextLine();

            if (clubes.stream().anyMatch(c -> c.getNombre().equalsIgnoreCase(nombrEquipo))) {
                salir = true;

                verDtsEquipo(nombrEquipo);

            } else {
                System.out.println("No existe el equipo");
            }

        }

    }

    public  static void cargarDts() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("NavesLigas.txt")));
        String line = "";
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
                miembros.add(new Jugador(datos[0], datos[1], datos[7], Integer.parseInt(datos[2]), datos[3], Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), Double.parseDouble(datos[6])));
            } else if(datos[1].equalsIgnoreCase("entrenador")) {
                miembros.add(new Entrenador(datos[0], datos[1], datos[2]));
            } else if(datos[1].equalsIgnoreCase("director")) {
                miembros.add(new Director(datos[0], datos[1], datos[2]));
            }
        }
        br.close();
    }

    public  static void verDtsEquipo(String nombrEquipo){
        clubes.stream().filter(c -> c.getNombre().equalsIgnoreCase(nombrEquipo)).forEach(e -> {
            System.out.println("Valoracion: " + e.getValoracion());
            e.getMiembros().stream().filter(m -> m.getCargo().equalsIgnoreCase("Director")).forEach(a -> System.out.println("Director: "+ a.getNombre()));
        });
    }
}
