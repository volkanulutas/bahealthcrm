package tr.com.bacompany.bahealthcrm.repository;

import tr.com.bacompany.bahealthcrm.data.entity.work.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Long> {}
