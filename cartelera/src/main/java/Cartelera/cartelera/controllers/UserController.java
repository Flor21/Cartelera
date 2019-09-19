package Cartelera.cartelera.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Cartelera.cartelera.dao.UserRepository;
import Cartelera.cartelera.model.*;

/**
 * 
 * @author flor
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping()
	public Page<User> getPage(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@GetMapping("/{idUser}")
	public ResponseEntity<User> findById(@PathVariable Long idUser) {
		Optional<User> opt = repository.findById(idUser);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping()
	public ResponseEntity<User> create(@Valid @RequestBody User createRequest) {
		
		return ResponseEntity.ok(repository.save(createRequest));
			
	}
	
	@PutMapping()
	public ResponseEntity<User> update(@Valid @RequestBody User updateRequest) {
		boolean exists = repository.existsById(updateRequest.getIdUser());
		if (exists) {
			return ResponseEntity.ok(repository.save(updateRequest));
		}
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{idUser}")
	public ResponseEntity<User> delete(@PathVariable Long idUser) {
		Optional<User> opt = repository.findById(idUser);
		if (opt.isPresent()) {
			repository.delete(opt.get());
			return ResponseEntity.ok().build();			
		}
		return ResponseEntity.notFound().build();
	}
	
}

