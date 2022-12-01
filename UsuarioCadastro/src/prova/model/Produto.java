package prova.model;

public class Produto {

    private int id;
    private String nome;
    private int preco;
    private String descricao;

    public Produto(){}

    public Produto(int id, String nome, int preco, String descricao){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
