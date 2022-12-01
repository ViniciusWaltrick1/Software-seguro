package prova.dao;

import prova.model.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ListarDAO {

    ResultSet rs;
    PreparedStatement ps;
    private Conexao con;

    public ListarDAO() {
        this.con = new Conexao();
    }

    public List<Produto> listaprodutos() {
        List<Produto> produtos = new ArrayList<>();
        try {

            String query = "select * from produtos";
            ps = con.getConexao().prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt(1));
                produto.setNome(rs.getString(2));
                produto.setPreco(rs.getInt(3));
                produto.setDescricao(rs.getString(3));

                produtos.add(produto);
            }
            return produtos;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return produtos;
    }
}
