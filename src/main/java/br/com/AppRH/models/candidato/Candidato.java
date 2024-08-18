package br.com.AppRH.models.candidato;


import br.com.AppRH.models.vaga.Vaga;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
@Getter
public class Candidato {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String rg;

    @NotEmpty
    private String nomeCandidato;

    @NotEmpty
    @Email
    private String email;


    @ManyToOne
    private Vaga vaga;

    public static interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    }
}
