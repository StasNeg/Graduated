package controller;

import controller.to.TripTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.TripRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TripController {

    @Autowired
    private TripRepository repository;

    @GetMapping(PathConstants.GET_TRIPS)
    public List<TripTo> getAll() {
        return repository.getAll().stream().map(TripTo::fromTrip).collect(Collectors.toList());
    }



}
