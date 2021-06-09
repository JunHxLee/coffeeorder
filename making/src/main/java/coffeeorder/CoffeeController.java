package coffeeorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class CoffeeController {

    @Autowired
    CoffeeRepository coffeeRepository;

    @RequestMapping(value = "/throwCoffee", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")

    public void throwCoffee(@RequestBody Coffee requestCoffee) throws Exception {
        System.out.println("##### /coffee/throwCoffee  called #####");
        
        Long orderId = requestCoffee.getOrderId();


        List<Coffee> listCoffee = coffeeRepository.findByOrderId(orderId);
        for (Coffee coffee : listCoffee) {
            coffee.setMakeStatus("Coffee Canceled");
            coffeeRepository.save(coffee);
        }
    }

}
