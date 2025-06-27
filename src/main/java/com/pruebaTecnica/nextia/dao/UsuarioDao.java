package com.pruebaTecnica.nextia.dao;

import com.pruebaTecnica.nextia.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    public List<Usuario> getUsuarios();
    public Usuario getUsuario(Long id);
    public void deleteUsuario(Long id);
    public void updateUsuario(Usuario usuario);
    public void addUsuario(Usuario usuario);
}
