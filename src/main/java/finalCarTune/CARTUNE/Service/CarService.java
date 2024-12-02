package finalCarTune.CARTUNE.Service;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import finalCarTune.CARTUNE.Model.CarImage;
import finalCarTune.CARTUNE.Model.CarInfo;

@Service
public class CarService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://api.api-ninjas.com/v1/cars?limit=20&model=civic";
    private static final String API_KEY = "5bxSbmfaNIc6ky4wDygGFg==ACyrHKbBy9EVM7qM";
    private static final String UNSPLASH_API_URL = "https://api.unsplash.com/search/photos?query=car&per_page=10&client_id=";
    private static final String UNSPLASH_API_KEY = "sAPJdj3WH4RZ94yfx749ktIsrNEbO1TRbRlSy44XYD8";

    public CarInfo[] getCarDetails() { // to get the car details
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", API_KEY);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<CarInfo[]> response = restTemplate.exchange(API_URL, HttpMethod.GET, entity,
                    CarInfo[].class);
            return response.getBody();
        } catch (Exception e) {
            System.err.println("Unexpected response format: " + e.getMessage());
            return new CarInfo[0];
        }
    }

 

    public CarImage[] getCarImagesAndDescriptions() { // TO get the images and descriptions
        try {
            // Make the API request
            ResponseEntity<Map> response = restTemplate.getForEntity(UNSPLASH_API_URL + UNSPLASH_API_KEY, Map.class);

           
            List<Map<String, Object>> images = (List<Map<String, Object>>) response.getBody().get("results");
            if (images == null || images.isEmpty()) {
                System.out.println("No images found in 'results' field");
                return new CarImage[0];
            }

          
            return images.stream()
                    .map(image -> {
                      
                        Map<String, Object> urls = (Map<String, Object>) image.get("urls");
                        String imageUrl = (String) urls.get("regular"); 
                        String description = (String) image.get("alt_description");

                        // Return a new CarImage object
                        return new CarImage(imageUrl, description);
                    })
                    .toArray(CarImage[]::new); 

        } catch (Exception e) {
            System.err.println("Error fetching car images and descriptions: " + e.getMessage());
            e.printStackTrace();
        }
        return new CarImage[0];
    }

}
