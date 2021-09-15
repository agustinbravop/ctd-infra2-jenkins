package com.dh.clinica.service;

import com.dh.clinica.dao.IDAO;
import com.dh.clinica.model.Domicilio;

import java.util.List;
import java.util.Optional;

public class DomicilioService {
    private IDAO<Domicilio> domicilioDao;

    public DomicilioService(IDAO<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }
    public Domicilio guardar(Domicilio d){
        domicilioDao.guardar(d);
        return d;
    }
    public Optional<Domicilio> buscar(Integer id){
        return domicilioDao.buscar(id);
    }
    public List<Domicilio> buscarTodos(){
        return domicilioDao.listar();
    }
    public void eliminar(Integer id){
        domicilioDao.eliminar(id);
    }

}
