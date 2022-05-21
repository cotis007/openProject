package audit.com.processor;

import audit.com.annotations.AuditEvent;
import audit.com.annotations.AuditField;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Component
public class AuditBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Map<String, Class> map = new HashMap<>();

        for (Method method : bean.getClass().getMethods()) {
            AuditEvent auditEvent = AnnotationUtils.getAnnotation(method, AuditEvent.class);
            if (nonNull(auditEvent)) {
                String name = auditEvent.name();
                String description = auditEvent.description();
                System.out.println("AuditEvent: \n" + "     name: " +  name + "\n" + "     description: " + description);

                /** Преобразуем двумерный массив аннотаций, взятый из входных параметров метода, в лист **/
                final List<Annotation> paramAnnotations = Arrays.stream(method.getParameterAnnotations())
                        .flatMap(Arrays::stream)
                        .collect(Collectors.toList());


                /** Используем фильтр для поиска аннотаций нужного типа и собираем в лист **/
                final List<AuditField> auditFields = paramAnnotations.stream()
                        .filter(an -> an instanceof AuditField)
                        .map(v -> ((AuditField) v)).collect(Collectors.toList());

                /** Используем фильтр для поиска параметров с аннотациями нужного типа и собираем их в лист **/
                List<Parameter> parameters = Arrays.stream(method.getParameters())
                        .filter(p -> p.getAnnotation(AuditField.class) != null)
                        .collect(Collectors.toList());

                try {
                    doSomethingWithAuditParameters(parameters);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //     System.out.println("Calling bean post processor after init for bean:: "+beanName + "class name: "+bean.getClass());
        return bean;
    }


    public void doSomethingWithAuditParameters(List<Parameter> auditParameters) throws ClassNotFoundException {
        System.out.println("\nMethod's input parameters: " + auditParameters.stream().map(Parameter::getName).collect(Collectors.joining(" , " )) + ";");
        for (Parameter parameter : auditParameters) {
            String canonicalName = parameter.getType().getCanonicalName();

            System.out.println("\nParameter: \n" + "     name: " + parameter.getName() + "\n     canonicalName: " + canonicalName);

            List<Field> auditFields = FieldUtils.getFieldsListWithAnnotation(Class.forName(canonicalName), AuditField.class);
            printAllElem(auditFields);
            //       auditFields.forEach(AccessibleObject::trySetAccessible);
        }
    }

    public void printAllElem(List<Field> auditFields) {
        for (Field field : auditFields) {
            AuditField auditField = field.getAnnotation(AuditField.class);

            String name = auditField.name().equals("") ? field.getName() : auditField.name();
            System.out.println("\nname: " + name + "\n" + "description: " + auditField.description() + "\n" + field.getType().getCanonicalName());

            List<Field> fieldList = FieldUtils.getFieldsListWithAnnotation(field.getType(), AuditField.class);

            if (!CollectionUtils.isEmpty(fieldList)) {
                printAllElem(fieldList);
            }
        }
    }

}



      /*      for (Annotation[] annotation : paramAnnotations) {
                    for (Annotation ann : annotation) {
                        if (ann instanceof AuditField) {
                            System.out.println(((AuditField) ann).description());
                            System.out.println(((AuditField) ann).name());
                        }
                    }
          }*/


