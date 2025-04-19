package sv.infotech.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sv.infotech.dto.ServiceChargeDto;


public interface ServiceChargeService {

	ResponseEntity<List<ServiceChargeDto>> getServiceAmount();

}
