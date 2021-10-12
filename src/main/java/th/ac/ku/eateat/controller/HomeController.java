package th.ac.ku.eateat.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getHome(Model model, @AuthenticationPrincipal OAuth2User principal){
        model.addAttribute("greeting","Welcome To Eat-Ate");
        if (principal != null)
            model.addAttribute("user", principal.getAttribute("name"));
        else
            model.addAttribute("user", "Guest");

        return  "home";  // return home.html
    }
}
