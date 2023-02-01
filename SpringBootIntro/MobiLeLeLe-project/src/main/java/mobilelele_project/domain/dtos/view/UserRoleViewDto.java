package mobilelele_project.domain.dtos.view;

import mobilelele_project.domain.enums.Role;

public class UserRoleViewDto {
    private String role;

    public String getRole() {
        return role;
    }

    public UserRoleViewDto setRole(String role) {
        this.role = role;
        return this;
    }
}
