package refrigerators.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @PostMapping(path = PathConstants.POST_AUTH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postWarnExceedTemperatures(@RequestBody Map<String, Object> ss) {
        System.out.println("a m here");
        return new String("exceed");
    }

    @PostMapping(path = PathConstants.POST_AUTH_TEST, headers = {"content-type=application/x-www-form-urlencoded"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map Test(@RequestBody Map<String, Object> ss) {
        System.out.println("a m here");
        return ss;
    }
}
