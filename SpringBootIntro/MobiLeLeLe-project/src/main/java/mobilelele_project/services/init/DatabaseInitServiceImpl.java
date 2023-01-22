package mobilelele_project.services.init;

import jakarta.annotation.PostConstruct;
import mobilelele_project.services.role.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseInitServiceImpl implements DatabaseInitService {

    private final UserRoleService roleService;

    @Autowired
    public DatabaseInitServiceImpl(UserRoleService roleService) {
        this.roleService = roleService;
    }

    @PostConstruct
    public void postConstruct() {
        dbInit();
    }

    @Override
    public void dbInit() {
        if (isDbInit()) {
            this.roleService.dbInit();
        }
    }

    @Override
    public boolean isDbInit() {
        return this.roleService.isDbInit();
    }
}
