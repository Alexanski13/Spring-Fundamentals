package mobilelele_project.services.user;


import mobilelele_project.domain.dtos.banding.UserLoginFormDto;
import mobilelele_project.domain.dtos.banding.UserRegisterFormDto;
import mobilelele_project.domain.dtos.model.UserModel;

public interface UserService {
    UserModel registerUser(UserRegisterFormDto userRegister);

    void loginUser(UserLoginFormDto userLogin);

    void logout();
}