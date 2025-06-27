package com.pruebaTecnica.nextia.dao;

import com.pruebaTecnica.nextia.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String qry = "FROM Usuario";
        return entityManager.createQuery(qry).getResultList();
    }

    @Override
    public Usuario getUsuario(Long id) {
        return entityManager.find(Usuario.class,id);
    }

    @Override
    public void deleteUsuario(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void addUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }
/*
    @Override
    public Usuario getUsuarioPorCredenciales(Usuario usuario) {

        @PersistenceContext
        EntityManager entityManager;

        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getPassword())) {
            return lista.get(0);
        }
        return null;
    }*/
}
