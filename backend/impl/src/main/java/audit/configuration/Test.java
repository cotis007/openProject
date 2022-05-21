package audit.configuration;

import audit.com.dto.mercedes.ClassC;
import audit.com.dto.mercedes.ModelEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.io.IOException;
import java.util.*;

public class Test {
    public static void m(String[] args) throws IOException {
        List<Integer> listInt0 = List.of(1, 2, 3, 4, 4, 5, 6);
        List<Integer> listInt1 = List.of(1, 2, 3, 4, 4, 5, 6);
        List<Integer> listInt2 = List.of(1, 2, 3, 4, 4, 5, 6);

        List<String> listStr0 = List.of("1", "2", "3", "4", "5", "7");
        List<String> listStr1 = List.of("1", "2", "3", "4", "5", "7");
        List<String> listStr2 = List.of("1", "2", "3", "4", "5", "7");

        List<Double> listDouble0 = List.of(1.1, 2.2, 3.3, 4.4, 4.4, 5.5, 6.6);
        List<Double> listDouble1 = List.of(1.1, 2.2, 3.3, 4.4, 4.4, 5.5, 6.6);
        List<Double> listDouble2 = List.of(1.1, 2.2, 3.3, 4.4, 4.4, 5.5, 6.6);

        Map<String, List<Integer>> map = Map.of("Числа", listInt0, "Буквы", listInt1, "Дабл", listInt2);
        Map<String, List<String>> map1 = Map.of("Числа", listStr0, "Буквы", listStr1, "Дабл", listStr2);
        Map<String, List<Double>> map2 = Map.of("Числа", listDouble0, "Буквы", listDouble1, "Дабл", listDouble2);

        Map<String, Map> bigMap = Map.of("MapInteger", map, "Map Double", map2);


        Optional.ofNullable(bigMap).map(v -> v.get("Map String")).map(v -> v.get("Буквы")).orElse("-");


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS);
        objectMapper.registerModule(new ParameterNamesModule());
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.registerModule(new JavaTimeModule());

        //      System.out.println(objectMapper.writeValueAsString(null));


 /*       Thread thread1 = new InterruptedClass();
        thread1.start();*/


        ClassC c = new ClassC();
        c.setModelEnum(ModelEnum.CLASS_C);

        if (ModelEnum.CLASS_C == c.getModelEnum())
        {
            System.out.println("sosatos");
        }

        System.out.println("1234".substring(0, 2));

//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread();
//
//            thread.run();
//            run(() -> {
//                System.out.println(Thread.currentThread().getName());
//                listInt1.forEach(System.out::println);
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }


        System.out.println("end");
    }


    class Tet {

        public void A() {

        }

        public void B() {

        }

    }

    public static void run(Runnable runnable) {
        new Thread(runnable).start();
    }

}

class InterruptedClass extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.print("a");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}