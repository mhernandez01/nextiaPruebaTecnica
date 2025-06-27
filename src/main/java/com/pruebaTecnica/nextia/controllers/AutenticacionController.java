package com.pruebaTecnica.nextia.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacionController {
    /*@Autowired
    private UsuarioDao usuarioDao;*/

    /*@Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioLogueado = usuarioDao.getUsuarioPorCredenciales(usuario);
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }*/
}
