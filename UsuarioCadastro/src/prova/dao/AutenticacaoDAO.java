package prova.dao;

import prova.model.Usuario;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.security.NoSuchAlgorithmException;
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

            String senha = usuario.getSenha();

            MessageDigest algorithm  = MessageDigest.getInstance("MD5");
            byte[] messageDigest = algorithm.digest(senha.getBytes(StandardCharsets.UTF_8));
            String senhahash = new String(messageDigest);

            ps = con.getConexao().prepareStatement(query);

            ps.setString(1, usuario.getEmail());
            ps.setString(2, senhahash);

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

        } catch (SQLException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
