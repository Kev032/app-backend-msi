package com.cibertec.repo;

import com.cibertec.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);

}
