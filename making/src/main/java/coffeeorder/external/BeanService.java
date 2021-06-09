
package coffeeorder.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

//@FeignClient(name="stock", url="http://localhost:8085")
@FeignClient(name="stock", url="http://stock:8080")
public interface BeanService {

    @RequestMapping(method= RequestMethod.GET, path="/checkAndModify")
    public boolean checkAndModify(@RequestParam("coffeeName") String coffeeName);
}