package com.example.Univille_PontoPonto.ServiceDAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RegistroDePontoDAO extends BaseDAO{
    private int idFuncionario;
    private Date data;

    public RegistroDePontoDAO(int idFuncionario, Date data){
        this.idFuncionario = idFuncionario;
        this.data = data;

    }

    public String buscarRegistrosDePonto(){

        String query = """
        SELECT
            f.nomeFuncionario,
            d.nomeDepartamento,
            p.dataHora
        FROM Funcionario f
        JOIN Departamento d
            ON f.departamentoFuncionario = d.idDepartamento
        JOIN Ponto p
            ON p.funcionarioPonto = f.idFuncionario
        WHERE f.idFuncionario = ?
        AND CAST(p.dataHora AS DATE) = ?
        ORDER BY p.dataHora
        """;

        String nomeFuncionario = "";
        String nomeDepartamento = "";

        List<LocalDateTime> horarios = new ArrayList<>();

        try(var con = con();
            var pre = con.prepareStatement(query)) {

            pre.setInt(1, this.idFuncionario);
            pre.setDate(2, this.data);

            ResultSet rs = pre.executeQuery();

            while (rs.next()){
                nomeFuncionario = rs.getString("nomeFuncionario");
                nomeDepartamento = rs.getString("nomeDepartamento");
                horarios.add(rs.getTimestamp("dataHora").toLocalDateTime());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        StringBuilder linhas = new StringBuilder();
        Duration total = Duration.ZERO;

        DateTimeFormatter horaFormatada = DateTimeFormatter.ofPattern("HH:mm");

        for(int i = 0; i < horarios.size(); i += 2){

            LocalDateTime entrada = horarios.get(i);
            LocalDateTime saida = horarios.get(i + 1);

            Duration horas = Duration.between(entrada, saida);
            total = total.plus(horas);

            long h = horas.toHours();
            long m = horas.toMinutesPart();

            linhas.append(String.format(
                    "%s    %s    %02d:%02d\n",
                    entrada.format(horaFormatada),
                    saida.format(horaFormatada),
                    h,
                    m
            ));
        }

        long totalH = total.toHours();
        long totalM = total.toMinutesPart();

        return String.format("""
            RELATÓRIO DE PONTO
            Funcionário : %s
            Departamento : %s
            Data : %s

            Entrada  Saída  Horas
            ----------------------------
            %s
            ----------------------------
            Total trabalhado : %02d:%02d
            """,
                nomeFuncionario,
                nomeDepartamento,
                data.toLocalDate(),
                linhas,
                totalH,
                totalM
        );
    }
}