package com.jdbcAula.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartamentoRepository {
    private Connection connection;
    private PreparedStatement pstmt;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public DepartamentoRepository() {
        this.connection = connectionFactory.getConnection();
    }

    public void inserir() throws SQLException {
        connectionFactory.getConnection();

        pstmt = connection.prepareStatement("INSERT INTO DEPT (DNAME, LOCALIZATION, BUDGET) VALUES (?, ?, ?)");
        // Setando o valor dos parametros
        pstmt.setString(1, "Transporte");
        pstmt.setString(2,"Campinas");
        pstmt.setDouble(3, 2000000);
        pstmt.execute();

        connectionFactory.closeConnection();
    }

    public void alterar() throws SQLException {
        connectionFactory.getConnection(); // Abrindo a conexão com o Banco de Dados
        pstmt = connection.prepareStatement("UPDATE DEPT SET DNAME = ? WHERE DEPTNO = ?");

        pstmt.setString(1, "Gestão da Qualidade");
        pstmt.setInt(2, 11);
        pstmt.execute();
        connectionFactory.closeConnection();
    }

    public ResultSet buscar() throws SQLException {
        connectionFactory.getConnection();
        // Instanciando o objeto preparedStatement (pstmt)
        pstmt = connection.prepareStatement("SELECT * FROM DEPT ORDER BY DEPTNO");

        // Executando o comando sql do objeto preparedStatement e
        // armazenando no ResultSet
        ResultSet resultSet = pstmt.executeQuery();
        connectionFactory.closeConnection();
        return resultSet; // Retorna o result set
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
