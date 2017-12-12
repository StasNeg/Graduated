package refrigerators.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import refrigerators.controller.to.FrontPostTo;
import refrigerators.repository.TripRepository;

import java.util.Map;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)

public class TripController {
    @Autowired
    private TripRepository repository;

    @GetMapping(path = PathConstants.GET_TRIP_ALL, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo getAll() {
        return new FrontPostTo(true, repository.getAll());
    }

    @PostMapping(path = PathConstants.POST_TRIP_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo save(@RequestBody(required = false) Map<String,Object> trip) {
        repository.save(Integer.parseInt((String) trip.get("product")), Integer.parseInt((String) trip.get("truck")));
        return new FrontPostTo(true, repository.getAll());
    }

//    @PostMapping(path = PathConstants.POST_TRIP_GET_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public FrontPostTo getById(@RequestBody(required = false) Map<String,Object> ss) {
//        int id = (int)ss.get("id");
//        return new FrontPostTo(true, repository.get(id));
//    }
//    @PostMapping(path = PathConstants.POST_TRIP_DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public FrontPostTo delete(@RequestBody(required = false) Map<String,Object> ss) {
//
//        int id = (int)ss.get("id");
//        repository.delete(id);
//        return new FrontPostTo(true, null);
//    }
}
