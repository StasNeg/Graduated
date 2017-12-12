package refrigerators.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import refrigerators.AuthorizedUser;
import refrigerators.controller.to.FrontPostTo;

import java.util.Map;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)

public class UserController {

    @PostMapping(path = PathConstants.POST_AUTH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo postWarnExceedTemperatures(@RequestBody(required = false) Map<String, Object> ss) {
        System.out.println("a m here");
        return new FrontPostTo(true, AuthorizedUser.get().getUserTo());
    }

//    @PostMapping(path = PathConstants.POST_AUTH_TEST, headers = {"content-type=application/x-www-form-urlencoded"}, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Map Test(@RequestBody Map<String, Object> ss) {
//        System.out.println("a m here");
//        return ss;
//    }
}
