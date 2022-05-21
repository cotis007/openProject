package audit.com.fabric;

import audit.com.annotations.AuditEvent;
import audit.com.annotations.AuditField;
import audit.com.annotations.Test;
import audit.com.dto.mercedes.Mercedes;
import audit.com.dto.mercedes.ModelEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MercedesFabric {
    public Map<String, String> mercedesEnum = ModelEnum.getModelEnum();

    @Test
    @AuditEvent(name = "getAllCars", description = "Получение списка авто в зависимости от модели")
    public List getAllCars(@AuditField(name = "modelStringTest", description = "model of auto string Test") String model, @AuditField(name = "mercedes", description = "марка") Mercedes mercedes) {
        return  mercedesEnum
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(model))
                .collect(Collectors.toList());
    }
}
