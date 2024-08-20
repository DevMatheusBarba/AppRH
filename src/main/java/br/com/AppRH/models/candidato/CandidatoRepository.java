package br.com.AppRH.models.candidato;

import br.com.AppRH.models.vaga.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {


    List<Candidato> findById(Vaga vaga);

    Candidato findByRg(String rg);
    Candidato findById (long id);

    List<Candidato> findByNomeCandidato(String nomeCandidato);
}
