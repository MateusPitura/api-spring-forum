package com.mobilebee.api.topico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repository extends JpaRepository<Topico, Long>{
    @Query("select t.titulo as titulo, t.mensagem as mensagem, t.dataCriacao as dataCriacao, " +
    "t.status as status, t.autor as autor, t.curso as curso from Topico as t")
    List<DtoRead> listar();
}
