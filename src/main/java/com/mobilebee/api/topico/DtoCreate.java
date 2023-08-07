package com.mobilebee.api.topico;

public record DtoCreate(
    String titulo,
    String mensagem,
    String autor,
    Curso curso
){}
