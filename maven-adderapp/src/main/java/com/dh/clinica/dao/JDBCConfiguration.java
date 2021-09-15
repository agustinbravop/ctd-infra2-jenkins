package com.dh.clinica.dao;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;



public class JDBCConfiguration {
    private final String dbUrl;
    private final String usuario;
    private final String contrasena;

    public JDBCConfiguration() {
        dbUrl = "jdbc:h2:~/BravoPerez-Backend;INIT=RUNSCRIPT from 'create.sql'";
        usuario = "sa";
        contrasena = null;
    }

    public Connection conectarConDB(){
        Connection connection = null;
        Logger logger = Logger.getLogger(JDBCConfiguration.class);
        try {
            // Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(dbUrl, usuario, contrasena);
        } catch (Exception e){
            logger.error("Error al conectarse con la base de datos", e);
        }
        return connection;
    }

}
