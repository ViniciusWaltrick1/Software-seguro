package prova.view;

import prova.model.Usuario;

import java.util.Scanner;

public class AutenticacaoView {

    Scanner sc;

    public AutenticacaoView(){
        this.sc = new Scanner(System.in);
    }

    public Usuario login(Usuario usuario) {
        System.out.println("Login: " + System.lineSeparator());

        System.out.print("Enter the email: ");
        usuario.setEmail(sc.nextLine());

        System.out.print("Enter the password: ");
        usuario.setSenha(sc.nextLine());

        return usuario;
    }

    public void usuariologado(){
        System.out.println("Usuario Logado!");
    }
    public void usuarionaologado(){
        System.out.println("Erro ao logar");
    }
}
