package sv.infotech.controller;

import java.util.Base64;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sv.infotech.serviceImpl.QrServiceImpl;

@RestController
@RequestMapping("/QrGenerator")
public class QrRestController {
    
    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";

    @GetMapping("/getQrCode")
    public String getQRCode(@RequestParam String msg,@RequestParam int width,@RequestParam int height) {
                 
        byte[] image = new byte[0];
        try {
            // Generate and Return QR Code in Byte Array
            image = QrServiceImpl.getQRCodeImage(msg, width, height);

            // Generate and Save QR Code Image in static/image folder
            QrServiceImpl.generateQRCodeImage("www.svinfotech.com",width, height, QR_CODE_IMAGE_PATH);
           
        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating QR Code";
        }
        
        // Convert Byte Array into Base64 Encoded String
        return Base64.getEncoder().encodeToString(image);
    }
}
