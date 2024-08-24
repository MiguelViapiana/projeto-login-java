package daos;

import entities.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class GerenciadorDeArquivosUsuario {

    String path = "C:\\Users\\Casa\\Documents\\Estudos-Programação\\Java\\SistemaLogin\\src\\usuarios.txt";
    String header = "";

    public List<Usuario> getListUsuarios(){

        List<Usuario> listUsuarios = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            header = br.readLine();
            String line = br.readLine();

            while(line != null){

                String[] fields = line.split(";");
                String nome = fields[0];
                String email = fields[1];
                String senha = fields[2];

                listUsuarios.add(new Usuario(nome, email, senha));

                line = br.readLine();
            }

        } catch (
                IOException e) {
            System.out.println("[ERROR] "+ e.getMessage());
        }

        return listUsuarios;
    }

    public boolean gravarUsuario(List<Usuario> usuarios){
        boolean arquivoExiste = new File(path).exists();

        try{
            FileWriter arquivoGravar = new FileWriter(path, false);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            if(!arquivoExiste || new File(path).length() == 0){
                gravador.println(header);
            }

            for(Usuario usuario: usuarios){
                String linhaCSV = usuario.toCSV();
                gravador.println(linhaCSV);
            }
            gravador.close();
            return true;
        }
        catch (IOException e) {
            System.out.println("[ERROR] "+ e.getMessage());
            return false;
        }
    }

}
