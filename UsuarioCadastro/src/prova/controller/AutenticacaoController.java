package prova.controller;

import prova.dao.AutenticacaoDAO;
import prova.model.Usuario;
import prova.view.AutenticacaoView;

public class AutenticacaoController {
    private final AutenticacaoView aview;
    private final ListarController lcon;
    private final Usuario usuario;
    private final AutenticacaoDAO adao;

    public AutenticacaoController() {

        aview = new AutenticacaoView();
        usuario = aview.login(new Usuario());
        lcon = new ListarController();

        adao = new AutenticacaoDAO();

        if (Boolean.TRUE.equals(adao.autenticacaoDAO(usuario))) {
            aview.usuariologado();
            lcon.listarProdutos();
        } else {
            aview.usuarionaologado();
        }
    }

}
