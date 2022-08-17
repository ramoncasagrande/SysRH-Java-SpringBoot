package com.entra21.sistemarh.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.entra21.sistemarh.Models.Candidato;
import com.entra21.sistemarh.Models.Vaga;

public interface CandidatoRepository extends CrudRepository<Candidato, String> {

    Iterable<Candidato> findByVaga(Vaga vaga);
}
