package lambda;
// 可以更加简洁地实现匿名内部类与函数声明与调用
// 基于lambda提供的stream流式计算处理极大简化对集合的操作
// (参数列表)->实现语句
// 参数列表使用逗号分隔参数，参数类型可以省略，单参数括号可以省略
// 实现语句单行直接写，多行使用{}包括
// 约束条件：Lambda表达式只能实现有且仅有一个抽象方法的接口，这种接口称作“函数接口”
// 实现函数式编程，将代码作为可重用的数据带入到程序中,强调“你想做什么”，而不是“你想怎么做”
public class LambdaSample {
    public static void main(String[] args) {
        // 标准使用方式
        MathOperation addition = (Integer a,Integer b)->{
            System.out.println("加法运算");
            return a+b+0.0f ;
        } ;
        System.out.println(addition.operate(5,3));

        // lambda允许忽略参数类型
        MathOperation substract = (a,b)->{
//            System.out.println("加法运算");
            return a-b+0.0f;
        };
        System.out.println(substract.operate(5,3));

        // 省略大括号
        // 当参数只有一个的时候甚至可以省略小括号
        MathOperation multiplication = (a,b)->a*b*1.0f;
        System.out.println(multiplication.operate(1,4));
    }
}
