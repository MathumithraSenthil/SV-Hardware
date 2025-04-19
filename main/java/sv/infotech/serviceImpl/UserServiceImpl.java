package sv.infotech.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sv.infotech.dto.CustomerDto;
import sv.infotech.dto.UserDetailsDto;
import sv.infotech.entity.User;
import sv.infotech.repository.IUsertRepository;
import sv.infotech.service.UserService;

@Service
public class UserServiceImpl implements UserService {
//1.Autowired repo 
	@Autowired
	private IUsertRepository userRepository;

	public ResponseEntity<String> createUser(UserDetailsDto userDetailsDto) {

		String response = null;
		if (userDetailsDto != null) {
			User user = null;
			// update
			if (userDetailsDto.getUserId() != null) {
				// FETCH DATA FROM DB
				user = userRepository.findByClientId(Integer.parseInt(userDetailsDto.getUserId()));

				if (user != null) {
					// set values fn,ln,pwd ,address,mobno,IsActive, IsDelete
					user.setClientId(Integer.parseInt(userDetailsDto.getUserId()));
					user.setClientFirstName(userDetailsDto.getFirstName());
					user.setClientLastName(userDetailsDto.getLastName());
					user.setClientAddress(userDetailsDto.getAddress());
					user.setPhnNum(userDetailsDto.getMobileNumber());
					user.setClientPassword(userDetailsDto.getPassword());
					user.setIsActive("Y");
					user.setIsDelete("N");
					// saving
					userRepository.save(user);
				}

				response = "Updated SuccessFully";

			} else {
				// create
				// set fn ln email address mobno
				user = new User();
				user.setClientFirstName(userDetailsDto.getFirstName());
				user.setClientLastName(userDetailsDto.getLastName());
				user.setClientAddress(userDetailsDto.getAddress());
				user.setClientMail(userDetailsDto.getEmail());
				user.setPhnNum(userDetailsDto.getMobileNumber());
				user.setIsActive("Y");
				user.setIsDelete("N");
				response = "Created SuccessFully";

			}
			userRepository.save(user);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// display users
	public ResponseEntity<List<UserDetailsDto>>  displayAllUsers() {

		List<User> users = userRepository.findByIsActive("Y");
		List<UserDetailsDto> userDetails = new ArrayList<>();

		for (User user : users) {
			UserDetailsDto userDetailsDto2 = new UserDetailsDto();
			userDetailsDto2.setUserId(Integer.toString(user.getClientId()));
			userDetailsDto2.setFirstName(user.getClientFirstName());
			userDetailsDto2.setLastName(user.getClientLastName());
			userDetailsDto2.setMobileNumber(user.getPhnNum());
			userDetailsDto2.setAddress(user.getClientAddress());
			userDetailsDto2.setEmail(user.getClientMail());
			userDetailsDto2.setPassword(user.getClientPassword());
			userDetails.add(userDetailsDto2);
		}
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}

	// delete users
	public ResponseEntity<String> deleteUser(UserDetailsDto userDetailsDto) {
		String response = null;
		User user = userRepository.findByClientId(Integer.parseInt(userDetailsDto.getUserId()));
		if (user != null && "Y".equals(user.getIsActive())) {

			user.setIsActive("N");
			user.setIsDelete("Y");

			userRepository.save(user);

			response = "User deleted Succesfully";
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public String deleteUser(String id, UserDetailsDto userDetailsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> saveUser(UserDetailsDto userDetailsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> updateUser(String id, UserDetailsDto userDetailsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDetailsDto> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetailsDto getCustomerById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDetailsDto> getUserDetailsDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetailsDto gedisplayAllUsers(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
