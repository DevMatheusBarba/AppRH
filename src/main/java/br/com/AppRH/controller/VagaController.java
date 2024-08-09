package br.com.AppRH.controller;


import br.com.AppRH.models.vaga.Vaga;
import br.com.AppRH.models.vaga.VagaRepository;
import jakarta.validation.Valid;
import models.candidato.CandidatoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cadastrarVaga")
public class VagaController {

    private VagaRepository vagaRepository;
    private CandidatoRepository candidatoRepository;


    @GetMapping
    public String form() {

        return "vaga/formVaga.html";
    }

    @PostMapping
    public String cadastroForm(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes) {

        //Evetuar a verificação de erro no cadastro da vaga
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/cadastrarVaga";
        }

        vagaRepository.save(vaga);
        attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso");
        return "redirect:/cadastrarVaga";

    }


}
