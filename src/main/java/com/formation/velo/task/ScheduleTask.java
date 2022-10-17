package com.formation.velo.task;

import com.formation.velo.service.StationService;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log
public class ScheduleTask {
    private final StationService stationService;

    public ScheduleTask(StationService stationService) {
        this.stationService = stationService;
    }
    @Scheduled(fixedRate = 60000) //1 min
    public void searchNextMatchByCompetition(){
        log.info("update stations");
        stationService.saveRecords();
    }
}
