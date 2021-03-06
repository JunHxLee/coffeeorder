package coffeeorder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="orders", path="orders")
//public interface OrderRepository extends PagingAndSortingRepository<Order, Long>{
public interface OrderRepository extends CrudRepository<Order, Long>{    


}
