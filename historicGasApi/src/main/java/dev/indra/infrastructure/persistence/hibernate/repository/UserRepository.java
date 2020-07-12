package dev.indra.infrastructure.persistence.hibernate.repository;

import dev.indra.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
