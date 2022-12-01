package prova.controller;

import prova.dao.CadastroDAO;
import prova.model.Usuario;
import prova.view.CadastroView;


public class CadastroController {
    private final CadastroView aview;
    private final Usuario usuario;
    private final CadastroDAO adao;

    public CadastroController() {

        aview = new CadastroView();
        usuario = aview.cadastro(new Usuario());

        adao = new CadastroDAO();

        if (Boolean.TRUE.equals(adao.cadastrarusuario(usuario))) {
            aview.usuarioCadastrado();
        } else {
            aview.usuarioNaoCadastrado();
        }
    }
}
