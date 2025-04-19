package sv.infotech.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import sv.infotech.dto.CustomerDto;
import sv.infotech.dto.InstrumentDto;
import sv.infotech.dto.OrderDto;
import sv.infotech.dto.ServiceChargeDto;
import sv.infotech.dto.UPIDto;
import sv.infotech.dto.UserDetailsDto;

public interface UserService {
	public ResponseEntity<String> createUser(UserDetailsDto detailsDto);

	public ResponseEntity<List<UserDetailsDto>> displayAllUsers();

	public String deleteUser(String id, UserDetailsDto userDetailsDto);

	public ResponseEntity<String> saveUser(UserDetailsDto userDetailsDto);

	public ResponseEntity<String> updateUser(String id, UserDetailsDto userDetailsDto);

	public List<UserDetailsDto> getAllCustomers();

	public UserDetailsDto getCustomerById(String id);

	public List<UserDetailsDto> getUserDetailsDto();

	public UserDetailsDto gedisplayAllUsers(String id);

	public ResponseEntity<String> deleteUser(UserDetailsDto userDetailsDto);

}
