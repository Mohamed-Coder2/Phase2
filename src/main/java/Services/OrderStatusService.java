package Services;

import Project.OrderStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderStatusService {
    private final Map<String, OrderStatus> orderStatusMap = new HashMap<>();

    public void updateOrderStatus(String orderID, OrderStatus status) {
        orderStatusMap.put(orderID, status);
    }

    public Map<String, String> getAllOrderStatus() {
        Map<String, String> statusMap = new HashMap<>();
        for (Map.Entry<String, OrderStatus> entry : orderStatusMap.entrySet()) {
            statusMap.put(entry.getKey(), entry.getValue().toString());
        }
        return statusMap;
    }

    public ArrayList<String> getPendingOrders() {
        ArrayList<String> pendingOrders = new ArrayList<>();

        for (Map.Entry<String, OrderStatus> entry : orderStatusMap.entrySet()) {

            if (entry.getValue() == OrderStatus.PENDING) {
                pendingOrders.add(entry.getKey());
            }
        }
        return pendingOrders;
    }


    public OrderStatus getOrderStatus(String key){
        return orderStatusMap.get(key);
    }
}
