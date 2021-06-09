package coffeeorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jdk.internal.misc.Unsafe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/outofstockCoffee", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public void outofstockCoffee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("##### /order/outofstockCoffee  called #####");

        String configMap = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");


        Order order = new Order();
        order.setId(Long.valueOf(request.getParameter("orderId")));
        order.setCoffeeName(request.getParameter("coffeeName"));
        order.setOrderStatus("Coffee Canceled : Out of stock!!!  **configMap test = "+configMap );
        orderRepository.save(order);

    }


}
