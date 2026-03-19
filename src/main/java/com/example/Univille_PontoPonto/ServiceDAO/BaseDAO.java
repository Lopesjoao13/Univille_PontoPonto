package com.example.Univille_PontoPonto.ServiceDAO;

import java.sql.Connection;
import java.sql.SQLException;

class BaseDAO {

    protected Connection con() throws SQLException {
        return FabricaDeConexao.obterInstancia().con();
    }
}
