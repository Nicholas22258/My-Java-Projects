/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.busroutes;

/**
 *
 * @author Nicholas Leong EDUV4551823
 */
public class BusRouteInfo {
    private int vertex;
    private String startLoc;
    private String routeDescr;//route description
    private String endLoc;
    private String estimatedTravelTime;
    
    public BusRouteInfo(int vertex, String startLoc, String routeDescr, String endLoc, String estimatedTravelTime) {
        this.vertex = vertex;
        this.startLoc = startLoc;
        this.routeDescr = routeDescr;
        this.endLoc = endLoc;
        this.estimatedTravelTime = estimatedTravelTime;
    }
    
    public int getVertex() {
        return vertex;
    }

    public String getStartLoc() {
        return startLoc;
    }

    public String getRouteDescr() {
        return routeDescr;
    }

    public String getEndLoc() {
        return endLoc;
    }

    public String getEstimatedTravelTime() {
        return estimatedTravelTime;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public void setStartLoc(String startLoc) {
        this.startLoc = startLoc;
    }

    public void setRouteDescr(String routeDescr) {
        this.routeDescr = routeDescr;
    }

    public void setEndLoc(String endLoc) {
        this.endLoc = endLoc;
    }

    public void setEstimatedTravelTime(String estimatedTravelTime) {
        this.estimatedTravelTime = estimatedTravelTime;
    }
}
