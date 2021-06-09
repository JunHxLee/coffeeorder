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
public class BeanController {

        @Autowired
        BeanRepository beanRepository;

        @RequestMapping(value = "/checkAndModify", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

        public boolean checkAndModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
                System.out.println("##### /bean/checkAndModify  called #####");

                boolean status = false;
                String coffeeName = request.getParameter("coffeeName");
                //int qty = Integer.parseInt(request.getParameter("qty"));
                int qty = 1;

                List<Bean> beanList = beanRepository.findByCoffeeName(coffeeName);

                if(beanList == null){
                        System.out.println("====================================================");
                        System.out.println("Bean not found :"+coffeeName);
                        System.out.println("====================================================");

                        return status;
                }
            
                for(Bean bean : beanList){
                        if (bean.getQty() >= qty) {
                                bean.setQty(bean.getQty() - qty);
                                beanRepository.save(bean);
                                status = true;
                                break;
                        }
                }

                return status;

        }
}
