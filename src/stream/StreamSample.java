package stream;

// stream流式处理式建立在Lambda基础上的多数据处理技术
// stream对集合数据进行高度抽象，极大简化代码量
// stream可对集合进行循环迭代，去重，筛选，排序，聚合等一系列处理

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 五种创建方式
public class StreamSample {
    // 1.基于数组进行创建
    @Test
    public void generator1(){
        String[] arr = {"lily","Micheal","Maria"} ;
        Stream<String> stream = Stream.of(arr) ;
        stream.forEach(s-> System.out.println(s));
    }
    // 2.基于集合进行创建
    @Test
    public void generator2(){
        List<String> list = new ArrayList<>() ;
        list.add("lily") ;
        list.add("micheal") ;
        list.add("Maria") ;
        Stream<String> stream = list.stream() ;
        stream.forEach(s-> System.out.println(s));
    }
    // 3.利用generate发给发创建无限长度的流
    @Test
    public void generator3(){
        // Supplier创建新的对象使用
        Stream<Integer> stream = Stream.generate(()->new Random().nextInt(10000)) ;
        // limit 限制流的长度
        stream.limit(100).forEach(i-> System.out.println(i));

    }
    // 4.利用迭代器创建流
    @Test
    public void generator4(){
        // 起始值  步长
        Stream<Integer> stream = Stream.iterate(1,n->n+1);
        stream.limit(100).forEach(i-> System.out.println(i));
    }
    // 5.创建字符列创建流
    @Test
    public void generator5(){
        String str = "abcdefg" ;
        // 转换成ASCII码或unit码
        IntStream stream = str.chars() ;
        stream.forEach(i-> System.out.println(i));
    }
    public static void main(String[] args) {

    }
}
