package P2_Colaborativa_Equipo4_Herencia;

    }


public  static void cargarDts(){
    BufferedReader br = new BufferedReader(new FileReader(new File("NavesLigas.txt")));
    String line = "";
    while ((line = br.readLine()) != null) {
        String[] values = line.split(";");

    }
    br.close();
}import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<String> clubes = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Hello World");


}
