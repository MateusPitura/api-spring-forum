package com.mobilebee.api.topico;

public record DtoCreate(
    String titulo,
    String mensagem,
    String autor,
    Curso curso
){
    public DtoCreate(Topico t){
        this(t.getTitulo(), t.getMensagem(), t.getAutor(), t.getCurso());
    }
}
