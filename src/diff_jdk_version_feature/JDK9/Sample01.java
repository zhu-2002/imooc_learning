package diff_jdk_version_feature.JDK9;
//私有接口方法

public interface Sample01 {
    default void showInfo(){
        System.out.println("基本信息");
        System.out.println("IP地址："+getIP());
    }
    default void showDetail(){
        System.out.println("详细信息");
        System.out.println("IP地址：" + getIP());
    }
    private String getIP(){
        return "192.168.72.44" ;
    }
}
