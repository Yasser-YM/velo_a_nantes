package com.formation.velo.task;

import com.formation.velo.service.ParkingService;
import com.formation.velo.service.StationService;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log
public class ScheduleTask {

    private final StationService stationService;
    private final ParkingService parkingService;


    public ScheduleTask(StationService stationService, ParkingService parkingService){
        this.stationService = stationService;
        this.parkingService = parkingService;

    }
    @Scheduled(fixedRate = 60000)
    public void searchNextMatchByCompetition(){
        log.info("✔️ update stations");
        stationService.saveRecords();
        log.info("✔️ update parkings");
        parkingService.saveRecord();

    }

}
