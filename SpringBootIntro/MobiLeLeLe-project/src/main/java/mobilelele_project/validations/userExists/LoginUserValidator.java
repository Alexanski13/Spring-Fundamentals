package mobilelele_project.validations.userExists;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import mobilelele_project.domain.dtos.banding.UserLoginFormDto;
import mobilelele_project.domain.entities.User;
import mobilelele_project.repositories.UserRepository;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public record LoginUserValidator(UserRepository userRepository,
                                 ModelMapper modelMapper)
        implements ConstraintValidator<ValidateLoginUser, UserLoginFormDto> {

    @Override
    public void initialize(ValidateLoginUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginFormDto userLogin, ConstraintValidatorContext constraintValidatorContext) {
        Optional<User> loginCandidate = this.userRepository.findByUsername(userLogin.getUsername());

        return loginCandidate.isPresent()
                && loginCandidate.get()
                .getPassword()
                .equals(userLogin.getPassword());
    }
}