package io;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionSample {
    public static void main(String[] args) {
        InputStream is = null ;
        OutputStream os = null ;
        // 定义一个网址
        URL url = null ;
        try {
            url = new URL("https://cdn.jsdelivr.net/gh/zhu-2002/img/20230515222931.png");
            URLConnection connection = url.openConnection();
            is = connection.getInputStream();
            os = new FileOutputStream("./src/io/Files/pic.png");
            byte[] bs = new byte[1024] ;
            int len = 0 ;
            while ((len = is.read(bs)) != -1 ){
//                System.out.println(len);
                os.write(bs,0,len);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if ( os != null ){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if ( is != null ){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
