package com.example.Univille_PontoPonto.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

public class RegistroDePontoDAO extends BaseDAO{

    public String buscarRegistrosDePonto(String funcionario, LocalDateTime data){
    String query = String.format("""
            SELECT
                f.nomeFuncionario,
                d.nomeDepartamento,
                p.dataHora
            FROM Funcionario f
            JOIN Departamento d
                ON f.departamentoFuncionario = d.idDepartamento
            JOIN Ponto p
                ON p.funcionarioPonto = f.idFuncionario
            WHERE f.nomeFuncionario = '%s'
            AND CAST(p.dataHora AS DATE) = '%s'
            ORDER BY p.dataHora;
            """, funcionario, data);

    String nomeFuncionario;
    String nomeDepartamento;
    String dataHora;
    try(var con = con();
        var pre = con.prepareStatement(query)) {
        ResultSet rs = pre.executeQuery();
        while (rs.next()){
        nomeFuncionario = rs.getString("nomeFuncionario");
        nomeDepartamento = rs.getString("nomeDepartamento");
        dataHora = rs.getString("dataHora");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return String.format("""
            RELATÓRIO DE PONTO
            Funcionário : %s
            Departamento : %s
            Data : %s
            
            
            Entrada Salário da Horas
            ----------------------------
            08:02 12:01 03:59
            13:05 17:58 04:53
            
            ----------------------------
            Total trabalhado : 08:52
            
            """, nomeF);
    }
}
