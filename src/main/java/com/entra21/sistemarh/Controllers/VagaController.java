package com.entra21.sistemarh.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entra21.sistemarh.Models.Vaga;
import com.entra21.sistemarh.Repositories.CandidatoRepository;
import com.entra21.sistemarh.Repositories.VagaRepository;

@Controller
public class VagaController {

    @Autowired
    private VagaRepository vagaRepository;
    private CandidatoRepository candidatoRepository;

    //Cadastrar Vaga
    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.GET)
    public String form(){
        return "vaga/formVaga";
    }

    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.POST)
    public String form(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!")
            return "redirect:/cadastrarVaga";
        }
        vagaRepository.save(vaga);
        attributes.addFlashAttribute("mensagem", "Vaga cadastrada com Sucesso!");
        return "redirect:/cadastrarVaga";
    }
    
}
