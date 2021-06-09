package coffeeorder.external;

public class Coffee {

    private Long id;
    private Long orderId;
    private String coffeeName;
    private String makeStatus;

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
