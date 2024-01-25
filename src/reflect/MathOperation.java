package reflect;

@FunctionalInterface  // 通知编译器这是函数式接口，自动进行抽象方法检查
public interface MathOperation {
    public float operate(int a, int b) ;
}
