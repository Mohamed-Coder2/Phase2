package events;

import org.springframework.context.ApplicationEvent;

public class OrderEvent extends ApplicationEvent {
    private final String OrderID;
    public OrderEvent(Object source, String OrderID) {
        super(source);
        this.OrderID = OrderID;
    }
    public String getOrderID(){
        return OrderID;
    }
}
