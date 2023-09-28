package com.foroAlura.modelo;

import com.foroAlura.dto.DatosUsuarioModificarTopico;
import com.foroAlura.dto.DatosUsuarioRegistroTopico;
import com.foroAlura.repository.UsuarioRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String email;
	private String contrasena;

	public Usuario(DatosUsuarioRegistroTopico autor, UsuarioRepository usuarioRepository) {
		this.id = autor.id();
		this.nombre = usuarioRepository.getReferenceById(autor.id()).getNombre();
		this.email = usuarioRepository.getReferenceById(autor.id()).getEmail();
		this.contrasena = usuarioRepository.getReferenceById(autor.id()).getContrasena();
	}

	public Usuario(DatosUsuarioModificarTopico autor, UsuarioRepository usuarioRepository) {

		this.id = autor.id();
		this.nombre = usuarioRepository.getReferenceById(autor.id()).getNombre();
		this.email = usuarioRepository.getReferenceById(autor.id()).getEmail();
		this.contrasena = usuarioRepository.getReferenceById(autor.id()).getContrasena();
	}
}
