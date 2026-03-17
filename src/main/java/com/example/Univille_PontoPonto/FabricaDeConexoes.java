package com.example.Univille_PontoPonto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
    private static FabricaDeConexoes instancia;

    private FabricaDeConexoes(){}

    public FabricaDeConexoes obterInstancia(){
        if(instancia == null){
            instancia = new FabricaDeConexoes();
        }
        return instancia;

    }

    public Connection conn(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/ponto","root","root");

        }catch(SQLException e){
            throw new RuntimeException(e);

        }

    }

}