package prova.dao;

import prova.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutenticacaoDAO {

    private Conexao con;
    ResultSet rs; //nao esta como privado, pois o sonarlint, reclama d erro "Private fields only used as local variables in methods should become local variables"
    PreparedStatement ps; //nao esta como privado, pois o sonarlint, reclama d erro "Private fields only used as local variables in methods should become local variables"

    public AutenticacaoDAO(){
        con = new Conexao();
    }


    public boolean autenticacaoDAO(Usuario usuario) {
        try {
            String query = "select * from usuarios where email = ? and senha = ?";

            ps = con.getConexao().prepareStatement(query);

            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());

            rs = ps.executeQuery();

            rs.next();

            switch(rs.getRow()) {
                case 1:
                    return true;
                case 0:
                    return false;
                default:
                    return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
