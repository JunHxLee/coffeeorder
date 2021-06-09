package coffeeorder;

import coffeeorder.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ServingScreenViewHandler {


    @Autowired
    private ServingScreenRepository servingScreenRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCoffeeOrdered_then_CREATE_1 (@Payload CoffeeOrdered coffeeOrdered) {
        try {

            if (!coffeeOrdered.validate()) return;

            // view 객체 생성
            ServingScreen servingScreen = new ServingScreen();
            // view 객체에 이벤트의 Value 를 set 함
            servingScreen.setOrderId(coffeeOrdered.getId());
            servingScreen.setCoffeeName(coffeeOrdered.getCoffeeName());
            servingScreen.setStatus(coffeeOrdered.getOrderStatus());
            // view 레파지 토리에 save
            servingScreenRepository.save(servingScreen);
        
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // @StreamListener(KafkaProcessor.INPUT)
    // public void whenCoffeeCanceled_then_UPDATE_1(@Payload CoffeeCanceled coffeeCanceled) {
    //     try {
    //         if (!coffeeCanceled.validate()) return;
    //             // view 객체 조회
    //         List<ServingScreen> servingScreenList = servingScreenRepository.findByOrderId(coffeeCanceled.getId());
    //         for(ServingScreen servingScreen : servingScreenList){
    //             // view 객체에 이벤트의 eventDirectValue 를 set 함
    //             servingScreen.setStatus(coffeeCanceled.getOrderStatus());
    //             // view 레파지 토리에 save
    //             servingScreenRepository.save(servingScreen);
    //         }
            
    //     }catch (Exception e){
    //         e.printStackTrace();
    //     }
    // }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCoffeeMade_then_UPDATE_2(@Payload CoffeeMade coffeeMade) {
        try {
            if (!coffeeMade.validate()) return;
                // view 객체 조회
            List<ServingScreen> servingScreenList = servingScreenRepository.findByOrderId(coffeeMade.getOrderId());
            for(ServingScreen servingScreen : servingScreenList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                servingScreen.setStatus(coffeeMade.getMakeStatus());
                // view 레파지 토리에 save
                servingScreenRepository.save(servingScreen);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCoffeeServed_then_UPDATE_3(@Payload CoffeeServed coffeeServed) {
        try {
            if (!coffeeServed.validate()) return;
                // view 객체 조회
            List<ServingScreen> servingScreenList = servingScreenRepository.findByOrderId(coffeeServed.getOrderId());
            for(ServingScreen servingScreen : servingScreenList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                servingScreen.setStatus(coffeeServed.getServingStatus());
                // view 레파지 토리에 save
                servingScreenRepository.save(servingScreen);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCoffeeThrew_then_UPDATE_4(@Payload CoffeeThrew coffeeThrew) {
        try {
            if (!coffeeThrew.validate()) return;
                // view 객체 조회
            List<ServingScreen> servingScreenList = servingScreenRepository.findByOrderId(coffeeThrew.getOrderId());
            for(ServingScreen servingScreen : servingScreenList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                servingScreen.setStatus(coffeeThrew.getMakeStatus());
                // view 레파지 토리에 save
                servingScreenRepository.save(servingScreen);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCoffeeSoldOut_then_UPDATE_5(@Payload CoffeeSoldOut coffeeSoldOut) {
        try {
            if (!coffeeSoldOut.validate()) return;
                // view 객체 조회
            List<ServingScreen> servingScreenList = servingScreenRepository.findByOrderId(coffeeSoldOut.getId());
            for(ServingScreen servingScreen : servingScreenList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                servingScreen.setStatus(coffeeSoldOut.getOrderStatus());
                // view 레파지 토리에 save
                servingScreenRepository.save(servingScreen);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}