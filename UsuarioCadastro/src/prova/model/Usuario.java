package prova.model;

public class Usuario {
    private String email;
    private String nome;
    private String cpf ;
    private String senha;

    public Usuario(){ }

    public Usuario(String email, String nome, String cpf, String senha) {
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getCpf(){return cpf;}
    public void setCpf(String cpf){this.cpf = cpf;}
    public String getSenha(){return senha;}
    public void setSenha(String senha) {this.senha = senha;}
}
