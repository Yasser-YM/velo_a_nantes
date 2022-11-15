package com.formation.velo.service.impl;

import com.formation.velo.api.OpenDataNantesClient;
import com.formation.velo.api.OpenData;
import com.formation.velo.model.Station;
import com.formation.velo.repository.StationRepository;
import com.formation.velo.service.StationService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
@Log
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public List<Station> findAll() {
        return  stationRepository.findAll();
    }

    @Override
    public Optional<Station> findById(Integer id) {
        return  stationRepository.findById(id);
    }

    @Override
    public Station save(Station station) {
        return  stationRepository.save(station);
    }

    @Override
    public void deleteById(Integer id) {
        stationRepository.deleteById(id);

    }

    @Override
    public void delete(Station station) {
        stationRepository.delete(station);

    }

    @Override
    public void saveRecords() {
        String baseUrl = "https://data.nantesmetropole.fr/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenDataNantesClient client = retrofit.create(OpenDataNantesClient.class);
        Call<OpenData> openDataVeloNantesCall = client.getRecords();
        try {
            OpenData openData = openDataVeloNantesCall.execute().body();
            log.info(openData.toString());
            Arrays.stream(openData.getRecords()).forEach(record -> {
                Optional<Station> stationToUpdate =findByRecordId(record.getRecordId());
                if(stationToUpdate.isPresent()){

                    stationToUpdate.get().setAvailabeBikes(record.getFields().getAvailableBikes());
                    stationToUpdate.get().setAvailabeBikesStands(record.getFields().getAvailableBikeStands());
                    stationToUpdate.get().setBikeStands(record.getFields().getBikeStands());
                    stationToUpdate.get().setStatus(record.getFields().getStatus());
                    stationToUpdate.get().setAddress(record.getFields().getAddress());


                    save(stationToUpdate.get());
                }else{
                    Station newStation = Station.builder()
                            .recordId(record.getRecordId())
                            .name(record.getFields().getName())
                            .availabeBikes(record.getFields().getAvailableBikes())
                            .bikeStands(record.getFields().getBikeStands())
                            .availabeBikesStands(record.getFields().getAvailableBikeStands())
                            .latitude(record.getFields().getPosition()[0])
                            .longitude(record.getFields().getPosition()[1])
                            .status(record.getFields().getStatus())
                            .address(record.getFields().getAddress())
                            .build();

                    save(newStation);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Station> findByRecordId(String recordId) {
        return stationRepository.findByRecordId(recordId);
    }
}
