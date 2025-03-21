package com.jdbcAula.repository;

import java.sql.*;

public class FuncionarioRepository {
    private Connection connection;
    private PreparedStatement pstmt;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public FuncionarioRepository() {
        this.connection = connectionFactory.getConnection();
    }

    public void inserir() throws SQLException {
        connectionFactory.getConnection();

        pstmt = connection.prepareStatement("INSERT INTO EMPLOYEES (ENAME, JOB, HIRE_DATE, SALARY, DEPTNO) VALUES (?, ?, ?, ?, ?)");
        // Setando o valor dos parametros
        pstmt.setString(1, "Felipe Augusto");
        pstmt.setString(2,"Desenvolvedor");
        pstmt.setDate(3, Date.valueOf("2023-02-07"));
        pstmt.setDouble(4, 7300.00);
        pstmt.setInt(5, 1);
        pstmt.execute();

        connectionFactory.closeConnection();
    }

    public void alterar() throws SQLException {
        connectionFactory.getConnection(); // Abrindo a conexão com o Banco de Dados
        pstmt = connection.prepareStatement("UPDATE EMPLOYEES SET DEPTNO = ? WHERE ID = ?");

        pstmt.setInt(1, 1);
        pstmt.setInt(2, 3);
        pstmt.execute();
        connectionFactory.closeConnection();
    }


    public void remover() throws SQLException {
        connectionFactory.getConnection();
        pstmt = connection.prepareStatement("DELETE FROM EMPLOYEES WHERE id = ?");
        // Setando o valor do parametro ?
        pstmt.setInt(1, 5);
        pstmt.execute();
        connectionFactory.closeConnection();
    }

    public ResultSet buscar() throws SQLException {
        connectionFactory.getConnection();
        // Instanciando o objeto preparedStatement (pstmt)
        pstmt = connection.prepareStatement("SELECT * FROM EMPLOYEES ORDER BY DEPTNO");

        // Executando o comando sql do objeto preparedStatement e
        // armazenando no ResultSet
        ResultSet resultSet = pstmt.executeQuery();
        connectionFactory.closeConnection();
        return resultSet; // Retorna o result set
    }
}
