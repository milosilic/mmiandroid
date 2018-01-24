package bitgear.mmwa.installation.manholemonitorinstallation.domain;

/**
 * Created by ila on 24.1.18..
 */

public class Manhole {

    private Integer id;
    private Double lat;
    private Double lng;
    private String name;
    private Long last_update;
    private String address;


    public Manhole(Integer id, double lat, double lng, String name, Long last_update, String address) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
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
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
