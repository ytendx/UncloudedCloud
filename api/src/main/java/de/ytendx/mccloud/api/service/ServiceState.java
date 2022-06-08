package de.ytendx.mccloud.api.service;

public enum ServiceState {

    STARTING,
    RUNNING,
    MAINTENANCE,
    STOPPING,
    UNKNOWN;

    public int getID(){
        int id = 0;
        for(ServiceState serviceStates : values())
            if(this == serviceStates) break;
            else id++;

        return id;
    }

    public static ServiceState getByID(int id){
        for(ServiceState serviceState : values()){
            if(serviceState.getID() == id) return serviceState;
        }
        return UNKNOWN;
    }
}
