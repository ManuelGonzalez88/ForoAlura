package com.foroAlura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foroAlura.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
