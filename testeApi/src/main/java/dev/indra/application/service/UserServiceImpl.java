package dev.indra.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.indra.domain.model.user.User;
import dev.indra.domain.service.BaseService;
import dev.indra.infrastructure.persistence.hibernate.repository.UserRepository;

@Service
public class UserServiceImpl implements BaseService<User> {

    private final UserRepository repository;
    
    

    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User entity) {

        return repository.save(entity);
    }

    @Override
    public User update(Long id, User entity) {
        User savedUser = findBy(id);
        savedUser.setUsername(entity.getUsername());
        savedUser.setPassword(entity.getPassword());
        savedUser.setDateBirth(entity.getDateBirth());
        return repository.save(savedUser);
    }

    @Override
    public User findBy(Long id) {
        Optional<User> optUser = repository.findById(id);
        if(!optUser.isPresent()) {
            throw new RuntimeException("Usuário inexistente");
        }
        return optUser.get();
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
        
    }

}
