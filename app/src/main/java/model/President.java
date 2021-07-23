package model;


public class President {

    private  long id;
    private String name;
    private String country;

    public President(long id, String name, String country, String dateElection, String imageUrl) {
        this.id = id;
        this.name = name;
        this.country = country;
        DateElection = dateElection;
        this.imageUrl = imageUrl;
    }

    private String DateElection;
    private String imageUrl;


    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateElection() {
        return DateElection;
    }

    public void setDateElection(String dateElection) {
        DateElection = dateElection;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "President{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", DateElection='" + DateElection + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
