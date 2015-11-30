package kz.epam.quiz.controller;

import kz.epam.quiz.controller.dto.RegistrationDTO;
import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.model.service.db.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserRegistrationController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        model.put("registrationDTO", new RegistrationDTO());
        return "userRegistration";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String doRegistration(@Valid @ModelAttribute("registrationDTO") RegistrationDTO registrationDTO, BindingResult result, Map<String, Object> map) {
        if(!result.hasErrors()) {
            User user = new User();
            try {
                BeanUtils.copyProperties(user, registrationDTO);

                System.out.println(user.getEmail() + " : " + user.getPassword());
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return "userRegistration";
    }
}
