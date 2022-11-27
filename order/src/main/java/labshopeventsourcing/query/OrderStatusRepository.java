package labshopeventsourcing.query;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "orders", collectionResourceRel = "orders")
public interface OrderStatusRepository
    extends JpaRepository<OrderStatus, Long> {

    @Override
    @RestResource(exported = false)
    default void delete(OrderStatus entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    @RestResource(exported = false)
    default void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    @RestResource(exported = false)
    default void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    @RestResource(exported = false)
     <S extends OrderStatus> S save(S entity);

}

