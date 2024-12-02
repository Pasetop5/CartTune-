package finalCarTune.CARTUNE.Model;

public class CarImage {
    private String imageUrl;
    private String description;

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
