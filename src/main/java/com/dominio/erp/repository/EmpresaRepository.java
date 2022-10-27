package com.dominio.erp.repository;

import com.dominio.erp.entity.Empresa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class EmpresaRepository implements Serializable {

    @Inject
    private EntityManager entityManager;

    public EmpresaRepository(){

    }

    public EmpresaRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Empresa getById(Long id){
        return entityManager.find(Empresa.class, id);
    }

    public List<Empresa> findByName(String name){
        TypedQuery<Empresa> query = entityManager.createQuery("from Empresa where nomeFantasia like :nomeFantasia", Empresa.class);
        query.setParameter("nomeFantasia", "%" + name + "%");

        return query.getResultList();
    }

    public Empresa save(Empresa empresa){
        return entityManager.merge(empresa);
    }

    public void remove(Empresa empresa){
        empresa = getById(empresa.getId());
        entityManager.remove(empresa);
    }
}
