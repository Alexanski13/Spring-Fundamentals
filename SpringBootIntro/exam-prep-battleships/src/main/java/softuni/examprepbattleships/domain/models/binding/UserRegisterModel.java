package softuni.examprepbattleships.domain.models.binding;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.examprepbattleships.validations.passwordMatcher.PasswordMatch;

@Setter
@Getter
@NoArgsConstructor
@PasswordMatch
public class UserRegisterModel {

    @Size(min = 3, max = 10)
    @NotNull
    private String username;

    @Size(min = 5, max = 20)
    @NotNull
    private String fullName;

    @Size(min = 3)
    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @Email
    @NotNull
    private String email;
}
