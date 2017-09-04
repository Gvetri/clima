
package com.example.giuseppe.clima.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geoname_ implements Parcelable{

    @SerializedName("timezone")
    @Expose
    private Timezone timezone;
    @SerializedName("bbox")
    @Expose
    private Bbox bbox;
    @SerializedName("asciiName")
    @Expose
    private String asciiName;
    @SerializedName("countryId")
    @Expose
    private String countryId;
    @SerializedName("fcl")
    @Expose
    private String fcl;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("adminId2")
    @Expose
    private String adminId2;
    @SerializedName("adminId3")
    @Expose
    private String adminId3;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("adminId1")
    @Expose
    private String adminId1;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("fcode")
    @Expose
    private String fcode;
    @SerializedName("continentCode")
    @Expose
    private String continentCode;
    @SerializedName("adminCode2")
    @Expose
    private String adminCode2;
    @SerializedName("adminCode3")
    @Expose
    private String adminCode3;
    @SerializedName("adminCode1")
    @Expose
    private String adminCode1;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("geonameId")
    @Expose
    private Integer geonameId;
    @SerializedName("toponymName")
    @Expose
    private String toponymName;
    @SerializedName("population")
    @Expose
    private Integer population;
    @SerializedName("adminName5")
    @Expose
    private String adminName5;
    @SerializedName("adminName4")
    @Expose
    private String adminName4;
    @SerializedName("adminName3")
    @Expose
    private String adminName3;
    @SerializedName("adminName2")
    @Expose
    private String adminName2;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fclName")
    @Expose
    private String fclName;
    @SerializedName("countryName")
    @Expose
    private String countryName;
    @SerializedName("fcodeName")
    @Expose
    private String fcodeName;
    @SerializedName("adminName1")
    @Expose
    private String adminName1;

    protected Geoname_(Parcel in) {
        asciiName = in.readString();
        countryId = in.readString();
        fcl = in.readString();
        if (in.readByte() == 0) {
            score = null;
        } else {
            score = in.readDouble();
        }
        adminId2 = in.readString();
        adminId3 = in.readString();
        countryCode = in.readString();
        adminId1 = in.readString();
        lat = in.readString();
        fcode = in.readString();
        continentCode = in.readString();
        adminCode2 = in.readString();
        adminCode3 = in.readString();
        adminCode1 = in.readString();
        lng = in.readString();
        if (in.readByte() == 0) {
            geonameId = null;
        } else {
            geonameId = in.readInt();
        }
        toponymName = in.readString();
        if (in.readByte() == 0) {
            population = null;
        } else {
            population = in.readInt();
        }
        adminName5 = in.readString();
        adminName4 = in.readString();
        adminName3 = in.readString();
        adminName2 = in.readString();
        name = in.readString();
        fclName = in.readString();
        countryName = in.readString();
        fcodeName = in.readString();
        adminName1 = in.readString();
    }

    public Geoname_ (){

    }

    public static final Creator<Geoname_> CREATOR = new Creator<Geoname_>() {
        @Override
        public Geoname_ createFromParcel(Parcel in) {
            return new Geoname_(in);
        }

        @Override
        public Geoname_[] newArray(int size) {
            return new Geoname_[size];
        }
    };

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    public Bbox getBbox() {
        return bbox;
    }

    public void setBbox(Bbox bbox) {
        this.bbox = bbox;
    }

    public String getAsciiName() {
        return asciiName;
    }

    public void setAsciiName(String asciiName) {
        this.asciiName = asciiName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getFcl() {
        return fcl;
    }

    public void setFcl(String fcl) {
        this.fcl = fcl;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAdminId2() {
        return adminId2;
    }

    public void setAdminId2(String adminId2) {
        this.adminId2 = adminId2;
    }

    public String getAdminId3() {
        return adminId3;
    }

    public void setAdminId3(String adminId3) {
        this.adminId3 = adminId3;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAdminId1() {
        return adminId1;
    }

    public void setAdminId1(String adminId1) {
        this.adminId1 = adminId1;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getAdminCode2() {
        return adminCode2;
    }

    public void setAdminCode2(String adminCode2) {
        this.adminCode2 = adminCode2;
    }

    public String getAdminCode3() {
        return adminCode3;
    }

    public void setAdminCode3(String adminCode3) {
        this.adminCode3 = adminCode3;
    }

    public String getAdminCode1() {
        return adminCode1;
    }

    public void setAdminCode1(String adminCode1) {
        this.adminCode1 = adminCode1;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Integer getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(Integer geonameId) {
        this.geonameId = geonameId;
    }

    public String getToponymName() {
        return toponymName;
    }

    public void setToponymName(String toponymName) {
        this.toponymName = toponymName;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getAdminName5() {
        return adminName5;
    }

    public void setAdminName5(String adminName5) {
        this.adminName5 = adminName5;
    }

    public String getAdminName4() {
        return adminName4;
    }

    public void setAdminName4(String adminName4) {
        this.adminName4 = adminName4;
    }

    public String getAdminName3() {
        return adminName3;
    }

    public void setAdminName3(String adminName3) {
        this.adminName3 = adminName3;
    }

    public String getAdminName2() {
        return adminName2;
    }

    public void setAdminName2(String adminName2) {
        this.adminName2 = adminName2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFclName() {
        return fclName;
    }

    public void setFclName(String fclName) {
        this.fclName = fclName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFcodeName() {
        return fcodeName;
    }

    public void setFcodeName(String fcodeName) {
        this.fcodeName = fcodeName;
    }

    public String getAdminName1() {
        return adminName1;
    }

    public void setAdminName1(String adminName1) {
        this.adminName1 = adminName1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(asciiName);
        parcel.writeString(countryId);
        parcel.writeString(fcl);
        if (score == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(score);
        }
        parcel.writeString(adminId2);
        parcel.writeString(adminId3);
        parcel.writeString(countryCode);
        parcel.writeString(adminId1);
        parcel.writeString(lat);
        parcel.writeString(fcode);
        parcel.writeString(continentCode);
        parcel.writeString(adminCode2);
        parcel.writeString(adminCode3);
        parcel.writeString(adminCode1);
        parcel.writeString(lng);
        if (geonameId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(geonameId);
        }
        parcel.writeString(toponymName);
        if (population == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(population);
        }
        parcel.writeString(adminName5);
        parcel.writeString(adminName4);
        parcel.writeString(adminName3);
        parcel.writeString(adminName2);
        parcel.writeString(name);
        parcel.writeString(fclName);
        parcel.writeString(countryName);
        parcel.writeString(fcodeName);
        parcel.writeString(adminName1);
    }
}
