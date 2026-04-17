/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividadeSpring2.gerenciamento.controller;

import com.atividadeSpring2.gerenciamento.model.FuncionarioBean;
import com.atividadeSpring2.gerenciamento.service.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author João Paulo
 */
@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping("/funcionarios")
    public String getFuncionarios(Model model) {
        List<FuncionarioBean> lista = service.lerTodos();
        model.addAttribute("lista", lista);
        return "funcionarios";
    }

    @GetMapping("/perfil")
    public String perfil(@RequestParam int id, Model model) {
        FuncionarioBean funcionario = service.lerPorId(id);
        model.addAttribute("funcionario", funcionario);
        return "perfil";
    }

    @PostMapping("/salvar")
    public String salvarDados(@ModelAttribute FuncionarioBean funcionario) {
        service.editarFunc(funcionario);
        return "redirect:/funcionarios";
    }

    @PostMapping("/cadastrar")
    public String addNewFunc(@ModelAttribute FuncionarioBean newFunc) {
        service.addFunc(newFunc);
        return "redirect:/funcionarios";
    }

    @GetMapping("/cadastrar-novo")
    public String cadastrarNovo(Model model) {
        FuncionarioBean newFunc = new FuncionarioBean();
        model.addAttribute("newFunc", newFunc);
        return "cadastrar-novo";
    }
}
