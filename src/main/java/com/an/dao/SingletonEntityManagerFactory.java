package com.an.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonEntityManagerFactory {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
    static{
        ENTITY_MANAGER_FACTORY= Persistence.createEntityManagerFactory("UP_BK");
    }
    public static EntityManagerFactory getEntityManagerFactory(){
        return  ENTITY_MANAGER_FACTORY;
    }
}
