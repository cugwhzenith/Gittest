package IOreview;

import java.io.*;

public class IOopration {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\python练习\\红楼梦.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("BaseReview\\src\\IOreview\\StoneCopy1.txt",false));
        byte[] bytes = new byte[1024];
        int len;
        while((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bis.close();
        bos.close();
        long end = System.currentTimeMillis();
        System.out.println("It costs "+(end-start)+"ms by 字节流");

        long start2 = System.currentTimeMillis();
        BufferedReader bis2 = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\python练习\\红楼梦.txt"),"gbk"));
        BufferedWriter bos2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("BaseReview\\src\\IOreview\\StoneCopy2.txt"),"gbk"));
        char[] bytes2 = new char[1024];
        String str;
        while((str=bis2.readLine())!=null){
            bos2.write(str);
            bos2.newLine();
        }
        bis2.close();
        bos2.close();
        long end2 = System.currentTimeMillis();
        System.out.println("It costs "+(end2-start2)+"ms by 字符流");
    }
}
