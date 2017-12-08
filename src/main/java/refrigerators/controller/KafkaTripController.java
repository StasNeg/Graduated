package refrigerators.controller;

import refrigerators.controller.json.JsonUtil;
import refrigerators.controller.to.TempTo;
import refrigerators.controller.to.TripTo;
import refrigerators.controller.to.WarnTo;
import refrigerators.model.AverageTemperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import refrigerators.model.Trip;
import refrigerators.model.WarningTemperature;
import refrigerators.repository.AverageTempRepository;
import refrigerators.repository.TripRepository;
import refrigerators.repository.WarnTempRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class KafkaTripController {

    @Autowired
    private TripRepository repository;
    @Autowired
    private AverageTempRepository averageRepository;
    @Autowired
    private WarnTempRepository warnTempRepository;

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

    @PostMapping(path = PathConstants.POST_WARNING_EXCEED, consumes = MediaType.ALL_VALUE)
    public String postWarnExceedTemperatures(@RequestBody String warn) {
        WarnTo warnTo = JsonUtil.readValue(warn, WarnTo.class);
        Trip trip = repository.get(warnTo.getId());
        warnTempRepository.save(new WarningTemperature(trip,warnTo.getTemperature(),
                Integer.MIN_VALUE,getTripDate(warnTo.getTimeStamp())));
        return "exceed";
    }

    @PostMapping(path = PathConstants.POST_WARNING_LOWER, consumes = MediaType.ALL_VALUE)
    public String postWarnLowerTemperatures(@RequestBody String warn) {
        WarnTo warnTo = JsonUtil.readValue(warn, WarnTo.class);
        Trip trip = repository.get(warnTo.getId());
        warnTempRepository.save(new WarningTemperature(trip,Integer.MIN_VALUE,warnTo.getTemperature(),
                getTripDate(warnTo.getTimeStamp())));
        return "lower";
    }



    private List<AverageTemperature> toAverageTemperature(List<TempTo> to){
        return to.stream().map(x->new AverageTemperature(
                repository.get(x.getIdTrip()), x.getAvgTemp(), getTripDate(x.getTimeStamp()))).collect(Collectors.toList());
    }

    private LocalDateTime getTripDate(Long timeStamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timeStamp), ZoneId.systemDefault());
    }

}
