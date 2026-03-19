package com.example.Univille_PontoPonto.ServiceDAO;

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
            var url = "jdbc:sqlserver://localhost:1434;databaseName=PontoPonto;encrypt=true;trustServerCertificate=true;";
            var user = "sa";
            var password = "Batat@124";
            return DriverManager.getConnection(url,user,password);

        }catch(SQLException e){
            try{
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/PontoPonto","root","root");
            }catch(SQLException ex){
                throw new RuntimeException(ex);
            }


        }

    }

}