package model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nico on 26.07.16.
 */

public class City {
    @SerializedName("_id")
    @Expose
    private Integer _id;
    @SerializedName("key")
    @Expose
    private Object key;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("iata_airport_code")
    @Expose
    private Object iataAirportCode;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("geo_position")
    @Expose
    private GeoPosition geoPosition;
    @SerializedName("location_id")
    @Expose
    private Integer locationId;
    @SerializedName("inEurope")
    @Expose
    private Boolean inEurope;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("coreCountry")
    @Expose
    private Boolean coreCountry;
    @SerializedName("distance")
    @Expose
    private Object distance;

    // _id, name, type, latitude, longitude
    @Override
    public String toString() {
        return String.format("%d,%s,%s,%f,%f", _id, name, type, getLatitude(),
                getLongitude());
    }

    public Double getLatitude() {
        return geoPosition.getLatitude();
    }

    public Double getLongitude() {
        return geoPosition.getLongitude();
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Object getIataAirportCode() {
        return iataAirportCode;
    }

    public void setIataAirportCode(Object iataAirportCode) {
        this.iataAirportCode = iataAirportCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Boolean getInEurope() {
        return inEurope;
    }

    public void setInEurope(Boolean inEurope) {
        this.inEurope = inEurope;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Boolean getCoreCountry() {
        return coreCountry;
    }

    public void setCoreCountry(Boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    public Object getDistance() {
        return distance;
    }

    public void setDistance(Object distance) {
        this.distance = distance;
    }

    public class GeoPosition {

        @SerializedName("latitude")
        @Expose
        private Double latitude;
        @SerializedName("longitude")
        @Expose
        private Double longitude;

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

    }

}


