package bitgear.mmwa.installation.manholemonitorinstallation.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ila on 24.1.18..
 */

public class Manhole {

    private Integer id;
    private Double lat;
    private Double lng;
    private String name;
    private String street;
    private String district;
    private String subdistrict;
    private String st_num;
    private Long last_update;
    private String address;


    public Manhole(Integer id, Double lat, Double lng, String name, String street, String district, String subdistrict, String st_num, Long last_update, String address) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.street = street;
        this.district = district;
        this.subdistrict = subdistrict;
        this.st_num = st_num;
        this.last_update = last_update;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLast_update() {
        return last_update;
    }

    public void setLast_update(Long last_update) {
        this.last_update = last_update;
    }

    public String getAddress() {
        return this.district +  " " + this.subdistrict + " " + this.street + " " + this.st_num;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Manhole{" +
                "id=" + id +
                ", lat=" + lat +
                ", lng=" + lng +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", district='" + district + '\'' +
                ", subdistrict='" + subdistrict + '\'' +
                ", st_num='" + st_num + '\'' +
                ", last_update=" + last_update +
                ", address='" + address + '\'' +
                '}';
    }
}
