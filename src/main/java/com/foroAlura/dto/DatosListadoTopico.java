package com.foroAlura.dto;

import java.time.LocalDateTime;

import com.foroAlura.modelo.EstadoTopico;
import com.foroAlura.modelo.Topico;
import com.foroAlura.modelo.Usuario;

public record DatosListadoTopico(
		Long id,
		String titulo,
		String mensaje,
		LocalDateTime fecha_creacion,
		EstadoTopico estado,
		String autor,
		String curso) {
	
	public DatosListadoTopico(Topico topico){
		this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha_creacion(),
				topico.getEstado(),topico.getAutor(),topico.getCurso());
	}

}
