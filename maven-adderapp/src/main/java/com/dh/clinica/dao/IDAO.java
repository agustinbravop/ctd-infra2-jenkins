package com.dh.clinica.dao;

import java.util.List;
import java.util.Optional;

public interface IDAO<T> {
    T guardar(T t);
    List<T> listar();

    Optional<T> buscar(Integer id);
    void eliminar(Integer id);

}
