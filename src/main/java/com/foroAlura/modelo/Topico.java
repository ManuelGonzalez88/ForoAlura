package com.foroAlura.modelo;

import java.time.LocalDateTime;

import com.foroAlura.dto.DatosModificarTopico;
import com.foroAlura.dto.DatosRegistroTopico;
import com.foroAlura.dto.DatosUsuarioModificarTopico;
import com.foroAlura.repository.UsuarioRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDateTime fecha_creacion = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private EstadoTopico estado = EstadoTopico.NO_RESPONDIDO;
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario autor;
	private String curso;

	public Topico(DatosRegistroTopico datosRegistroTopico, UsuarioRepository usuarioRepository) {
		this.titulo = datosRegistroTopico.titulo();
		this.mensaje = datosRegistroTopico.mensaje();
		this.autor = new Usuario(datosRegistroTopico.autor(), usuarioRepository);
		this.curso = datosRegistroTopico.curso();
	}

	public void modificar(@Valid DatosModificarTopico datosModificarTopico, UsuarioRepository usuarioRepository) {

		if (datosModificarTopico.titulo() != null) {
			this.titulo = datosModificarTopico.titulo();
		}

		if (datosModificarTopico.mensaje() != null) {
			this.mensaje = datosModificarTopico.mensaje();
		}

		if (datosModificarTopico.autor() != null) {
			Usuario usuario = new Usuario(datosModificarTopico.autor(), usuarioRepository);
			this.autor = usuario;
		}

		if (datosModificarTopico.curso() != null) {
			this.curso = datosModificarTopico.curso();
		}

	}

}
