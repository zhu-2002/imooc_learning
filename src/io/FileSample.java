package io;

import java.io.File;
import java.io.IOException;

public class FileSample {
    public static void main(String[] args) {
        File f = new File("./newFIle.txt");
        File d = new File("./io/newDir1/newDir2");
        File dd = new File("./io/newDir1/newDir2/newDir3");
        // 创建新文件
        try {
            // 创建一个文件
            boolean r1 = f.createNewFile();
            System.out.println(f.getPath()+"文件创建是否成功："+r1);
            System.out.println(f.getPath()+"是否存在："+f.exists());
            System.out.println(f.getPath()+"是否为目录："+f.isDirectory());
            System.out.println(f.getPath()+"是否是文件："+f.isFile());
            System.out.println(f.getPath()+"的文件名："+f.getName());
            boolean r2  = f.delete();
             System.out.println(f.getPath()+"文件删除成功："+r2);
            System.out.println(f.getPath()+"是否存在："+f.exists());
            // 创建多级目录
            boolean r3  = d.mkdirs();
            System.out.println(d.getPath()+"是否创建成功："+r3);
            //创建单级目录
            boolean r4 = dd.mkdir();
            System.out.println(dd.getPath()+"是否创建成功："+r4);
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
}
