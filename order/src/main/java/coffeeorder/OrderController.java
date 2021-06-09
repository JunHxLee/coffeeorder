package coffeeorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/outofstockCoffee", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public void outofstockCoffee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("##### /order/outofstockCoffee  called #####");

        Order order = new Order();
        order.setId(Long.valueOf(request.getParameter("orderId")));
        order.setCoffeeName(request.getParameter("coffeeName"));
        order.setOrderStatus("Coffee Canceled : Out of stock!!!");
        orderRepository.save(order);

    }

}
