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
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/ponto","root","root");

        }catch(SQLException e){
            throw new RuntimeException(e);

        }

    }

}