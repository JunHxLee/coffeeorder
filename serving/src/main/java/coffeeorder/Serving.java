package coffeeorder;

import javax.persistence.*;

import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Serving_table")
public class Serving {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String coffeeName;
    private String servingStatus;

    @PostPersist
    public void onPostPersist(){
        CoffeeServed coffeeServed = new CoffeeServed();
        BeanUtils.copyProperties(this, coffeeServed);
        this.setOrderId(coffeeServed.getOrderId());
        this.setCoffeeName(coffeeServed.getCoffeeName());
        this.setServingStatus("Coffee Served");
        coffeeServed.publishAfterCommit();


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
    public String getServingStatus() {
        return servingStatus;
    }

    public void setServingStatus(String servingStatus) {
        this.servingStatus = servingStatus;
    }




}
