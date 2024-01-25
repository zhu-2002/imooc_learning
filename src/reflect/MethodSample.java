package reflect;

import reflect.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodSample {
    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("reflect.entity.Employee");
            Constructor constructor = employeeClass.getConstructor(new Class[]{
                    Integer.class,String.class,Float.class,String.class
            });
            Employee employee = (Employee) constructor.newInstance(new Object[]{
                    100,"李磊",3000f,"研发部"
            });
            // 获取对应方法
            Method method = employeeClass.getMethod("updateSalary", new Class[]{
                    Float.class
            }) ;
            // 执行
            // 第一个参数：执行对象 第二个参数：原始方法的参数
            Employee employee1 = (Employee)method.invoke(employee,new Object[]{1000f});
            System.out.println(employee1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
