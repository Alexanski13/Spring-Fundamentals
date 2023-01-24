package com.softuni.pathfinder.web;

import com.softuni.pathfinder.domain.dto.MostCommentedRouteViewDto;
import com.softuni.pathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {
    private final RouteService routeService;

    @Autowired
    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping // localhost:8080 -> get request
    public ModelAndView getHome(ModelAndView modelAndView) {
        final MostCommentedRouteViewDto mostCommented = routeService.getMostCommented();

        modelAndView.addObject("mostCommented", mostCommented);

        return super.view("index", modelAndView);
    }
}
