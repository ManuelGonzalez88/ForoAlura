package com.foroAlura.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.foroAlura.dto.DatosListadoTopico;
import com.foroAlura.dto.DatosModificarTopico;
import com.foroAlura.dto.DatosRegistroTopico;
import com.foroAlura.modelo.Topico;
import com.foroAlura.repository.TopicoRepository;
import com.foroAlura.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

	@Autowired
	private TopicoRepository topicoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<DatosListadoTopico> registroTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
			UriComponentsBuilder uriComponentsBuilder) {
		Topico topico = topicoRepository.save(new Topico(datosRegistroTopico, this.usuarioRepository));
		DatosListadoTopico datosListadoTopico= new DatosListadoTopico(topico); 
		
		URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(datosListadoTopico.id()).toUri();
		return ResponseEntity.created(url).body(datosListadoTopico);
	}

	@GetMapping
	public ResponseEntity<Page<Object>> listadoTopicos(Pageable paginacion) {
		return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DatosListadoTopico> listadoTopicosPorId(@PathVariable Long id) {
		return ResponseEntity.ok(new DatosListadoTopico(topicoRepository.getReferenceById(id)));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DatosListadoTopico> modificarTopico(@RequestBody @Valid DatosModificarTopico datosModificarTopico, @PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		topico.modificar(datosModificarTopico, this.usuarioRepository);
		DatosListadoTopico datosListadoTopico = new DatosListadoTopico(topico);
		
		return ResponseEntity.ok(datosListadoTopico);

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity eliminarTopico(@PathVariable Long id) {
		topicoRepository.delete(topicoRepository.getReferenceById(id));
		return ResponseEntity.noContent().build();
	}
}
