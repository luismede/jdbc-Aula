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

    public void inserirDepartamento(String dName, String loc, double budget) throws SQLException {
        connectionFactory.getConnection();

        pstmt = connection.prepareStatement("INSERT INTO DEPT (DNAME, LOCALIZATION, BUDGET) VALUES (?, ?, ?)");
        // Setando o valor dos parametros
        pstmt.setString(1, dName);
        pstmt.setString(2,loc);
        pstmt.setDouble(3, budget);
        pstmt.execute();

        connectionFactory.closeConnection();
    }

    public void inserirDepartamento(String dName, String loc) throws SQLException {
        connectionFactory.getConnection();

        pstmt = connection.prepareStatement("INSERT INTO DEPT (DNAME, LOCALIZATION) VALUES (?, ?)");
        // Setando o valor dos parametros
        pstmt.setString(1, dName);
        pstmt.setString(2,loc);
        pstmt.execute();

        connectionFactory.closeConnection();
    }

    public void alterarDepartamento(String updatedName, int deptno) throws SQLException {
        connectionFactory.getConnection(); // Abrindo a conexão com o Banco de Dados
        pstmt = connection.prepareStatement("UPDATE DEPT SET DNAME = ? WHERE DEPTNO = ?");

        pstmt.setString(1, updatedName);
        pstmt.setInt(2, deptno);
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

}
