package io;

import java.io.*;

// 字节输入流与输出流
public class FileCopySample {
    public static void main(String[] args) {
        File source = new File("./src/io/Files/newFile.txt");
        File target  = new File("./src/io/Files/newFile2.txt");
        // 定义
        InputStream fis = null ;
        OutputStream fos = null ;
        int len ;
        try {
            // 实例化
            fis = new FileInputStream(source) ;
            fos = new FileOutputStream(target) ;
            byte[] bs = new byte[1024] ;
            while ((len = fis.read(bs) ) != -1 ){
                System.out.println(len);
                fos.write(bs,0,len);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //通过finally块确保file对象关闭
            // 先关闭输出流，再关闭输入流，从外往内
            if( fos != null ){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if ( fis != null ){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
