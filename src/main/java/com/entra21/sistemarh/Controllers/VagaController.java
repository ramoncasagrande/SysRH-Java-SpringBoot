package com.entra21.sistemarh.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entra21.sistemarh.Models.Candidato;
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
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarVaga";
        }
        vagaRepository.save(vaga);
        attributes.addFlashAttribute("mensagem", "Vaga cadastrada com Sucesso!");
        return "redirect:/cadastrarVaga";
    }

    //Listar Vagas
    @RequestMapping(value = "/vagas")
    public ModelAndView listaVagas(){
        ModelAndView modelAndView = new ModelAndView("vaga/listaVaga");
        Iterable<Vaga> vagas = vagaRepository.findAll();
        modelAndView.addObject("vagas", vagas);
        return modelAndView;
    }

    //
    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesVaga(@PathVariable("codigo") long codigo) {
        Vaga vaga = vagaRepository.findByCodigo(codigo);
        ModelAndView modelAndView = new ModelAndView("vaga/detalhesVaga");
        modelAndView.addObject("vaga",vaga);

        Iterable<Candidato>candidatos = candidatoRepository.findByVaga(vaga);
        modelAndView.addObject("candidatos", candidatos);

        return modelAndView;

    }

    
}
