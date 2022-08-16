package com.entra21.sistemarh.Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;


public class Vaga implements Serializable {

    private static final Long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String descricao;

    @NotEmpty
    private String data;

    @NotEmpty
    private String salario;



    
}
