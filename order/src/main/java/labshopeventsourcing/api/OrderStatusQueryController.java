package labshopeventsourcing.api;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import labshopeventsourcing.query.*;

@RestController
public class OrderStatusQueryController {

  private final QueryGateway queryGateway;

  public OrderStatusQueryController(QueryGateway queryGateway) {
      this.queryGateway = queryGateway;
  }
  

  @GetMapping("/orderStatuses")
  public CompletableFuture<List<OrderStatus>> findAll() {
      return queryGateway.query(new OrderStatusQuery(), ResponseTypes.multipleInstancesOf(OrderStatus.class));
  }

}

