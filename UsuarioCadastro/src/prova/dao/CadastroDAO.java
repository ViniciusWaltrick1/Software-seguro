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

    public Boolean cadastrarusuario(Usuario u){

        try{
            String query = "insert into usuarios values (?, ?, ?, ?)";
            ps = con.getConexao().prepareStatement(query);

            if (u.getEmail() == null || u.getNome() == null || u.getCpf() == null || u.getSenha() == null) {
                return false;
            }else if (u.getEmail().isEmpty() || u.getNome().isEmpty() || u.getCpf().isEmpty() || u.getSenha().isEmpty()) {
                return false;
            }else{
                ps.setString(1, u.getEmail());
                ps.setString(2, u.getNome());
                ps.setString(3, u.getCpf());
                ps.setString(4, u.getSenha());

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
