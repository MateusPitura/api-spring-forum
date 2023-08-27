package com.mobilebee.api.topico;

import jakarta.validation.constraints.Pattern;

public record DtoUpdate(
    @Pattern(regexp = "^(?!\s+$).+", message = "O titulo não pode ser vazio")
    String titulo,
    @Pattern(regexp = "^(?!\s+$).+", message = "A mensagem não pode ser vazia")
    String mensagem,
    Curso curso
){
    public DtoUpdate(Topico t){
        this(t.getTitulo(), t.getMensagem(), t.getCurso());
    }

}
