package com.an.dao;

import com.an.entities.Compte;
import com.an.entities.TypeCompte;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CompteRepositoryImpl implements CompteRepository {
    private EntityManager entityManager;

    public CompteRepositoryImpl() {
        this.entityManager = SingletonEntityManagerFactory.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Compte save(Compte compte) {
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        try {
            entityManager.persist(compte);
            entityTransaction.commit();
        }
        catch (Exception e)
        {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return compte;

    }

    @Override
    public List<Compte> findAll() {
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        Query query=entityManager.createQuery("SELECT c FROM Compte c ");
        List<Compte>comptes=query.getResultList();
        entityTransaction.commit();
        return comptes;
    }

    @Override
    public Compte findById(Long id) {
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        Compte compte=entityManager.find(Compte.class,id);
        entityTransaction.commit();
        return compte;

    }

    @Override
    public List<Compte> findByType(TypeCompte type) {
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        TypedQuery<Compte> query=entityManager.createNamedQuery("findByType",Compte.class);
        query.setParameter("x",type);
        List<Compte>comptes=query.getResultList();
        entityTransaction.commit();
        return comptes;
    }

    @Override
    public Compte update(Compte compte) {
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(compte);
        entityTransaction.commit();
        return compte;
    }

    @Override
    public void delete(Long id) {
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        Compte compte=entityManager.find(Compte.class,id);
        entityManager.remove(compte);
        entityTransaction.commit();

    }


}
