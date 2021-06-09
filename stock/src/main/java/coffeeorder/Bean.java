package coffeeorder;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Bean_table")
public class Bean {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String coffeeName;
    private Long qty;

    @PostPersist
    public void onPostPersist(){
        BeanRegistered beanRegistered = new BeanRegistered();
        BeanUtils.copyProperties(this, beanRegistered);
        beanRegistered.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        BeanModified beanModified = new BeanModified();
        BeanUtils.copyProperties(this, beanModified);
        beanModified.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

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
    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }




}
