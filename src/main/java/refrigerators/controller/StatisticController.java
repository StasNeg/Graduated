package refrigerators.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import refrigerators.controller.to.FrontPostTo;
import refrigerators.repository.AverageTempRepository;
import refrigerators.repository.TripRepository;
import refrigerators.repository.WarnTempRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)

public class StatisticController {
    @Autowired
    private AverageTempRepository averRepository;
    @Autowired
    private WarnTempRepository warnRepository;


    @PostMapping(path = PathConstants.GET_ALL_WARNINGS_BY_IDTRIP_AND_DATE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo getWarningsByDateBetwwen(@RequestBody(required = false) Map<String, Object> filter) {
        int count = filter.get("n") != null ? Integer.parseInt((String) filter.get("n")) : 0;
        LocalDateTime start = (filter.get("date_from") != null) ? parseDate((String) filter.get("date_from")).atStartOfDay() : null;
        LocalDateTime end = (filter.get("date_to") != null) ? parseDate((String) filter.get("date_to")).atStartOfDay() : null;
        return new FrontPostTo(true, warnRepository.getByCountWarningBetween(count, start, end));
    }


    @PostMapping(path = PathConstants.GET_ALL_AVERAGE_LIST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FrontPostTo getAverageBetween(@RequestBody(required = false) Map<String, Object> filter) {
        System.out.println(filter);
        LocalDateTime start = (filter.get("date_from") != null) ? parseDate((String) filter.get("date_from")).atStartOfDay() : null;
        LocalDateTime end = (filter.get("date_to") != null) ? parseDate((String) filter.get("date_to")).atStartOfDay() : null;
        return new FrontPostTo(true, averRepository.getByCountWarningBetween(start, end));
    }


    private LocalDate parseDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
