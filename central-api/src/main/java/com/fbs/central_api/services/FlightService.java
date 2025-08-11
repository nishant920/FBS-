package com.fbs.central_api.services;

import com.fbs.central_api.connectors.DBApiConnector;
import com.fbs.central_api.dto.FlightDetailsDto;
import com.fbs.central_api.dto.SubFlightDto;
import com.fbs.central_api.models.Flight;
import com.fbs.central_api.models.SubFlight;
import com.fbs.central_api.utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FlightService{

    Mapper mapper;
    DBApiConnector dbApiConnector;
    @Autowired
    public FlightService(Mapper mapper, DBApiConnector dbApiConnector ){
        this.mapper=mapper;
        this.dbApiConnector=dbApiConnector;
    }
    public void createSubFlight(List<SubFlightDto> subFlightDtos, Flight flight){
        for(SubFlightDto subFlightDto : subFlightDtos){
            // We need to map subFlightDto one by one to SubFlightModel
            SubFlight subFlight = mapper.mapSubFlightDtoToSubFlightModel(subFlightDto, flight);
            // db Api connector to save subFlight into the database.
            dbApiConnector.callCreateSubFlightEndpoint(subFlight);
        }
    }
    public Flight createFlight(FlightDetailsDto flightDetailsDto,
                               String authorization){


    }
}
