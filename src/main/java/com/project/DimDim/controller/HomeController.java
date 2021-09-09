package com.project.DimDim.controller;

import com.project.DimDim.model.Cliente;
import com.project.DimDim.model.Endereco;
import com.project.DimDim.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ClienteService service;

    @RequestMapping(value={"/", "index", "", "home"})
    public String index(Model model){
        List<Cliente> clientes = service.findAllClientes();
        model.addAttribute("clientes", clientes);
        return "index";
    }
}
