package com.an.test;

import com.an.entities.Compte;
import com.an.entities.TypeCompte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("UP_BK");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(new Compte(null,9000,new Date(), TypeCompte.EPARGNE));
        entityManager.persist(new Compte(null,9000,new Date(), TypeCompte.COURANT));
        entityTransaction.commit();
    }
}
