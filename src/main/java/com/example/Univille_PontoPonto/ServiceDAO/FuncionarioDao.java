package com.example.Univille_PontoPonto.ServiceDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDao extends BaseDAO{

    public void exibirFuncionarios(){
        var query = """
                SELECT
                    f.idFuncionario,
                    f.matriculaFuncionario,
                    f.nomeFuncionario,
                    d.nomeDepartamento
                FROM Funcionario f
                JOIN Departamento d
                    ON f.departamentoFuncionario = d.idDepartamento
                ORDER BY f.nomeFuncionario;
                """;

        try (var con = con();
        var pre = con.prepareStatement(query)){

            ResultSet rs = pre.executeQuery();

            System.out.println("\nLISTA DE FUNCIONÁRIOS");
            System.out.println("------------------------------------------------------------");
            System.out.printf("%-5s %-15s %-25s %-20s\n",
                    "ID", "MATRÍCULA", "NOME", "DEPARTAMENTO");
            System.out.println("------------------------------------------------------------");
            while (rs.next()){
                int id = rs.getInt("idFuncionario");
                String matricula = rs.getString("matriculaFuncionario");
                String nome = rs.getString("nomeFuncionario");
                String departamento = rs.getString("nomeDepartamento");

                System.out.printf("%-5d %-15s %-25s %-20s\n",
                        id, matricula, nome, departamento);
                System.out.println("\n\n");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
