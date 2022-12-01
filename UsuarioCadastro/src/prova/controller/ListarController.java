package prova.controller;

import prova.dao.ListarDAO;
import prova.model.Produto;
import prova.view.ListarView;

import java.util.List;

public class ListarController {

    public void listarProdutos(){
        ListarDAO listarDAO = new ListarDAO();
        List<Produto> produtos = listarDAO.listaprodutos();

        ListarView listarview = new ListarView();
        listarview.listarView(produtos);
    }
}
