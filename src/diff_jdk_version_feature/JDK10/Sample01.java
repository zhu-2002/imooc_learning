package diff_jdk_version_feature.JDK10;

import java.util.ArrayList;

public class Sample01 {
    public static void main(String[] args) {
        var str = new String("a") ;
        var str1 = "a" ;
        System.out.println(str);
        System.out.println(str1);

        var list = new ArrayList<String>() ;
        list.add("abc") ;
//        list.add(312) ;
//        var l = 1001 ;
        var l = Long.valueOf(1001) ;
//        System.out.println(l instanceof Long );
    }
}
