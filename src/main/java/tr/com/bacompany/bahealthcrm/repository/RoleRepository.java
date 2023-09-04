package tr.com.bacompany.bahealthcrm.repository;

import tr.com.bacompany.bahealthcrm.data.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {}
