package models.candidato;

import br.com.AppRH.models.candidato.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    
}
