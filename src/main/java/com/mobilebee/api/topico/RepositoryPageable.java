package com.mobilebee.api.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RepositoryPageable extends PagingAndSortingRepository<Topico, Long>{
    @Query("select t.titulo as titulo, t.mensagem as mensagem, t.dataCriacao as dataCriacao, " +
    "t.status as status, t.autor as autor, t.curso as curso from Topico as t")
    Page<DtoRead> listar(Pageable p);

    @Query("select t.titulo as titulo, t.mensagem as mensagem, t.dataCriacao as dataCriacao, " +
    "t.status as status, t.autor as autor, t.curso as curso from Topico as t where year(t.dataCriacao) = :ano")
    Page<DtoRead> listarPeloAno(Pageable p, String ano);
}
