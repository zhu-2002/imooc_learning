package reflect;

import reflect.entity.Employee;

public class ConstructorSample {
    public static void main(String[] args) {
        try {
            // 将指定的类加载到JVM中，并返回对应的Class对象
            Class employeeClass = Class.forName("reflect.entity.Employee") ;
            java.lang.reflect.Constructor constructor = employeeClass.getConstructor(new Class[]{
                    Integer.class,String.class,Float.class,String.class
            });
            Employee employee1 = (Employee)constructor.newInstance(new Object[]{
                    100,"李磊",3000f,"研发部"
            });
            System.out.println(employee1.getEname());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
