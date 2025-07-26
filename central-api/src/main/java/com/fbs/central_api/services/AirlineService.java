package com.fbs.central_api.services;

import com.fbs.central_api.connectors.DBApiConnector;
import com.fbs.central_api.dto.AirlineRegistrationDto;
import com.fbs.central_api.enums.AirlineStatus;
import com.fbs.central_api.enums.UserStatus;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;
import com.fbs.central_api.utility.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class AirlineService {
      Mapper mapper;
      DBApiConnector dbApiConnector;
      UserService userService;
      MailService mailService;
      public AirlineService(Mapper mapper, DBApiConnector dbApiConnector, UserService userService, MailService mailService){
          this.mapper=mapper;
          this.dbApiConnector=dbApiConnector;
          this.userService=userService;
          this.mailService=mailService;
      }

    public Airline getAirlineById(UUID airlineId){
        // so, to get the airline by id we need to call database api
        // so, to call database api we require database api connector.
        return dbApiConnector.callGetAirlineByIdEndpoint(airlineId);
    }

    public Airline registerAirline(AirlineRegistrationDto airlineRegistrationDto){
        log.info("airlineService registerAirline method called: " + airlineRegistrationDto.toString());

        AppUser airlineAdmin = mapper.mapAirlineDetailsToAppUser(airlineRegistrationDto);

        airlineAdmin = dbApiConnector.callCreateUserEndpoint(airlineAdmin);

        Airline airline = mapper.mapAirlineDetailsToAirlineObject(airlineRegistrationDto, airlineAdmin);

         airline = dbApiConnector.callCreateAirlineEndpoint(airline);

        List<AppUser> systemAdminList = userService.getAllSystemAdmins();

        mailService.mailSystemAdminForAirlineRegistration(systemAdminList, airline);

         return airline;
    }

    public Airline acceptAirline(UUID airlineId){
        // 1. to get the airline object on the basis of Id.
        // 2. Update the status of airline as well status of airline Admin.
        // 3. Save those changes into their respective tables in the database.
        // 4. We need to mail airline admin that congratulations your request got approved.
        log.info("airlineId " + airlineId);
        Airline airline = getAirlineById(airlineId);
        airline.setStatus(AirlineStatus.ACTIVE.toString());
        airline.setUpdatedAt(LocalDateTime.now());

        AppUser airlineAdmin = new AppUser();
        airlineAdmin.setStatus(UserStatus.ACTIVE.toString());
        airlineAdmin.setUpdatedAt(LocalDateTime.now());
        userService.updateUserDetails(airlineAdmin);



        return
    }
}
