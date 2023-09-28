package com.foroAlura.dto;

import jakarta.validation.constraints.NotNull;

public record DatosUsuarioRegistroTopico(
		@NotNull
		Long id) {
}
