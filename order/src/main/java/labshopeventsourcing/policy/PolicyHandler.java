package labshopeventsourcing.policy;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.eventhandling.DisallowReplay;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.axonframework.commandhandling.gateway.CommandGateway;

import labshopeventsourcing.command.*;
import labshopeventsourcing.event.*;
import labshopeventsourcing.aggregate.*;


@Service
@ProcessingGroup("order")
public class PolicyHandler{

    @Autowired
    CommandGateway commandGateway;

    @EventHandler
    //@DisallowReplay
    public void wheneverDeliveryStarted_UpdateStatus(DeliveryStartedEvent deliveryStarted){
        System.out.println(deliveryStarted.toString());

        UpdateStatusCommand command = new UpdateStatusCommand();
        commandGateway.send(command);
    }

}
