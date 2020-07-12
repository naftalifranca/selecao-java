package dev.indra.infrastructure.persistence.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.indra.domain.model.user.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
