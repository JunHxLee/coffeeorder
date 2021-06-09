package coffeeorder.external;

public class Bean {

    private Long id;
    private String coffeeName;
    private Long qty;

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
