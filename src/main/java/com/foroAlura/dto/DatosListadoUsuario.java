package com.foroAlura.dto;

import com.foroAlura.modelo.Usuario;

public record DatosListadoUsuario(
		Long id,
		String nombre,
		String email) {

	public DatosListadoUsuario(Usuario autor) {
		this(autor.getId(),autor.getNombre(),autor.getEmail());
	}

}
