package labshopeventsourcing.api;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;


import labshopeventsourcing.aggregate.*;
import labshopeventsourcing.command.*;

@RestController
public class OrderController {

  private final CommandGateway commandGateway;
  private final QueryGateway queryGateway;

  public OrderController(CommandGateway commandGateway, QueryGateway queryGateway) {
      this.commandGateway = commandGateway;
      this.queryGateway = queryGateway;
  }

  @RequestMapping(value = "/orders",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8")
  public CompletableFuture order(@RequestBody OrderCommand orderCommand)
        throws Exception {
      System.out.println("##### /order/order  called #####");

      // send command
      return commandGateway.send(orderCommand);
  }


  @RequestMapping(value = "/orders",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8")
  public CompletableFuture cancel(@RequestBody CancelCommand cancelCommand)
        throws Exception {
      System.out.println("##### /order/cancel  called #####");

      // send command
      return commandGateway.send(cancelCommand);
  }



  @RequestMapping(value = "/updatestatus",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
  public CompletableFuture updateStatus(@RequestBody UpdateStatusCommand updateStatusCommand)
        throws Exception {
      System.out.println("##### /order/updateStatus  called #####");

      // send command
      return commandGateway.send(updateStatusCommand);
  }
}
