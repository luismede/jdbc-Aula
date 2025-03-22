import com.jdbcAula.repository.DepartamentoRepository;
import com.jdbcAula.repository.FuncionarioRepository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class Application {
    public static void main(String[] args) throws SQLException {
        DepartamentoRepository departamento = new DepartamentoRepository();
        FuncionarioRepository funcionario = new FuncionarioRepository();


        System.out.println("Iniciando Sistema...");

//        funcionario.inserirFuncionario("Kevin Love", "Gerente", Date.valueOf("2025-03-22"), 12000, 4);
//        funcionario.removerFuncionario(1);
//
//        departamento.inserirDepartamento("Operacional", "São Paulo", 50000);
//        departamento.alterarDepartamento("Técnologia da Informação", 9);

        ResultSet departamentoRs = departamento.buscar();
        ResultSet funcionarioRs = funcionario.buscar();

        System.out.println("Tabela de Departamentos");
        System.out.println("--------------------------------");
        while (departamentoRs.next()) {
            System.out.println("ID do Departamento: " + departamentoRs.getInt("DEPTNO"));
            System.out.println("Nome: " + departamentoRs.getString("DNAME"));
            System.out.println("Localização: " + departamentoRs.getString("LOCALIZATION"));
            System.out.println("--------------------------------");
        }
        System.out.println("--------------------------------");
        System.out.println("Tabela de Contribuidores");
        System.out.println("--------------------------------");
        while (funcionarioRs.next()) {
            System.out.println("ID do Funcionario: " + funcionarioRs.getInt("id"));
            System.out.println("Nome: " + funcionarioRs.getString("ENAME"));
            System.out.println("Função: " + funcionarioRs.getString("job"));
            System.out.println("Data de Contratação: " + funcionarioRs.getDate("hire_date"));
            System.out.println("Número do Departamento: " + funcionarioRs.getInt("deptno"));
            System.out.println("--------------------------------");
        }

        System.out.println("Sistema Finalizado...");
    }
}
