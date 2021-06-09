package coffeeorder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ServingScreen_table")
public class ServingScreen {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long orderId;
        private String coffeeName;
        private String status;


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
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

}
