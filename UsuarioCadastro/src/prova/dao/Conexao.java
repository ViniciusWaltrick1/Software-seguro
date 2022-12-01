package prova.dao;

import java.sql.*;

public class Conexao {
    private String conbanco;
    private String usuariomysql;
    private String senhamysql;
    private Connection con;

    public Conexao() {
        this.conbanco = "jdbc:mysql://localhost:3306/prova?useSSL=false";
        this.usuariomysql = "root";
        this.senhamysql = "toor";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(conbanco, usuariomysql, senhamysql);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConexao() {
        return this.con;
    }

}
