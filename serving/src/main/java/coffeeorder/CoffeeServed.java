package coffeeorder;

public class CoffeeServed extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String coffeeName;
    private String servingStatus;

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