package com.eldorado.appointment.controller;

import com.eldorado.appointment.SecurityUtil;
import com.eldorado.appointment.dto.UsuarioDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {

    @GetMapping
    public Map<String, Object> getUsuarioLogado(final HttpServletRequest request) {
        final UsuarioDTO usuario = SecurityUtil.getUsuario(request);

        final Map<String, Object> map = new HashMap<>(1);
        map.put("nome", usuario.nome);
        return map;
    }
}