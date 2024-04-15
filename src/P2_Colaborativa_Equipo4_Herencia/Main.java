package P2_Colaborativa_Equipo4_Herencia;

import java.io.BufferedReader;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<String> clubes = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello World");


    }
    public  static void cargarDts() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("NavesLigas.txt")));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");

        }
        br.close();
    }
}
