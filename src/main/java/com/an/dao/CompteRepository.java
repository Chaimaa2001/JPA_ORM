package com.an.dao;

import com.an.entities.Compte;
import com.an.entities.TypeCompte;
import com.sun.xml.bind.v2.model.core.ID;

import java.util.List;

public interface CompteRepository extends CompteDao<Compte, ID>{

    List<Compte>findByType(TypeCompte type);


}
