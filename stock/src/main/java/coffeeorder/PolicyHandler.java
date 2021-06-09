package coffeeorder;

import coffeeorder.config.kafka.KafkaProcessor;

import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired BeanRepository beanRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCoffeeThrew_ModifyBean(@Payload CoffeeThrew coffeeThrew){

        if(!coffeeThrew.validate()) return;

        System.out.println("\n\n##### listener ModifyBean : " + coffeeThrew.toJson() + "\n\n");

        // Sample Logic //
        List<Bean> beanList = beanRepository.findByCoffeeName(coffeeThrew.getCoffeeName());

        if(beanList.size() == 0){
            System.out.println("====================================================");
            System.out.println("Bean not found :"+coffeeThrew.getCoffeeName());
            System.out.println("====================================================");

            return;
        }

        Bean bean = beanList.get(0);
        bean.setQty(bean.getQty() + 1);
        beanRepository.save(bean);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
