package com.mobilebee.api.topico;

import java.util.Date;

public interface DtoRead {
    String getTitulo();
    String getMensagem();
    Date getDataCriacao();
    Boolean getStatus();
    String getAutor();
    Curso getCurso();
}
