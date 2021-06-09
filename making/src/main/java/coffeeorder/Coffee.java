package coffeeorder;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Coffee_table")
public class Coffee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String coffeeName;
    private String makeStatus;

    @PostPersist
    public void onPostPersist(){

        coffeeorder.external.Bean bean = new coffeeorder.external.Bean();
        bean.setCoffeeName(this.coffeeName);
        boolean status = MakingApplication.applicationContext.getBean(coffeeorder.external.BeanService.class)
            .checkAndModify(bean.getCoffeeName());
        if(!status){
            System.out.println("====================================================");
            System.out.println("Out of stock : "+bean.getCoffeeName());
            System.out.println("====================================================");

            MakingApplication.applicationContext.getBean(coffeeorder.external.OrderService.class)
                .cancelCoffee(this.getOrderId(), this.getCoffeeName());
       
        } else {
            CoffeeMade coffeeMade = new CoffeeMade();
            BeanUtils.copyProperties(this, coffeeMade);
            coffeeMade.publishAfterCommit();

        }

    }

    @PostUpdate
    public void onPostUpdate(){


        CoffeeThrew coffeeThrew = new CoffeeThrew();
        BeanUtils.copyProperties(this, coffeeThrew);
        coffeeThrew.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }
    public String getMakeStatus() {
        return makeStatus;
    }

    public void setMakeStatus(String makeStatus) {
        this.makeStatus = makeStatus;
    }




}
