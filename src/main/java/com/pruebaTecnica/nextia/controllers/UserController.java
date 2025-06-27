package com.pruebaTecnica.nextia.controllers;

import com.pruebaTecnica.nextia.dao.UsuarioDao;
import com.pruebaTecnica.nextia.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired(required=true)
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id){
        return usuarioDao.getUsuario(id);
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuario", method = RequestMethod.PUT)
    public void updateUsuario(@RequestBody Usuario usuario){
        usuarioDao.updateUsuario(usuario);
    }

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable Long id){
        usuarioDao.deleteUsuario(id);
    }

    @RequestMapping(value = "api/usuario", method = RequestMethod.POST)
    public void addUsuario(@RequestBody Usuario usuario){
        usuarioDao.addUsuario(usuario);
    }
}
