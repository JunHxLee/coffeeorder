package coffeeorder;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="coffees", path="coffees")
public interface CoffeeRepository extends PagingAndSortingRepository<Coffee, Long>{

    List<Coffee> findByOrderId(Long orderId);

}
