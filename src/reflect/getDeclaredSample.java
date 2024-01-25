package reflect;

import reflect.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class getDeclaredSample {
    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("reflect.entity.Employee");
            Constructor constructor = employeeClass.getConstructor(new Class[]{
                    Integer.class, String.class, Float.class, String.class
            });
            Employee employee = (Employee) constructor.newInstance(new Object[]{
                    100, "李磊", 4000f, "研发部"
            });
            Field[] fields = employeeClass.getDeclaredFields();
            for (Field field : fields) {
//                System.out.println(field.getName());
                // 1 public 2 private
//                System.out.println(field.getModifiers());
                if(field.getModifiers() == 1){ //pubilc修饰
                    Object val = field.get(employee);
                    System.out.println(field.getName() + ":" + val);
                }else if(field.getModifiers() == 2){ //private修饰
                    String methodName = "get" + field.getName().substring(0,1).toUpperCase()
                            + field.getName().substring(1);
                    Method getMethod = employeeClass.getMethod(methodName);
                    Object ret = getMethod.invoke(employee);
                    System.out.println(field.getName() + ":" + ret);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
