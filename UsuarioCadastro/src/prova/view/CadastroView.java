package prova.view;

import prova.model.Usuario;

import java.util.Scanner;

public class CadastroView {
    Scanner sc;

    public CadastroView(){
        this.sc = new Scanner(System.in);
    }

    public Usuario cadastro(Usuario usuario){

        System.out.print("Email: ");
        usuario.setEmail(sc.nextLine());

        System.out.print("Senha: ");
        usuario.setSenha((sc.nextLine()));

        System.out.print("Nome: ");
        usuario.setNome(sc.nextLine());

        System.out.print("Cpf: ");
        usuario.setCpf((sc.nextLine()));

        return usuario;
    }

    public void usuarioCadastrado(){
        System.out.println("Usuario cadastrado");
    }

    public void usuarioNaoCadastrado(){
        System.out.println("Usuario Não Cadastrado");
    }
}
