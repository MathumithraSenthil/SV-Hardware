package sv.infotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.infotech.dto.UserDetailsDto;
import sv.infotech.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody UserDetailsDto userDetailsDto) {
		return userService.createUser(userDetailsDto);
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<UserDetailsDto> getUserById(@PathVariable String id) {
		UserDetailsDto user = userService.gedisplayAllUsers(id);
		return ResponseEntity.ok(user);
	}

	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody UserDetailsDto userDetailsDto) {
		return userService.deleteUser(userDetailsDto);
	}

}
