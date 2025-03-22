package com.jdbcAula.repository;

import java.sql.*;

public class FuncionarioRepository {
    private Connection connection;
    private PreparedStatement pstmt;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public FuncionarioRepository() {
        this.connection = connectionFactory.getConnection();
    }

    public void inserirFuncionario(String name, String job, Date date, double salary, int deptno) throws SQLException {
        connectionFactory.getConnection(); // Iniciando conexão com o Postgree

        pstmt = connection.prepareStatement("INSERT INTO EMPLOYEES (ENAME, JOB, HIRE_DATE, SALARY, DEPTNO) VALUES (?, ?, ?, ?, ?)");
        // Setando o valor dos parametros
        pstmt.setString(1, name);
        pstmt.setString(2,job);
        pstmt.setDate(3, Date.valueOf(date.toLocalDate()));
        pstmt.setDouble(4, salary);
        pstmt.setInt(5, deptno);
        pstmt.execute();

        connectionFactory.closeConnection();
    }

    public void inserirFuncionario(String name, String job, Date date, int deptno) throws SQLException {
        connectionFactory.getConnection();

        pstmt = connection.prepareStatement("INSERT INTO EMPLOYEES (ENAME, JOB, HIRE_DATE, DEPTNO) VALUES (?, ?, ?, ?)");
        // Setando o valor dos parametros
        pstmt.setString(1, name);
        pstmt.setString(2,job);
        pstmt.setDate(3, Date.valueOf(date.toLocalDate()));
        pstmt.setInt(5, deptno);
        pstmt.execute();

        connectionFactory.closeConnection();
    }

    public void alterarDepartamento(int newDept, int emp_id) throws SQLException {
        connectionFactory.getConnection(); // Abrindo a conexão com o Banco de Dados
        pstmt = connection.prepareStatement("UPDATE EMPLOYEES SET DEPTNO = ? WHERE ID = ?");

        pstmt.setInt(1, newDept);
        pstmt.setInt(2, emp_id);
        pstmt.execute();
        connectionFactory.closeConnection();
    }


    public void removerFuncionario(int emp_id) throws SQLException {
        connectionFactory.getConnection();
        pstmt = connection.prepareStatement("DELETE FROM EMPLOYEES WHERE id = ?");
        // Setando o valor do parametro ?
        pstmt.setInt(1, emp_id);
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
