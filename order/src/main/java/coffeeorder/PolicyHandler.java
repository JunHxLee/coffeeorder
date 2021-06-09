package coffeeorder;

import coffeeorder.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;

    // @StreamListener(KafkaProcessor.INPUT)
    // public void wheneverCoffeeMade_CancelCoffee(@Payload CoffeeMade coffeeMade){

    //     if(!coffeeMade.validate()) return;

    //     System.out.println("\n\n##### listener CancelCoffee : " + coffeeMade.toJson() + "\n\n");

    //     // Sample Logic //
    //     Order order = new Order();
    //     order.setId(coffeeMade.getOrderId());
    //     order.setCoffeeName(coffeeMade.getCoffeeName());
    //     order.setOrderStatus("Coffee Canceled : Out of stock!!!");
    //     orderRepository.save(order);
            
    // }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
