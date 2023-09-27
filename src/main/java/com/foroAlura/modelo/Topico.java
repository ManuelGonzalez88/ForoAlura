package com.foroAlura.modelo;
import java.time.LocalDateTime;

import com.foroAlura.dto.DatosModificarTopico;
import com.foroAlura.dto.DatosRegistroTopico;

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
//	@ManyToOne(fetch=FetchType.LAZY)
	private String autor;
	private String curso;

	public Topico(DatosRegistroTopico datosRegistroTopico) {
		this.titulo = datosRegistroTopico.titulo();
		this.mensaje = datosRegistroTopico.mensaje();
		this.autor = datosRegistroTopico.autor();
		this.curso = datosRegistroTopico.curso();
	}

	public void modificar(@Valid DatosModificarTopico datosModificarTopico) {
		
		if(datosModificarTopico.titulo() != null) {
			this.titulo = datosModificarTopico.titulo();
		}
		
		if(datosModificarTopico.mensaje()!= null) {
			this.mensaje = datosModificarTopico.mensaje();
		}

		if(datosModificarTopico.autor() != null) {
			this.autor = datosModificarTopico.autor();
		}

		if(datosModificarTopico.curso()!= null) {
			this.curso = datosModificarTopico.curso();
		}

	}

}
