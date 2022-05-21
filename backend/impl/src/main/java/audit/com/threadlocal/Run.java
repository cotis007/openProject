package audit.com.threadlocal;

import audit.com.dto.mercedes.MercedesGT;

public class Run {

    public static void main(String[] args) {
        MercedesGT mercedesFabric = new MercedesGT();
        mercedesFabric.setModel(null);
        mercedesFabric.getModel();
    }
}


