package prova.view;

import prova.model.Produto;

import java.util.List;

public class ListarView {
    public void listarView(List<Produto> produtos) {
        for (Produto produto : produtos) {
            System.out.println("Produtos:" + System.lineSeparator() + "Id: " + produto.getId() + System.lineSeparator() +
                    "Nome: " + produto.getNome() + System.lineSeparator() + "Preco: " + produto.getPreco() + System.lineSeparator()
            + "Descricao: " + produto.getDescricao() + System.lineSeparator());
        }
    }
}