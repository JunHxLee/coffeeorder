package coffeeorder;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String coffeeName;
    private String orderStatus;

    @PrePersist
    public void onPrePersist(){
        this.setOrderStatus("Coffee Ordered");
    }

    @PostPersist
    public void onPostPersist(){
        CoffeeOrdered coffeeOrdered = new CoffeeOrdered();
        BeanUtils.copyProperties(this, coffeeOrdered);
        coffeeOrdered.publishAfterCommit();


    }


    @PostUpdate
    public void onPostUpdate(){
        CoffeeSoldOut coffeeSoldOut = new CoffeeSoldOut();
        BeanUtils.copyProperties(this, coffeeSoldOut);
        coffeeSoldOut.publishAfterCommit();


    }

    @PreRemove
    public void onPreRemove(){
        
        // CoffeeCanceled coffeeCanceled = new CoffeeCanceled();
        // BeanUtils.copyProperties(this, coffeeCanceled);
        // coffeeCanceled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        coffeeorder.external.Coffee coffee = new coffeeorder.external.Coffee();
        // mappings goes here
        coffee.setOrderId(this.getId());
        OrderApplication.applicationContext.getBean(coffeeorder.external.CoffeeService.class)
            .throwCoffee(coffee);
        
            
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }




}
