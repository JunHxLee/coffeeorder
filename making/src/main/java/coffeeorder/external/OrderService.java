
package coffeeorder.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

//@FeignClient(name="order", url="http://localhost:8081")
@FeignClient(name="order", url="http://order:8080")
public interface OrderService {

    @RequestMapping(method= RequestMethod.GET, path="/outofstockCoffee")
    public void cancelCoffee(@RequestParam("orderId") Long orderId, @RequestParam("coffeeName") String coffeeName);

}