package com.entra21.sistemarh.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.entra21.sistemarh.Models.Vaga;

public interface VagaRepository extends CrudRepository<Vaga, String> {
    Vaga findByCodigo(long codigo);
    List<Vaga> findByNome(String nome);
    
}
