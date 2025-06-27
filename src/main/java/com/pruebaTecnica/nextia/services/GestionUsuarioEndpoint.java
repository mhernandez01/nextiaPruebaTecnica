package com.pruebaTecnica.nextia.services;

import com.pruebaTecnica.nextia.schemas.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GestionUsuarioEndpoint {

    private static final String NAMESPACE="http://www.nextia.com/usuariosService/";

    @PayloadRoot(namespace = NAMESPACE, localPart = "addUsuario")
    @ResponsePayload
    public AddUsuarioResponse addUsuario(@RequestPayload AddUsuario request){

        AddUsuarioResponse response = new AddUsuarioResponse();
        UsuarioSinId usuario = request.getUsuario();
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE, localPart = "deleteUsuario")
    @ResponsePayload
    public DeleteUsuarioResponse deleteUsuario(@RequestPayload DeleteUsuario request){

        DeleteUsuarioResponse response = new DeleteUsuarioResponse();
        Integer id = request.getId();
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE, localPart = "getUsuario")
    @ResponsePayload
    public GetUsuarioResponse getUsuario(@RequestPayload GetUsuario request){

        GetUsuarioResponse response = new GetUsuarioResponse();
        Integer id = request.getId();
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE, localPart = "getUsuarios")
    @ResponsePayload
    public GetUsuariosResponse getUsuarios(@RequestPayload GetUsuarios request){

        GetUsuariosResponse response = new GetUsuariosResponse();
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE, localPart = "updateUsuario")
    @ResponsePayload
    public UpdateUsuarioResponse updateUsuario(@RequestPayload UpdateUsuario request){

        UpdateUsuarioResponse response = new UpdateUsuarioResponse();
        Usuario usuario = request.getUsuario();
        return response;
    }
}
