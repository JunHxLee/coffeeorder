package coffeeorder;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="beans", path="beans")
public interface BeanRepository extends PagingAndSortingRepository<Bean, Long>{


    List<Bean> findByCoffeeName(String coffeeName);

}
