package com.cibertec.service;

import com.cibertec.models.Usuario;
import com.cibertec.models.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);

    public Usuario autenticarUsuario(String username, String password) throws Exception;
}
