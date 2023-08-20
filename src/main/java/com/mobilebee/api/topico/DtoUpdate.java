package com.mobilebee.api.topico;

public record DtoUpdate(
    String titulo,
    String mensagem,
    Curso curso
){
    public DtoUpdate(Topico t){
        this(t.getTitulo(), t.getMensagem(), t.getCurso());
    }

}
