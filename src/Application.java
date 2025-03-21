import com.jdbcAula.repository.DepartamentoRepository;
import com.jdbcAula.repository.FuncionarioRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        DepartamentoRepository departamento = new DepartamentoRepository();
        FuncionarioRepository funcionario = new FuncionarioRepository();
        ResultSet departamentoRs = departamento.buscar();
        ResultSet funcionarioRs = funcionario.buscar();

        System.out.println("Iniciando Sistema...");

//        funcionario.inserir();
//        funcionario.alterar();
//        funcionario.remover();
//
//        departamento.inserir();
//        departamento.alterar();

        while (departamentoRs.next()) {
            String lista = ("ID do Departamento: " + departamentoRs.getInt("DEPTNO") + " - " + "Nome: "
                    + departamentoRs.getString("DNAME") + " - " + "Localização: " + departamentoRs.getString("localization"));
            System.out.println(lista);
        }


        while (funcionarioRs.next()) {
            String lista = ("ID do Funcionario: " + funcionarioRs.getInt("id") + " - " + "Nome: "
                    + funcionarioRs.getString("ENAME") + " - " + "Função: " + funcionarioRs.getString("job")
                    + " - " + "Data de Contratação: " + funcionarioRs.getDate("hire_date") + " - "
                    + "Número do Departamento: " + funcionarioRs.getInt("deptno"));
            System.out.println(lista);
        }

        System.out.println("Sistema Finalizado");
    }
}
