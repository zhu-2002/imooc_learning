package lambda;

import java.util.function.Predicate;

// Predicate是新增的函数式接口，位于java.util.function
// Predicate用于测试传入数据是否满足判断要求
// Predicate接口需要实现test()方法进行逻辑判断
public class PredicateSample {
    public static void main(String[] args) {
        Predicate<Integer> predicate = n->n>4 ;
        boolean res = predicate.test(10);
        System.out.println(res);
    }
}
