package refrigerators.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import refrigerators.controller.to.FrontPostTo;
import refrigerators.controller.to.TruckTo;
import refrigerators.model.Truck;
import refrigerators.repository.TruckRepository;

import java.util.Map;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TruckController {
    @Autowired
    private TruckRepository repository;

    @GetMapping(path = PathConstants.GET_TRUCK_ALL, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo getAll() {
        return new FrontPostTo(true, repository.getAll());
    }

    @PostMapping(path = PathConstants.POST_TRUCK_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo save(@RequestBody(required = false) TruckTo truck) {

        repository.save(new Truck(truck.getId() == 0 ? null : truck.getId(), truck.getName()));
        return new FrontPostTo(true, null);
    }

    @PostMapping(path = PathConstants.POST_TRUCK_GET_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo getById(@RequestBody(required = false) Map<String,Object> ss) {

        int id = (int)ss.get("id");
        return new FrontPostTo(true, repository.get(id));
    }
    @PostMapping(path = PathConstants.POST_TRUCK_DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo delete(@RequestBody(required = false) Map<String,Object> ss) {
        int id = (int)ss.get("id");
        repository.delete(id);
        return new FrontPostTo(true, null);
    }
}
