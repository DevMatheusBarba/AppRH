package br.com.AppRH.controller;


import br.com.AppRH.models.candidato.Candidato;
import br.com.AppRH.models.candidato.CandidatoRepository;
import br.com.AppRH.models.vaga.Vaga;
import br.com.AppRH.models.vaga.VagaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller


public class VagaController {

    private VagaRepository vagaRepository;
    private CandidatoRepository candidatoRepository;

    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.GET)
    public String form() {
        return "vaga/formVaga.html";
    }

    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.POST)
    public String cadastroForm(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes) {

        //Evetuar a verificação de erro no cadastro da vaga
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/cadastrarVaga";
        }
        ;

        vagaRepository.save(vaga);
        attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso");
        return "redirect:/cadastrarVaga";

    }

    ;

    //Sem método
    public ModelAndView listaVagas() {
        ModelAndView mv = new ModelAndView("vaga/listaVaga");
        List<Vaga> vagas = vagaRepository.findAll();
        mv.addObject("vagas", vagas);
        return mv;
    }

    ;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesVaga(@PathVariable("id") long id) {
        Vaga vaga = vagaRepository.findById(id);
        ModelAndView mv = new ModelAndView("vaga/detalhesVaga");
        mv.addObject("vaga", vaga);

        List<Candidato> candidatos = candidatoRepository.findById(vaga);
        return mv;
    }

    ;

    @RequestMapping("/deletarVaga")
    public String deletarVaga(long id) {
        Vaga vaga = vagaRepository.findById(id);
        vagaRepository.delete(vaga);
        return "redirect:/vaga";
    }

    ;


    public String detalhesVagasPost(@PathVariable("id") long id, @Valid Candidato candidato, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("menssagem", "Verifique os campos");
            return "redirect:/{id}";
        }

        if (candidatoRepository.findByRg(candidato.getRg()) != null) {
            attributes.addFlashAttribute("menssagem", "RG duplicado");
            return "redirect:/{id}";
        }

        Vaga vaga = vagaRepository.findById(id);

        candidato.setVaga(vaga);
        candidatoRepository.save(candidato);
        attributes.addFlashAttribute("menssagem", "Candidato adicionado com sucesso");
        return "redirect:/{id}";
    }

}
