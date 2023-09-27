package com.foroAlura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foroAlura.dto.DatosListadoTopico;
import com.foroAlura.dto.DatosModificarTopico;
import com.foroAlura.dto.DatosRegistroTopico;
import com.foroAlura.modelo.Topico;
import com.foroAlura.repository.TopicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@PostMapping
	@Transactional
	public void registroTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
		topicoRepository.save(new Topico(datosRegistroTopico));
	}
	
	@GetMapping
	@Transactional
	public Page<DatosListadoTopico> listadoTopicos (Pageable paginacion){
		return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
	}
	
	@GetMapping("/{id}")
	@Transactional
	public DatosListadoTopico listadoTopicosPorId (@PathVariable Long id){
		return new DatosListadoTopico(topicoRepository.getReferenceById(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void modificarTopico(@RequestBody @Valid DatosModificarTopico datosModificarTopico,
								@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		topico.modificar(datosModificarTopico);
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void eliminarTopico(@PathVariable Long id) {
		topicoRepository.delete(topicoRepository.getReferenceById(id));
	}
}
