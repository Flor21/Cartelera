package Cartelera.cartelera.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cartelera.cartelera.model.User;

/**
 * 
 * @author flor
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findById(Long idUser);

}
