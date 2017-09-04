
package com.example.giuseppe.clima.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bbox {

    @SerializedName("east")
    @Expose
    private Double east;
    @SerializedName("south")
    @Expose
    private Double south;
    @SerializedName("north")
    @Expose
    private Double north;
    @SerializedName("west")
    @Expose
    private Double west;
    @SerializedName("accuracyLevel")
    @Expose
    private Integer accuracyLevel;

    public Double getEast() {
        return east;
    }

    public void setEast(Double east) {
        this.east = east;
    }

    public Double getSouth() {
        return south;
    }

    public void setSouth(Double south) {
        this.south = south;
    }

    public Double getNorth() {
        return north;
    }

    public void setNorth(Double north) {
        this.north = north;
    }

    public Double getWest() {
        return west;
    }

    public void setWest(Double west) {
        this.west = west;
    }

    public Integer getAccuracyLevel() {
        return accuracyLevel;
    }

    public void setAccuracyLevel(Integer accuracyLevel) {
        this.accuracyLevel = accuracyLevel;
    }

}
