/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividadeSpring2.gerenciamento.service;

import com.atividadeSpring2.gerenciamento.model.FuncionarioBean;
import com.atividadeSpring2.gerenciamento.repository.FuncionarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author João Paulo
 */
@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioDAO repository;

    public List<FuncionarioBean> lertodos() {
        return repository.lertodos();
    }
}
