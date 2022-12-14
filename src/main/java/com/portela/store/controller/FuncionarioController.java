package com.portela.store.controller;


import com.portela.store.model.Funcionario;
import com.portela.store.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/administrativo/funcionarios/cadastrar")
    public ModelAndView cadastrar(Funcionario funcionario){
        ModelAndView mv = new ModelAndView("administrativo/funcionarios/cadastro");
        mv.addObject("funcionario", funcionario);
        return mv;
    }

    @GetMapping("/administrativo/funcionarios/listar")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("administrativo/funcionarios/lista");
        mv.addObject("listaFuncionarios", funcionarioRepository.findAll());
        return mv;
    }

    @GetMapping("/administrativo/funcionarios/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        return cadastrar(funcionario.get());
    }

    @GetMapping("/administrativo/funcionarios/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Long id){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        funcionarioRepository.delete(funcionario.get());
        return listar();
    }

    @PostMapping("/administrativo/funcionarios/salvar")
    public ModelAndView salvar(@Validated Funcionario funcionario, BindingResult result){
        if(result.hasErrors()){
            return cadastrar(funcionario);
        }
        funcionarioRepository.save(funcionario);
        return cadastrar(new Funcionario());
    }
}
