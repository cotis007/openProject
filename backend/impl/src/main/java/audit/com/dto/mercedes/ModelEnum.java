package audit.com.dto.mercedes;

import java.util.HashMap;
import java.util.Map;

public enum ModelEnum {
    CLASS_S("S"),
    CLASS_C("C"),
    CLASS_GT("GT"),
    MAYBACH("MAYBACH");
    private final String model;
    private static final Map<String, String> map = new HashMap<>();

    static {
        for (ModelEnum mod : ModelEnum.values()) {
            map.put(mod.name(), mod.getModel());
        }
    }

    public static Map<String, String> getModelEnum() {
        return map;
    }

    ModelEnum(String s) {
        this.model = s;
    }

    private String getModel() {
        return model;
    }
}
