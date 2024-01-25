package lambda;

import java.util.function.Consumer;

public class ConsumerSample {
    public static void output(Consumer<String> consumer){
        String text = "hello world" ;
        consumer.accept(text);
    }
    public static void main(String[] args) {
        output(s-> System.out.println("打印结果为："+s));
    }
}
