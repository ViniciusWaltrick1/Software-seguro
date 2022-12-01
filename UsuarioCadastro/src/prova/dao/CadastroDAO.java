package prova.dao;

import prova.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroDAO {
    private Conexao con;
    PreparedStatement ps; //nao esta como privado, pois o sonarlint, reclama d erro "Private fields only used as local variables in methods should become local variables"

    public CadastroDAO(){
        con = new Conexao();
    }

    public Boolean cadastrarusuario(Usuario usuario){

        try{
            String query = "insert into usuarios values (?, ?, ?, ?)";
            ps = con.getConexao().prepareStatement(query);

            if (usuario.getEmail() == null || usuario.getNome() == null || usuario.getCpf() == null || usuario.getSenha() == null) {
                return false;
            }else if (usuario.getEmail().isEmpty() || usuario.getNome().isEmpty() || usuario.getCpf().isEmpty() || usuario.getSenha().isEmpty()) {
                return false;
            }else{
                ps.setString(1, usuario.getEmail());
                ps.setString(2, usuario.getNome());
                ps.setString(3, usuario.getCpf());
                ps.setString(4, usuario.getSenha());

                ps.execute();

                return true;
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return true;

    }
}
