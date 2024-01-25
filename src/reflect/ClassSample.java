package reflect;

import reflect.entity.Employee;
import thread.mall.Consumer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassSample {
    public static void main(String[] args) {
        try {
            // 将指定的类加载到JVM中，并返回对应的Class对象
            Class employeeClass = Class.forName("reflect.entity.Employee") ;
            // getDeclaredConstructor()获取单个构造方法，getDeclaredConstructors()则是所有构造方法，同样的还有Method(s)和Field(s)
            // getDeclared系列方法可以访问非
            Employee employee = (Employee) employeeClass.getDeclaredConstructor().newInstance();
            System.out.println(employee);
            System.out.println(employee.getEname());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
