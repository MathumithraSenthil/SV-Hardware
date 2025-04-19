package sv.infotech.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sv.infotech.dto.ServiceChargeDto;
import sv.infotech.entity.ServiceCharge;
import sv.infotech.repository.ServiceChargeRepository;
import sv.infotech.service.ServiceChargeService;

@Service
public class ServiceChargeImpl implements ServiceChargeService{

	@Autowired
	public ServiceChargeRepository serviceChargeRepository;
	
	public ResponseEntity<List<ServiceChargeDto>> getServiceAmount(){
		
		List<ServiceCharge> charge = serviceChargeRepository.findAll();
		List<ServiceChargeDto> serviceChargeDto= new ArrayList<>();
		
		for(ServiceCharge serviceCharge: charge) {
			
			ServiceChargeDto chargeDto=new ServiceChargeDto();
			
			chargeDto.setServiceChargeid(serviceCharge.getServiceChargeid());
			chargeDto.setName(serviceCharge.getName());
			chargeDto.setAmount(serviceCharge.getAmount());
			serviceChargeDto.add(chargeDto);
		}
		
		
		return new ResponseEntity<List<ServiceChargeDto>> (serviceChargeDto,HttpStatus.OK);
	}
	
}
