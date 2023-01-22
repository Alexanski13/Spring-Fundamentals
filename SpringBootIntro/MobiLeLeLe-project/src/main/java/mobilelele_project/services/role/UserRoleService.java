package mobilelele_project.services.role;

import mobilelele_project.domain.dtos.view.UserRoleViewDto;
import mobilelele_project.services.init.DatabaseInitService;

import java.util.List;

public interface UserRoleService extends DatabaseInitService {
    List<UserRoleViewDto> getAll();
}