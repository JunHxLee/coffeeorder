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
    @Autowired CoffeeRepository coffeeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCoffeeOrdered_RequestMakeCoffee(@Payload CoffeeOrdered coffeeOrdered){

        if(!coffeeOrdered.validate()) return;

        System.out.println("\n\n##### listener RequestMakeCoffee : " + coffeeOrdered.toJson() + "\n\n");

        // Sample Logic //
        Coffee coffee = new Coffee();
        coffee.setOrderId(coffeeOrdered.getId());
        coffee.setCoffeeName(coffeeOrdered.getCoffeeName());
        coffee.setMakeStatus("Coffee Making");
        coffeeRepository.save(coffee);
            
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCoffeeOrdered_ThrowCoffee(@Payload CoffeeCanceled coffeeCanceled){

        if(!coffeeCanceled.validate()) return;

        System.out.println("\n\n##### listener RequestMakeCoffee : " + coffeeCanceled.toJson() + "\n\n");

        // Sample Logic //
        Coffee coffee = new Coffee();
        coffee.setOrderId(coffeeCanceled.getId());
        coffee.setCoffeeName(coffeeCanceled.getCoffeeName());
        coffee.setMakeStatus("Coffee Threw");
        coffeeRepository.save(coffee);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
