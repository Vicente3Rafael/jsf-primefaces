package com.dominio.erp.service;

import com.dominio.erp.entity.Empresa;
import com.dominio.erp.repository.EmpresaRepository;
import com.dominio.erp.util.Transacional;

import javax.inject.Inject;
import java.io.Serializable;

public class EmpresaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject private EmpresaRepository empresaRepository;

    @Transacional
    public void salvar(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    @Transacional
    public void excluir(Empresa empresa) {
        empresaRepository.remove(empresa);
    }
}