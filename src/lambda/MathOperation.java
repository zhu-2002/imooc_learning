package lambda;

@FunctionalInterface  // 通知编译器这是函数式接口，自动进行抽象方法检查
public interface MathOperation {
    public Float operate(Integer a ,Integer b) ;
}
