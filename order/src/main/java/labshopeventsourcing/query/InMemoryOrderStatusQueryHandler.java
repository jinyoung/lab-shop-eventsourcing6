package labshopeventsourcing.query;


import labshopeventsourcing.event.*;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@Service  // Enable (uncomment here) this component and disable the JPAQueryHandler if you want to use In-memory version
@ProcessingGroup("orderStatus")
public class InMemoryOrderStatusQueryHandler {

    private final Map<Long, OrderStatus> data = new HashMap<>();

    @QueryHandler
    public List<OrderStatus> handle(OrderStatusQuery query) {
        return new ArrayList<>(data.values());
    }

    @EventHandler
    public void on(OrderPlacedEvent orderPlaced) {

    OrderStatus orderStatus = new OrderStatus();

        orderStatus.setId(orderPlaced.getId());
        orderStatus.setStatus(orderPlaced.getStatus());
        orderStatus.setAmount(Long.valueOf(orderPlaced.getAmount()));
        orderStatus.setQty(orderPlaced.getQty());

        data.put(orderStatus.getId(), orderStatus);
    }


    @EventHandler
    public void on(OrderDeliveryStartedEvent orderDeliveryStarted) {
        OrderStatus orderStatus = data.getOrDefault(orderDeliveryStarted.getId(), null);

        if( orderStatus != null) {
                
            orderStatus.setStatus("DeliveryStarted");    
            data.put(orderStatus.getId(), orderStatus);
        }


    }
    @EventHandler
    public void on(OrderCancelledEvent orderCancelled) {
        OrderStatus orderStatus = data.getOrDefault(orderCancelled.getId(), null);

        if( orderStatus != null) {
                
            orderStatus.setStatus("Cancelled");    
            data.put(orderStatus.getId(), orderStatus);
        }


    }

}

