package com.dh.clinica.service;


import com.dh.clinica.dao.IDAO;
import com.dh.clinica.model.Paciente;

import java.util.List;
import java.util.Optional;

public class PacienteService {

    private IDAO<Paciente> pacienteIDao;

    public PacienteService(IDAO<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente p){
        pacienteIDao.guardar(p);
        return p;
    }
    public Optional<Paciente> buscar(Integer id){
        return pacienteIDao.buscar(id);
    }
    public List<Paciente> buscarTodos(){
        return pacienteIDao.listar();
    }
    public void eliminar(Integer id){
         pacienteIDao.eliminar(id);
    }
}
