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

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCoffeeServed_NoticeStatus(@Payload CoffeeServed coffeeServed){

        if(!coffeeServed.validate()) return;

        System.out.println("\n\n##### listener NoticeStatus : " + coffeeServed.toJson() + "\n\n");

        // Sample Logic //
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCoffeeMade_NoticeStatus(@Payload CoffeeMade coffeeMade){

        if(!coffeeMade.validate()) return;

        System.out.println("\n\n##### listener NoticeStatus : " + coffeeMade.toJson() + "\n\n");

        // Sample Logic //
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCoffeeOrdered_NoticeStatus(@Payload CoffeeOrdered coffeeOrdered){

        if(!coffeeOrdered.validate()) return;

        System.out.println("\n\n##### listener NoticeStatus : " + coffeeOrdered.toJson() + "\n\n");

        // Sample Logic //
            
    }
    // @StreamListener(KafkaProcessor.INPUT)
    // public void wheneverCoffeeCanceled_NoticeStatus(@Payload CoffeeCanceled coffeeCanceled){

    //     if(!coffeeCanceled.validate()) return;

    //     System.out.println("\n\n##### listener NoticeStatus : " + coffeeCanceled.toJson() + "\n\n");

    //     // Sample Logic //
            
    // }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCoffeeThrew_NoticeStatus(@Payload CoffeeThrew coffeeThrew){

        if(!coffeeThrew.validate()) return;

        System.out.println("\n\n##### listener NoticeStatus : " + coffeeThrew.toJson() + "\n\n");

        // Sample Logic //
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCoffeeSoldOut_NoticeStatus(@Payload CoffeeSoldOut coffeeSoldOut){

        if(!coffeeSoldOut.validate()) return;

        System.out.println("\n\n##### listener NoticeStatus : " + coffeeSoldOut.toJson() + "\n\n");

        // Sample Logic //
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
