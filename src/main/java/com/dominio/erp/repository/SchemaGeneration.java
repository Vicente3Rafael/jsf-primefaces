package com.dominio.erp.repository;

import com.dominio.erp.entity.Empresa;
import com.dominio.erp.entity.RamoAtividade;
import com.dominio.erp.enumeration.TipoEmpresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class SchemaGeneration {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeuProjetoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        RamoAtividadeRepository ramoAtividadeRepository = new RamoAtividadeRepository(em);
        EmpresaRepository empresaRepository = new EmpresaRepository(em);

        List<RamoAtividade> ramoAtividadeList = ramoAtividadeRepository.findBy("");
        List<Empresa> empresaList = empresaRepository.findByName("");

        System.out.println("#### Primeira lista de empresas ####");
        int i = 1;
        for(Empresa e: empresaList){
            System.out.println(i + " - " + e.getNomeFantasia());
            i++;
        }

        Empresa empresa = new Empresa();
        empresa.setNomeFantasia("Hayabusa");
        empresa.setCnpj("41.952.519/0001-57");
        empresa.setRazaoSocial("Marca de Roupa LTDA");
        empresa.setTipo(TipoEmpresa.LTDA);
        empresa.setDataFundacao(new Date());
        empresa.setRamoAtividade(ramoAtividadeList.get(2));

        empresaRepository.save(empresa);
        em.getTransaction().commit();

        empresaList = empresaRepository.findByName("");

        System.out.println("#### Segunda lista de empresas ####");
        i = 1;
        for(Empresa e: empresaList){
            System.out.println(i + " - " + e.getNomeFantasia());
            i++;
        }

        em.close();
        emf.close();
    }
}
