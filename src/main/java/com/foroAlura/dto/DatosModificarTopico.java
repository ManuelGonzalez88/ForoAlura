package com.foroAlura.dto;

import com.foroAlura.modelo.Usuario;

public record DatosModificarTopico(
		
		String titulo,
		String mensaje,
		DatosUsuarioModificarTopico autor,
		String curso) {}
