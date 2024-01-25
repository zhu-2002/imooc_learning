package reflect;

import reflect.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FieldSample {
    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("reflect.entity.Employee") ;
            Constructor constructor = employeeClass.getConstructor(new Class[]{
                    Integer.class,String.class,Float.class,String.class
            });
            Employee employee = (Employee) constructor.newInstance(new Object[]{
                    100,"李磊",4000f,"研发部"
            });
            Field enameField = employeeClass.getField("ename") ;
            enameField.set(employee,"李雷");
            String ename = (String) enameField.get(employee);
            System.out.println(ename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
