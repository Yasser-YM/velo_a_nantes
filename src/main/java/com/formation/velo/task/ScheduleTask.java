package com.formation.velo.task;

import com.formation.velo.service.PumpService;
import com.formation.velo.service.StationService;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log
public class ScheduleTask {

    private final StationService stationService;
    private final PumpService pumpService;

    public ScheduleTask(StationService stationService, PumpService pumpService){
        this.stationService = stationService;
        this.pumpService = pumpService;
    }
    @Scheduled(fixedRate = 60000)
    public void searchNextMatchByCompetition(){
        log.info("✔️ update stations");
        stationService.saveRecords();
        log.info("✔️ update pumps");
        pumpService.saveRecords();
    }

}
