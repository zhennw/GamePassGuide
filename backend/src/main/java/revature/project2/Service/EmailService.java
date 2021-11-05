package revature.project2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String body, String topic){
        System.out.println("sending email");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom("randomizedanimals@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject((topic));
        simpleMailMessage.setText(body);
        System.out.println((mailSender.toString().toCharArray()));
        mailSender.send(simpleMailMessage);
        System.out.println("sent email");
    }
}
