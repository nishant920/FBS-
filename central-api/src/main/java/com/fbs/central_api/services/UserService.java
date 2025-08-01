package com.fbs.central_api.services;

import com.fbs.central_api.connectors.DBApiConnector;
import com.fbs.central_api.enums.UserType;
import com.fbs.central_api.models.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
/*
This class is going contain all the user related logics
 */
@Service
public class UserService {
    DBApiConnector dbApiConnector;

    public UserService(DBApiConnector dbApiConnector){
    this.dbApiConnector=dbApiConnector;}

    public List<AppUser> getAllSystemAdmins(){
        return dbApiConnector.callGetAllUsersByUserType(UserType.SYSTEM_ADMIN.toString());
    }

    public AppUser updateUserDetails(AppUser user){
        return dbApiConnector.callUpdateUserEndpoint(user);
    }
}
