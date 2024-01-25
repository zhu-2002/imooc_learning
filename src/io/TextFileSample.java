package io;

import java.io.*;

// 字符输入输出流
// 字符与字节之间的相互转换
public class TextFileSample {
    public static void readBuffer(){
        Reader reader = null ;
        BufferedReader br = null ;
        try{
            File file = new File("./src/io/FileSample.java") ;
            reader = new FileReader(file) ;
            br = new BufferedReader(reader) ;
            String line = null ;
            while ( (line = br.readLine()) != null ) {
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
             if ( br!=null){
                 try {
                     br.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             if( reader != null ){
                 try {
                     reader.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
        }
    }
    public static void irsSample(){
        FileInputStream fis = null ;
        InputStreamReader isr = null ;
        try{
            File file = new File("./src/io/Files/newFile.txt");
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis,"UTF-8") ;
            StringBuffer buffer = new StringBuffer() ;
            while ( isr.ready() ){
                buffer.append((char)isr.read()) ;
//                System.out.println((char)isr.read());
            }
            System.out.println(buffer.toString());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if ( isr != null ){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null ){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void readTextFile() {
        Reader reader = null;
        try {
            File file = new File("./src/io/Files/newFile.txt");
            reader = new FileReader(file) ;
            int ch = 0;
            while ((ch = reader.read()) != -1) {
                System.out.println((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeTextFile() {
        Writer writer = null;
        try {
            File file = new File("./src/io/Files/newFile.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new FileWriter(file);
            writer.write("this is a new textfile !");
            writer.append("new append");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        TextFileSample.readBuffer();
    }
}

