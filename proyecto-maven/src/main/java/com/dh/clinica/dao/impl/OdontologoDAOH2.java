package com.dh.clinica.dao.impl;

import com.dh.clinica.dao.IDAO;
import com.dh.clinica.dao.JDBCConfiguration;
import com.dh.clinica.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class OdontologoDAOH2 implements IDAO<Odontologo> {

    private final JDBCConfiguration jdbcConfiguration;
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    public OdontologoDAOH2(JDBCConfiguration jdbcConfiguration) {
        this.jdbcConfiguration = jdbcConfiguration;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection conn = jdbcConfiguration.conectarConDB();
        String query = "INSERT INTO odontologos(matricula, nombre, apellido) VALUES(?, ?, ?)";

        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, odontologo.getMatricula());
            preparedStmt.setString(2, odontologo.getNombre());
            preparedStmt.setString(3, odontologo.getApellido());

            odontologo.setId(preparedStmt.executeUpdate());

            preparedStmt.close();
            conn.close();
            logger.info("Se guardó efectivamente un odontologo en la base de datos");
        }
        catch(SQLException e){
            logger.error("Error al intentar guardar un odontologo", e);
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        Connection conn = jdbcConfiguration.conectarConDB();
        String query = "SELECT * FROM odontologos";
        List<Odontologo> listaResultado = new ArrayList<>();

        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();

            // Instancio los odontologos encontrados, y van al array
            while(rs.next()){
                listaResultado.add(new Odontologo(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)
                    )
                );
            }
            rs.close();
            preparedStmt.close();
            conn.close();
            logger.info("Se listaron efectivamente los odontologos de la base de datos");
        }
        catch(SQLException e){
            logger.error("Error al intentar listar los odontologos", e);
        }

        return listaResultado;
    }

    @Override
    public Optional<Odontologo> buscar(Integer id) {
        return Optional.empty();
    }

    @Override
    public void eliminar(Integer id) {

    }
}
