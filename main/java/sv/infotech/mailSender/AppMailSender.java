package sv.infotech.mailSender;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
import sv.infotech.dto.CustomerDto;
import sv.infotech.dto.OrderDto;

@Component
public class AppMailSender {

	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendOrderEmail(CustomerDto customerDto,OrderDto orderDto ,FileSystemResource fileSystemResource, String subject) {
		
		
		boolean flag = false;
		try {

			// create mimeMessage object
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			// create helper
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, fileSystemResource != null ? true : false);
			// compose the message
			helper.setTo("mathumithrasenthil2812@gmail.com");
			helper.setFrom("mathumithrasenthil2002@gmail.com");
			helper.setSubject(subject);
			
			List<String> text1= new ArrayList<>();
			text1.add("Hello!");
			//text1.add("customer Id:"+ customerDto.getCustomerId());
			text1.add("customer name:"+ customerDto.getFirstName());
			text1.add("order id:"+ orderDto.getOrderId());
			text1.add("sales/service:"+ orderDto.getTypeOfOperation());
			text1.add("Service for:"+ orderDto.getServiceFor());
			text1.add("Amount:"+ orderDto.getTotalAmount());
			String sendText=String.join("\n", text1);
			
			helper.setText(sendText);
			
			helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
			// send the mail
			mailSender.send(mimeMessage);
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			System.out.println(e);
		}
		return flag;
	}
}
