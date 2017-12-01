package controller;

import controller.json.JsonUtil;
import controller.to.TempTo;
import controller.to.TripTo;
import model.AverageTemperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import repository.AverageTempRepository;
import repository.TripRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TripController {

    @Autowired
    private TripRepository repository;

    @Autowired
    private AverageTempRepository averageRepository;

    @GetMapping(PathConstants.GET_TRIPS)
    public List<TripTo> getAll() {
        return repository.getAll().stream().map(TripTo::fromTrip).collect(Collectors.toList());
    }

    @PostMapping(path=PathConstants.POST_AVER, consumes=MediaType.ALL_VALUE)
    public String postAverageTemperatures(@RequestBody String averages) {
        List<TempTo> averagesList = JsonUtil.readValues(averages, TempTo.class);
        toAverageTemperature(averagesList).forEach(trip->averageRepository.save(trip));
        return "averagesList";
    }

    private List<AverageTemperature> toAverageTemperature(List<TempTo> to){
        return to.stream().map(x->new AverageTemperature(
                repository.get(x.getIdTrip()), x.getAvgTemp(),  LocalDateTime.ofInstant(Instant.ofEpochMilli(x.getTimeStamp()), ZoneId.systemDefault()))).collect(Collectors.toList());
    }
}
