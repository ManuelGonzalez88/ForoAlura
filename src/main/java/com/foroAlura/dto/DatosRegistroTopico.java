package com.foroAlura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
		
		@NotBlank
		String titulo,
		@NotBlank
		String mensaje,
		@NotNull
		DatosUsuarioRegistroTopico autor,
		@NotBlank
		String curso
		
		) {}
