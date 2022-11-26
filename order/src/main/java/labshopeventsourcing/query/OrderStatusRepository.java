package labshopeventsourcing.query;

import org.springframework.data.repository.JpaRepository;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="orderStatuses", path="orderStatuses")
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

    

    
}
