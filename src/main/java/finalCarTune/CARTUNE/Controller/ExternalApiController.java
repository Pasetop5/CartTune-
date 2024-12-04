package finalCarTune.CARTUNE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import finalCarTune.CARTUNE.Service.CarService;
import finalCarTune.CARTUNE.Model.CarImage;
import finalCarTune.CARTUNE.Model.CarInfo;



@Controller
public class ExternalApiController {

    @Autowired
    private CarService carService;

    @GetMapping("/CarImages")
    public String ContactMap(Model model) {
        CarImage[] carImages = carService.getCarImagesAndDescriptions();
        model.addAttribute("carImages", carImages);
        return "contact-us"; // name of the html template
    }



    @GetMapping("/CarInfo")
    public String CarInfo(Model model) {

        CarInfo[] carDetails = carService.getCarDetails();

        model.addAttribute("carDetails", carDetails);

        return "car-insight"; // name of the html template
    }

}
