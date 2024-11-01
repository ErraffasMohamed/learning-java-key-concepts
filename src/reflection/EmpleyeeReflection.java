package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class EmpleyeeReflection {
    private Class obj;
    private Field[] fields;
    private Method[] methods;
    public EmpleyeeReflection() {}
    public EmpleyeeReflection(Class clazz) {
        this.obj = clazz;
        fields = clazz.getDeclaredFields();
        methods = clazz.getDeclaredMethods();
    }
    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }

    public Method[] getMethods() {
        return methods;
    }

    public void setMethods(Method[] methods) {
        this.methods = methods;
    }

    @Override
    public String toString() {
        return "EmpleyeeReflection{" +
                "methods=" + Arrays.toString(methods) +
                ", fields=" + Arrays.toString(fields) +
                '}';
    }

    public Class getObj() {
        return obj;
    }
    public void setObj(Class obj) {
        this.obj = obj;
    }

}
