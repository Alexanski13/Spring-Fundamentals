package mobilelele_project.services.user;

import mobilelele_project.domain.beans.LoggedUser;
import mobilelele_project.domain.dtos.banding.UserLoginFormDto;
import mobilelele_project.domain.dtos.banding.UserRegisterFormDto;
import mobilelele_project.domain.dtos.model.UserModel;
import mobilelele_project.domain.entities.User;
import mobilelele_project.repositories.UserRepository;
import mobilelele_project.services.init.DatabaseInitService;
import mobilelele_project.services.role.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, DatabaseInitService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInit() {
        return this.userRepository.count() > 0;
    }

    @Override
    public UserModel registerUser(UserRegisterFormDto userRegister) {
        final UserModel userModel = this.modelMapper.map(userRegister, UserModel.class);

        userModel.setRole(this.userRepository.count() == 0
                ? this.userRoleService.findAllRoles()
                : List.of(this.userRoleService.findRoleByName("USER")));

        final User userToSave = this.modelMapper.map(userModel, User.class);

        return this.modelMapper.map(this.userRepository.saveAndFlush(userToSave), UserModel.class);
    }

    @Override
    public void loginUser(UserLoginFormDto userLogin) {
        UserModel loginCandidate =
                this.modelMapper.map(this.userRepository.findByUsername(userLogin.getUsername()).get(),
                        UserModel.class);

        this.loggedUser
                .setId(loginCandidate.getId())
                .setUsername(loginCandidate.getUsername())
                .setRoleModels(loginCandidate.getRole());
    }

    @Override
    public void logout() {
        this.loggedUser.clearFields();
    }
}