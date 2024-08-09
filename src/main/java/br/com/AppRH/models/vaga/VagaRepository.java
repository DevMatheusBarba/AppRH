package br.com.AppRH.models.vaga;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

    Vaga findById(long id);
    List<Vaga> findByNome  (String nome);
}
