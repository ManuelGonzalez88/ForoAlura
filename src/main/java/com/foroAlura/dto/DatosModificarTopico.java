package com.foroAlura.dto;

public record DatosModificarTopico(
		
		String titulo,
		String mensaje,
		DatosUsuarioModificarTopico autor,
		String curso) {}
