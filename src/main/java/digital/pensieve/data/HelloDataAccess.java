package digital.pensieve.data;

import digital.pensieve.model.RecordData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloDataAccess extends JpaRepository<RecordData, Integer> {
}
