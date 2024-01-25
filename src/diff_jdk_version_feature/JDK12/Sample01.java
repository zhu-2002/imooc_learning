package diff_jdk_version_feature.JDK12;

import java.util.Random;

public class Sample01 {
    public static void main(String[] args) {
        int day = new Random().nextInt(7) ;
        int res = switch (day){
            case 0,1,2 -> 88 ;
            case 3 ->99 ;
            case 4,5 ->101 ;
            case 6 ->120 ;
            default -> -1 ;
        };
        System.out.println(res);
    }
}
