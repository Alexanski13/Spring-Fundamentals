package mobilelele_project.repositories;

import mobilelele_project.domain.entities.UserRole;
import mobilelele_project.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, String> {
    Optional<UserRole> findByRole(Role role);
}
