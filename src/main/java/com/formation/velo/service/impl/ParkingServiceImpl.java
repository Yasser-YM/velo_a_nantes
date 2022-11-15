package com.formation.velo.service.impl;
import com.formation.velo.api.parking.OpenDataParkingClient;
import com.formation.velo.api.parking.OpenDataParking;
import com.formation.velo.model.Parking;
import com.formation.velo.repository.ParkingRepository;
import com.formation.velo.service.ParkingService;
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
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingServiceImpl(ParkingRepository parkingRepository){
        this.parkingRepository = parkingRepository;
    }

    @Override
    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    @Override
    public Optional<Parking> findById(Integer id) {
        return parkingRepository.findById(id);
    }

    @Override
    public Parking save(Parking parking) {
        return parkingRepository.save(parking);
    }

    @Override
    public void saveRecord() {
        String baseUrl = "https://data.nantesmetropole.fr/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenDataParkingClient client = retrofit.create(OpenDataParkingClient.class);
        Call<OpenDataParking> openDataParkingCall = client.getRecords();
        try {
            OpenDataParking openDataParking = openDataParkingCall.execute().body();
            log.info(openDataParking.toString());
            Arrays.stream(openDataParking.getRecords()).forEach(record -> {
                Optional<Parking> parkingToUpdate = findBygrpIdentifiant(record.getFields().getGrpIdentifiant());
                if(parkingToUpdate.isPresent()){
                    parkingToUpdate.get().setGrpDisponible(record.getFields().getGrpDisponible());
                    parkingToUpdate.get().setGrpStatut(record.getFields().getGrpStatut());
                    parkingToUpdate.get().setDisponibilite(record.getFields().getDisponibilite());
                    parkingToUpdate.get().setGrpComplet(record.getFields().getGrpComplet());
                    parkingToUpdate.get().setIdobj(record.getFields().getIdobj());
                    parkingToUpdate.get().setGrpExploitation(record.getFields().getGrpExploitation());
                    save(parkingToUpdate.get());
                }else{

                        Parking newParking =
                                Parking.builder()
                                        .recordId(record.getRecordId())
                                        .grpNom(record.getFields().getGrpNom())
                                        .grpDisponible(record.getFields().getGrpDisponible())
                                        .disponibilite(record.getFields().getDisponibilite())
                                        .grpExploitation(record.getFields().getGrpExploitation())
                                        .idobj(record.getFields().getIdobj())
                                        .grpIdentifiant(record.getFields().getGrpIdentifiant())
                                        .grpComplet(record.getFields().getGrpComplet())
                                        .grpStatut(record.getFields().getGrpStatut())
                                        .build();
                                        if ( record.getFields().getLocation() !=null) {
                                        newParking.setLatitude(record.getFields().getLocation()[0]);
                                        newParking.setLongitude(record.getFields().getLocation()[1]);
                                        save(newParking);
                                        } else {
                                            newParking.setLatitude(0.0);
                                            newParking.setLongitude(0.0);
                                            save(newParking);



                                        }




                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Optional<Parking> findBygrpIdentifiant(String grpIdentifiant) {
        return parkingRepository.findBygrpIdentifiant(grpIdentifiant);
    }

    @Override
    public void deleteById(Integer id) {
        parkingRepository.deleteById(id);

    }

    @Override
    public void delete(Parking parking) {
        parkingRepository.delete(parking);
    }
    @Override
    public void deleteAll(Parking parking){
        parkingRepository.deleteAll();
    }
}
