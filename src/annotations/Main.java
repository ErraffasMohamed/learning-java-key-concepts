package annotations;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        AnnotationProcessor.inspectClassAnnotations(Student.class);
//        Service service = new Service();
//        service.completeTask("my task");
//        for(Method method : service.getClass().getDeclaredMethods()) {
//            System.out.println(method.getName());
//            if(method.isAnnotationPresent(LogExecution.class)) {
//                LogExecution logExecution = method.getAnnotation(LogExecution.class);
//                System.out.println(logExecution.value());
//            }
//        }
    }
}
