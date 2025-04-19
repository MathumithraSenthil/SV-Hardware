package sv.infotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.infotech.dto.ServiceChargeDto;
import sv.infotech.service.ServiceChargeService;

@RestController
@RequestMapping("/ServiceCharge")
public class ServiceChargeController {
	
	@Autowired
	public ServiceChargeService serviceCharge;

	@GetMapping("/getAllCharges")
	public ResponseEntity<List<ServiceChargeDto>> getServiceCharge() {
		return serviceCharge.getServiceAmount();
	}
}
