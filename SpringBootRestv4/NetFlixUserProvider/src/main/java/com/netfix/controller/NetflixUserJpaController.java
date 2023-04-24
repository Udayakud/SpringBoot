package com.netfix.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netfix.exception.UserNotFoundException;
import com.netfix.model.NetFlixAdminUser;
import com.netfix.model.TypeOfPost;
import com.netfix.repository.NetflixUserRepository;
import com.netfix.repository.TypeOfPostRepository;

import jakarta.validation.Valid;

@RestController
public class NetflixUserJpaController {
	

	@Autowired
	private NetflixUserRepository repo;
	
	@Autowired
	private TypeOfPostRepository topr;
	
	
	@GetMapping("/users")
	public ResponseEntity<List<NetFlixAdminUser>> getAllUsers(){	
		return new ResponseEntity(repo.findAll(),HttpStatus.OK);
	}
	//HATEOAS
	
	//EntityModel
	@GetMapping("/users/{id}")
	public EntityModel<NetFlixAdminUser> getUser(@PathVariable int id) {
		if(repo.findById(id).isEmpty()) {
			throw  new UserNotFoundException("User Does not exist");
		}
		EntityModel em=EntityModel.of(repo.findById(id).get());
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUsers());
		em.add(link.withRel("all_netflix_user"));
		return em;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createNewUser(@Valid @RequestBody NetFlixAdminUser netFlixAdminUser) {
		//URI location=ServletUriComponentsBuilder.fromCurrentRequest.path("/id").buildAndExpand(netFlixAdminUser.getUid()).toUri();
		@Valid
		NetFlixAdminUser save = repo.save(netFlixAdminUser);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(save.getUid())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		repo.deleteById(id); 
	}
	
	@GetMapping("/users/{id}/top")
	public List<TypeOfPost> getTypeOfPosts(@PathVariable int id){
		if(repo.findById(id).isEmpty()) {
			throw  new UserNotFoundException("User Does not exist");
		}
		//ctrl+2 l
	    Optional<NetFlixAdminUser> findById = repo.findById(id);
		return repo.findById(id).get().getTop(); 
	}
	
	@PostMapping("/users/{id}/top")
	public ResponseEntity<Object> createTypeOfPosts(@PathVariable int id,@Valid @RequestBody TypeOfPost top){
		if(repo.findById(id).isEmpty()) {
			throw  new UserNotFoundException("User Does not exist");
		}
		top.setNau(repo.findById(id).get());
		@Valid
		TypeOfPost save = topr.save(top);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(save.getId())
				.toUri();
		return ResponseEntity.created(location).build(); 
	}
}
