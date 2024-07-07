package com.an.dao;

import com.an.entities.Compte;
import com.an.entities.TypeCompte;

import java.util.List;

public interface CompteDao <T,ID>{
    T save(T o);
    List<T> findAll();
    T findById(Long ID);
    T update(T o);
    void delete(Long ID);
}
