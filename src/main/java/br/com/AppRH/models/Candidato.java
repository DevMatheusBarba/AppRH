package br.com.AppRH.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

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

}
