package com.netfix.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netfix.exception.UserNotFoundException;
import com.netfix.model.NetFlixAdminUser;
import com.netfix.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class NetFlixUserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public ResponseEntity<List<NetFlixAdminUser>> getAllUsers(){	
		return new ResponseEntity(userService.findAll(),HttpStatus.OK);
	}
	//HATEOAS
	
	//EntityModel
	@GetMapping("/id/{id}")
	public EntityModel<NetFlixAdminUser> getUser(@PathVariable int id) {
		if(userService.findById(id)==null) {
			throw  new UserNotFoundException("User Does not exist");
		}
		EntityModel em=EntityModel.of(userService.findById(id));
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUsers());
		em.add(link.withRel("all_netflix_user"));
		return em;
	}

	@PostMapping("/new")
	public ResponseEntity<Object> createNewUser(@Valid @RequestBody NetFlixAdminUser netFlixAdminUser) {
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(netFlixAdminUser.getUid()).toUri();
		userService.createUser(netFlixAdminUser);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable int id){
		userService.deleteUser(id); 
	}
}
