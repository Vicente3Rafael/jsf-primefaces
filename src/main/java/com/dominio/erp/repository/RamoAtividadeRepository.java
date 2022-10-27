package com.dominio.erp.repository;

import com.dominio.erp.entity.RamoAtividade;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class RamoAtividadeRepository implements Serializable {

    @Inject
    private EntityManager entityManager;

    public RamoAtividadeRepository(){

    }

    public RamoAtividadeRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<RamoAtividade> findBy(String descricao){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);
        Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), "%" + descricao + "%"));

        TypedQuery<RamoAtividade> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}