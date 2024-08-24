import entities.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
            List<Usuario> listUsuarios = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            String path = "C:\\Users\\Casa\\Documents\\Estudos-Programação\\Java\\SistemaLogin\\src\\usuarios.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String header = sc.nextLine();
            String line = sc.nextLine();

            while(line != null){

                String[] fields = line.split(";");
                String nome = fields[0];
                String email = fields[1];
                String senha = fields[2];

                listUsuarios.add(new Usuario(nome, email, senha));
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        }
}
