package labshopeventsourcing.query;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import labshopeventsourcing.command.*;
import labshopeventsourcing.event.*;
import labshopeventsourcing.aggregate.*;

@Service
@ProcessingGroup("delivery_Policy")
public class PolicyHandler{

    @EventHandler
    public void wheneverOrderPlaced_(OrderPlacedEvent orderPlaced){
        System.out.println(orderPlaced.toString());
    }
    @EventHandler
    public void wheneverOrderCancelled_(OrderCancelledEvent orderCancelled){
        System.out.println(orderCancelled.toString());
    }

}
