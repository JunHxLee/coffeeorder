package coffeeorder;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="servings", path="servings")
public interface ServingRepository extends PagingAndSortingRepository<Serving, Long>{


}
