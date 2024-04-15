package P2_Colaborativa_Equipo4_Herencia;



import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<String> clubes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");
        cargarDts();
    }

    public  static void cargarDts() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("NavesLigasData.txt")));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");
            System.out.println(line);
        }
        br.close();

    }
}
