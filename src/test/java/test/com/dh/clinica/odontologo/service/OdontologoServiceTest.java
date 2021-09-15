package test.com.dh.clinica.odontologo.service;

import com.dh.clinica.dao.JDBCConfiguration;
import com.dh.clinica.dao.impl.OdontologoDAOH2;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.service.OdontologoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoServiceTest {

    private final OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2(new JDBCConfiguration()));

    @Test
    public void guardarOdontologoTest() {
        Odontologo agustin = new Odontologo(20597, "Agustín", "Bravo");
        Odontologo ariana = new Odontologo(59783, "Ariana", "Bittel");
        Odontologo ramiro = new Odontologo(30697, "Ramiro", "Casco");
        Odontologo juanPablo = new Odontologo(18934, "Juan Pablo", "Calvo");

        // Si se guardaron bien, entonces tengo sus id de la DB
        assertNotNull(odontologoService.guardarOdontologo(agustin).getId());
        assertNotNull(odontologoService.guardarOdontologo(ariana).getId());
        assertNotNull(odontologoService.guardarOdontologo(ramiro).getId());
        assertNotNull(odontologoService.guardarOdontologo(juanPablo).getId());
    }

    @Test
    public void listarOdontologosTest(){
        // Testeo que al menos sean listados los casos de guardarOdontologoTest
        assertTrue(odontologoService.listarOdontologos().size() >= 4);
    }
}
