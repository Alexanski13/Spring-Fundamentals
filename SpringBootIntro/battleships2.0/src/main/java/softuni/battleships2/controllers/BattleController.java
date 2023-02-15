package softuni.battleships2.controllers;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.battleships2.models.dtos.StartBattleDTO;
import softuni.battleships2.services.AuthService;
import softuni.battleships2.services.BattleService;

public class BattleController {
    private final BattleService battleService;
    private final AuthService authService;

    public BattleController(BattleService battleService, AuthService authService) {
        this.battleService = battleService;
        this.authService = authService;
    }

    @PostMapping("/battle")
    public String battle(@Valid StartBattleDTO startBattleDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (!this.authService.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("startBattleDTO", startBattleDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.startBattleDTO", bindingResult);

            return "redirect:/home";
        }

        this.battleService.attack(startBattleDTO);

        return "redirect:/home";
    }
}
