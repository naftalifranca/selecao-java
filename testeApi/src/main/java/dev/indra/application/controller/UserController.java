package dev.indra.application.controller;

import java.util.List;

import dev.indra.domain.model.user.User;
import dev.indra.domain.service.BaseService;
import dev.indra.infrastructure.service.ResponseService;
import dev.indra.presentation.assembler.UserAssembler;
import dev.indra.presentation.dto.user.UserRequestTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.indra.domain.service.BaseService;
import dev.indra.presentation.dto.shared.ResponseTO;
import dev.indra.presentation.dto.user.UserResponseTO;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final BaseService<User> service;

    private final ResponseService responseService;

    public UserController(final BaseService<User> service, final ResponseService responseService) {
        this.service = service;
        this.responseService = responseService;
    }

    @ApiOperation(value = "Busca um usuário pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseTO<UserResponseTO>> find(@PathVariable Long id) {
        return responseService.ok(UserAssembler.from(service.findBy(id)));
    }

    @ApiOperation(value = "Busca todos os usuários")
    @GetMapping
    public ResponseEntity<ResponseTO<List<UserResponseTO>>> findAll() {
        return responseService.ok(UserAssembler.from(service.findAll()));
    }

    @ApiOperation(value = "Cria usuário")
    @PostMapping
    public ResponseEntity<ResponseTO<UserResponseTO>> save(@RequestBody UserRequestTO requestTO) {
        User user = UserAssembler.from(requestTO);
        return responseService.ok(UserAssembler.from(service.save(user)));
    }

    @ApiOperation(value = "Atualiza usuário passando o id o objeto")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseTO<UserResponseTO>> update(@PathVariable Long id,
            @RequestBody UserRequestTO requestTO) {
        User user = UserAssembler.from(requestTO);
        return responseService.ok(UserAssembler.from(service.update(id, user)));
    }

    @ApiOperation(value = "Remove usuário pelo id")
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}