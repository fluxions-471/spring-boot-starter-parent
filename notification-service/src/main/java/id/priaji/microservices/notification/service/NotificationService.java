package id.priaji.microservices.notification.service;


import id.priaji.microservices.order.event.OrderPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final JavaMailSender javaMailSender;

    @KafkaListener(topics = "order-placed")
    public void listen(OrderPlacedEvent orderPlacedEvent){
        log.info("Got Message from order-place topic {}", orderPlacedEvent);
        // send email to customer
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("71470022@bukopin.co.id");
            messageHelper.setTo(orderPlacedEvent.getEmail().toString());
            messageHelper.setSubject(String.format("Your Order with OrderNumber %s is placed successfully", orderPlacedEvent.getOrderNumber()));
            messageHelper.setText(String.format("""
                            Hi %s,%s
 
                            Your order with order number %s is now placed successfully.
                             
                            Best Regards
                            Spring Shop
                            """,
                    orderPlacedEvent.getFirstName().toString(),
                    orderPlacedEvent.getLastName().toString(),
                    orderPlacedEvent.getOrderNumber()));
        };
        try {
            javaMailSender.send(messagePreparator);
            log.info("Order Notification email sent!!");
        } catch (MailException e){
            log.error("Exception occurred when sending mail ", e);
            throw new RuntimeException("Exception occurred when sending mail", e);
        }

    }
}
