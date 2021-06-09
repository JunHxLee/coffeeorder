
package coffeeorder.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

//@FeignClient(name="making", url="http://localhost:8082")
@FeignClient(name="making", url="http://making:8080")
public interface CoffeeService {

    @RequestMapping(method= RequestMethod.PUT, path="/throwCoffee")
    public void throwCoffee(@RequestBody Coffee coffee);

}