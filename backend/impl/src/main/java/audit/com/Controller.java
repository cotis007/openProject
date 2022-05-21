package audit.com;

import audit.com.fabric.MercedesFabric;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@Data
public class Controller {
    private final MercedesFabric mercedesFabric;

    @GetMapping("/getModels")
    public List getCatalog() {
       return mercedesFabric.getAllCars("MAYBACH", null);
    }
}
