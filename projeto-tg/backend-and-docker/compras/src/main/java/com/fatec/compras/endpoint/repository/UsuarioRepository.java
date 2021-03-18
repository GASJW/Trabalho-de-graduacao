package com.fatec.compras.endpoint.repository;

import com.fatec.compras.endpoint.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
