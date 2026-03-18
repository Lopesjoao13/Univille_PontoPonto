package com.example.Univille_PontoPonto.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
    private static FabricaDeConexao instancia;

    private FabricaDeConexao(){}

    public synchronized static FabricaDeConexao obterInstancia(){
        if(instancia == null){
            instancia = new FabricaDeConexao();
        }
        return instancia;

    }

    public Connection con(){
        try {
//            return DriverManager.getConnection("jdbc:mysql://localhost:3306/PontoPonto","root","root");
            var url = "jdbc:sqlserver://localhost:1434;databaseName=ponto;encrypt=true;trustServerCertificate=true;";
            var user = "sa";
            var password = "Batat@124";
            return DriverManager.getConnection(url,user,password);

        }catch(SQLException e){
            throw new RuntimeException(e);

        }

    }

}