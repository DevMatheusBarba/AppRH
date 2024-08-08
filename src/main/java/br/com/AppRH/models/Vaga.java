package br.com.AppRH.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Vaga implements Serializable {

    private static final long serialVersionUID = 1L; //Verificar se a versão atual está OK

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String nome;
    @NotEmpty
    private String descicao;
    @NotEmpty
    private String data;
    @NotEmpty
    private String salario;

    @OneToMany (mappedBy = "vaga", cascade = CascadeType.REMOVE)
    private List<Candidato> candidatos;
}
