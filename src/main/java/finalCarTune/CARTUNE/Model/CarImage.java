package finalCarTune.CARTUNE.Model;

public class CarImage {

    // Attributes
    private String imageUrl;
    private String description;


    // Constructor
    public CarImage(String imageUrl, String description) {
        this.imageUrl = imageUrl;
        this.description = description;
    }

    // Getters
    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }
}
