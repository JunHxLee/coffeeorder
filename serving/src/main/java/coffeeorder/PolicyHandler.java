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
    @Autowired ServingRepository servingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCoffeeMade_NoticeCoffeeReady(@Payload CoffeeMade coffeeMade){

        if(!coffeeMade.validate()) return;

        System.out.println("\n\n##### listener NoticeCoffeeReady : " + coffeeMade.toJson() + "\n\n");

        // Sample Logic //
        Serving serving = new Serving();
        serving.setOrderId(coffeeMade.getOrderId());
        serving.setCoffeeName(coffeeMade.getCoffeeName());
        serving.setServingStatus("Coffee Served");
        servingRepository.save(serving);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
