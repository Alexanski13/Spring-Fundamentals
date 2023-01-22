package mobilelele_project.domain.dtos.view;

import mobilelele_project.domain.enums.Role;

public class UserRoleViewDto {

    private Role role;

    public Role getRole() {
        return role;
    }

    public UserRoleViewDto setRole(Role role) {
        this.role = role;
        return this;
    }
}
