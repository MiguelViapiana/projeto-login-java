package view;

import controller.UsuariosController;

import java.util.Scanner;

public class Menu {

    public void mostrar(){

        Scanner sc = new Scanner(System.in);

        System.out.println("\n-----------------------");
        System.out.println(" Possui cadastro? (S/N) ");
        System.out.println("-----------------------");
        char ch = sc.next().toUpperCase().charAt(0);

        if(ch == 'S'){
            telaLogin();
        }else{
            System.out.println("Deseja criar uma conta? (S/N)");
            ch = sc.next().toUpperCase().charAt(0);
            if (ch == 'S'){
                telaCadastro();
            }else{
                System.out.println("Agradeço pela visita");
            }

        }

    }
    private void telaCadastro(){
        Scanner sc = new Scanner(System.in);
        UsuariosController controler = new UsuariosController();

        System.out.println("-------------------");
        System.out.println(" REALIZAR CADASTRO ");
        System.out.println("-------------------");

        System.out.println("Digite o seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite o seu email:");
        String email = sc.nextLine();
        System.out.print("Digite a sua senha:");
        String senha = sc.nextLine();

        if(controler.efetuarCadastro(nome, email,senha) == null){
            System.out.println("Cadastro feito com sucesso");
            mostrar();
        }else{
            System.out.println("Falha ao cadastrar novo usuário, tente novamente");
        }

    }

    private void telaLogin(){
        Scanner sc = new Scanner(System.in);
        UsuariosController controler = new UsuariosController();

        System.out.println("----------------");
        System.out.println(" REALIZAR LOGIN ");
        System.out.println("----------------");

        System.out.print("Digite o seu email:");
        String email = sc.nextLine();
        System.out.print("Digite a sua senha:");
        String senha = sc.nextLine();

        if(controler.efetuarLogin(email, senha) == null){
            System.out.println("Falha ao efetuar login, tente novamente");
        }else{
            TelaLogado telaLogado = new TelaLogado();
            telaLogado.mostrarTelaLogado();
        }

    }

}
