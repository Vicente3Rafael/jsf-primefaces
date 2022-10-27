package com.dominio.erp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ramo_atividade")
public class RamoAtividade implements Serializable {

    private Long id;
    private String descricao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
