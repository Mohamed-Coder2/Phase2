package Controllers;

import Project.OrderStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class StatusController {

    // Mock data for demonstration purposes
    private static final Map<String, OrderStatus> orderStatusMap = new HashMap<>();

    static {
        orderStatusMap.put("23412", OrderStatus.PENDING);
        orderStatusMap.put("12342", OrderStatus.SHIPPED);
        orderStatusMap.put("234123", OrderStatus.CANCELED);
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, String>> getOrderStatus() {
        Map<String, String> statusResponse = new HashMap<>();

        for (Map.Entry<String, OrderStatus> entry : orderStatusMap.entrySet()) {
            String orderId = entry.getKey();
            OrderStatus orderStatus = entry.getValue();
            statusResponse.put(orderId, orderStatus.toString());
        }

        return new ResponseEntity<>(statusResponse, HttpStatus.OK);
    }
}
