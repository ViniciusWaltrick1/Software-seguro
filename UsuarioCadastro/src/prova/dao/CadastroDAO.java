package prova.dao;

import prova.model.Usuario;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

            String senha = usuario.getSenha();


            MessageDigest algorithm  = MessageDigest.getInstance("MD5");
            byte[] messageDigest = algorithm.digest(senha.getBytes(StandardCharsets.UTF_8));
            String senhahash = new String(messageDigest);


            if (usuario.getEmail() == null || usuario.getNome() == null || usuario.getCpf() == null || usuario.getSenha() == null) {
                return false;
            }else if (usuario.getEmail().isEmpty() || usuario.getNome().isEmpty() || usuario.getCpf().isEmpty() || usuario.getSenha().isEmpty()) {
                return false;
            }else{
                ps.setString(1, usuario.getEmail());
                ps.setString(2, usuario.getNome());
                ps.setString(3, usuario.getCpf());
                ps.setString(4, senhahash);

                ps.execute();

                return true;
            }
        }
        catch(SQLException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

        return true;

    }
}
