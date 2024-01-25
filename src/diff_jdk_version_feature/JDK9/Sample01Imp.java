package diff_jdk_version_feature.JDK9;

public class Sample01Imp implements Sample01{
    @Override
    public void showDetail() {
        System.out.println("重写会覆盖原本方法");
    }

    public static void main(String[] args) {
        Sample01 sample01 = new Sample01Imp() ;
        sample01.showInfo();
        sample01.showDetail();
    }
}
