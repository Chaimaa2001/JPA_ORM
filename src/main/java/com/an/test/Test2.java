package com.an.test;

import com.an.dao.CompteRepository;
import com.an.dao.CompteRepositoryImpl;
import com.an.dao.SingletonEntityManagerFactory;
import com.an.entities.Compte;
import com.an.entities.TypeCompte;

import java.util.Date;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {

        CompteRepository compteRepository=new CompteRepositoryImpl();
        compteRepository.save(new Compte(null,5000,new Date(), TypeCompte.EPARGNE));
        compteRepository.save(new Compte(null,9000,new Date(), TypeCompte.COURANT));
        compteRepository.save(new Compte(null,465000,new Date(), TypeCompte.COURANT));
        System.out.println("----------------------");
        List<Compte> comptes=compteRepository.findAll();
        comptes.forEach(cp->{
            System.out.println(cp.toString());
        });
        System.out.println("-------------------");
        List<Compte>compteCourant=compteRepository.findByType(TypeCompte.COURANT);
        compteCourant.forEach(cp->{
            System.out.println(cp.toString());
        });
        System.out.println("-----------");
        Compte compte=compteRepository.findById(1L);
        System.out.println(compte.toString());
        System.out.println("------------------------");
        Compte compteUpdate=compteRepository.findById(1L);
        compteUpdate.setSolde(compteUpdate.getSolde()+12000);
        compteRepository.update(compte);
        System.out.println("----------------");
        compteRepository.delete(3L);


    }
}
