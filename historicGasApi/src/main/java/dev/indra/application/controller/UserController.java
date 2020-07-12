package dev.indra.application.controller;

import dev.indra.domain.model.user.User;
import dev.indra.domain.service.BaseService;
import dev.indra.infrastructure.service.ResponseService;
import dev.indra.presentation.assembler.UserAssembler;
import dev.indra.presentation.dto.shared.ResponseTO;
import dev.indra.presentation.dto.user.UserRequestTO;
import dev.indra.presentation.dto.user.UserResponseTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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