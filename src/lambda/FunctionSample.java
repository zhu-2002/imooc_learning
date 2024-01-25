package lambda;

import java.util.Random;
import java.util.function.Function;

// 利用Function函数式生成定长随机字符串
public class FunctionSample {
    public static void main(String[] args) {
        Function<Integer,String> randomStringFunction = l->{
           String chars = "abcdefghijklmnopqrstuvwxyz" ;
           StringBuffer stringBuffer = new StringBuffer() ;
            Random random = new Random() ;
            for ( int i = 0 ; i < l ; i++ ){
                int pos = random.nextInt(chars.length());
                stringBuffer.append(chars.charAt(pos));
            }
            return stringBuffer.toString() ;
        } ;
        String randString = randomStringFunction.apply(16);
        System.out.println(randString);
    }
}
