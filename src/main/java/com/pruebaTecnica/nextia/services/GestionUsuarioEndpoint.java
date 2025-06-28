package com.pruebaTecnica.nextia.services;

import com.pruebaTecnica.nextia.dao.UsuarioDao;
import com.pruebaTecnica.nextia.schemas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class GestionUsuarioEndpoint {

    @Autowired(required=true)
    private UsuarioDao usuarioDao;

    private static final String NAMESPACE="http://www.nextia.com/usuariosService/";

    @PayloadRoot(namespace = NAMESPACE, localPart = "addUsuarioRequest")
    @ResponsePayload
    public AddUsuarioResponse addUsuario(@RequestPayload AddUsuarioRequest request){

        com.pruebaTecnica.nextia.models.Usuario usuario = new com.pruebaTecnica.nextia.models.Usuario();

        com.pruebaTecnica.nextia.schemas.UsuarioSinId usuarioXsd = request.getUsuario();
        usuario.setApellido(usuarioXsd.getApellido());
        usuario.setEmail(usuarioXsd.getEmail());
        usuario.setNombre(usuarioXsd.getNombre());
        usuario.setPassword(usuarioXsd.getPassword());
        usuario.setTelefono(usuarioXsd.getTelefono());
        usuarioDao.updateUsuario(usuario);

        AddUsuarioResponse response = new AddUsuarioResponse();
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE, localPart = "deleteUsuarioRequest")
    @ResponsePayload
    public DeleteUsuarioResponse deleteUsuario(@RequestPayload DeleteUsuarioRequest request){

        DeleteUsuarioResponse response = new DeleteUsuarioResponse();
        usuarioDao.deleteUsuario((long) request.getId());
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE, localPart = "getUsuarioRequest")
    @ResponsePayload
    public GetUsuarioResponse getUsuario(@RequestPayload GetUsuarioRequest request){

        com.pruebaTecnica.nextia.models.Usuario usuario = usuarioDao.getUsuario((long) request.getId());
        GetUsuarioResponse response = new GetUsuarioResponse();
        Usuario usuarioXsd = new Usuario();

        if(usuario != null){
            usuarioXsd.setApellido(usuario.getApellido());
            usuarioXsd.setEmail(usuario.getEmail());
            usuarioXsd.setNombre(usuario.getNombre());
            usuarioXsd.setId(usuario.getId().intValue());
            usuarioXsd.setPassword(usuario.getPassword());
            usuarioXsd.setTelefono(usuario.getTelefono());
        }

        response.setUsuario(usuarioXsd);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE, localPart = "getUsuariosRequest")
    @ResponsePayload
    public GetUsuariosResponse getUsuarios(@RequestPayload GetUsuariosRequest request){
        List<com.pruebaTecnica.nextia.models.Usuario> usuarios = usuarioDao.getUsuarios();

        GetUsuariosResponse response = new GetUsuariosResponse();
        List<Usuario> usuariosXsd = response.getUsuario();

        for(com.pruebaTecnica.nextia.models.Usuario usuario : usuarios) {
            //imprimimos el objeto pivote
            Usuario usuarioXsd = new Usuario();
            usuarioXsd.setApellido(usuario.getApellido());
            usuarioXsd.setEmail(usuario.getEmail());
            usuarioXsd.setNombre(usuario.getNombre());
            usuarioXsd.setId(usuario.getId().intValue());
            usuarioXsd.setPassword(usuario.getPassword());
            usuarioXsd.setTelefono(usuario.getTelefono());
            usuariosXsd.add(usuarioXsd);
        }

        return response;
    }
    @PayloadRoot(namespace = NAMESPACE, localPart = "updateUsuarioRequest")
    @ResponsePayload
    public UpdateUsuarioResponse updateUsuario(@RequestPayload UpdateUsuarioRequest request){

        com.pruebaTecnica.nextia.models.Usuario usuario = new com.pruebaTecnica.nextia.models.Usuario();

        Usuario usuarioXsd = request.getUsuario();
        usuario.setApellido(usuarioXsd.getApellido());
        usuario.setEmail(usuarioXsd.getEmail());
        usuario.setNombre(usuarioXsd.getNombre());
        usuario.setId((long) usuarioXsd.getId());
        usuario.setPassword(usuarioXsd.getPassword());
        usuario.setTelefono(usuarioXsd.getTelefono());
        usuarioDao.updateUsuario(usuario);

        UpdateUsuarioResponse response = new UpdateUsuarioResponse();
        return response;
    }
}
