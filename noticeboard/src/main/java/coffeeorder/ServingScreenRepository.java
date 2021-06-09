package coffeeorder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServingScreenRepository extends CrudRepository<ServingScreen, Long> {

    List<ServingScreen> findByOrderId(Long orderId);

}