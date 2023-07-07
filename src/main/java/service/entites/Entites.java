package service.entites;

public class Entites {
    private String continent;
    private String city;
    private String utc;

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    @Override
    public String toString() {
        return "Entites{" +
                "continent='" + continent + '\'' +
                ", city='" + city + '\'' +
                ", utc='" + utc + '\'' +
                '}';
    }
}
