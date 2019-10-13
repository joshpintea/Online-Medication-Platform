package assignment1.controller;

import assignment1.dto.UserDto;
import assignment1.exception.NotLoggedUser;
import assignment1.service.user.UserService;
import assignment1.util.EndpointsUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = EndpointsUtil.USER)
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = EndpointsUtil.LOGGED_USER)
    public UserDto getLoggedUser() throws NotLoggedUser {
        return this.userService.getLoggedUser();
    }
}
