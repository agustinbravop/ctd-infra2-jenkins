package com.dh.clinica.service;

import com.dh.clinica.dao.IDAO;
import com.dh.clinica.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDAO<Odontologo> odontologoIDAO;

    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoIDAO.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologos() {
        return odontologoIDAO.listar();
    }

    public OdontologoService(IDAO<Odontologo> odontologoIDAO) {
        this.odontologoIDAO = odontologoIDAO;
    }
}