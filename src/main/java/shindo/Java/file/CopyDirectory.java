package shindo.Java.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** 
 * 复制文件夹或文件夹 
 */
public class CopyDirectory {
    // 源文件夹
    static String url1 = "F:/category/666666";
    // 目标文件夹
    static String url2 = "F:/category/333333";

    public static void main(String args[]) throws IOException {
        // 创建目标文件夹
        /*(new File(url2)).mkdirs();
        // 获取源文件夹当前下的文件或目录
        File[] file = (new File(url1)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                // 复制文件
                copyFile(file[i], new File(url2 + file[i].getName()));
            }
            if (file[i].isDirectory()) {
                // 复制目录
                copyDirectiory(url1, url2, file[i].getName());
            }
        }*/
    }

// 复制文件   
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        // 新建文件输入流并对它进行缓冲
        FileInputStream input = new FileInputStream(sourceFile);
        BufferedInputStream inBuff = new BufferedInputStream(input);

        // 新建文件输出流并对它进行缓冲
        FileOutputStream output = new FileOutputStream(targetFile);
        BufferedOutputStream outBuff = new BufferedOutputStream(output);

        // 缓冲数组
        byte[] b = new byte[1024 * 5];
        int len;
        while ((len = inBuff.read(b)) != -1) {
            outBuff.write(b, 0, len);
        }
        // 刷新此缓冲的输出流
        outBuff.flush();

        // 关闭流
        inBuff.close();
        outBuff.close();
        output.close();
        input.close();
    }

    // 复制文件夹
    public static void copyDirectiory(String url1, String url2, String orginFileName, long tempFileName, long targetFileName) throws IOException {
        long orgin = 0;
        if (orginFileName != null || !"".equals(orginFileName)) {
            orgin = Integer.parseInt(orginFileName);
        }

        if (orgin == tempFileName) {
            String sourceDir = url1 + File.separator + orgin;
            String targetDir = url2 + File.separator + (targetFileName + "");

            // 新建目标目录
            (new File(targetDir)).mkdirs();
            // 获取源文件夹当前下的文件或目录
            File[] file = (new File(sourceDir)).listFiles();
            for (int i = 0; i < file.length; i++) {
                if (file[i].isFile()) {
                    // 源文件
                    File sourceFile = file[i];
                    // 目标文件
                    File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
                    copyFile(sourceFile, targetFile);
                }
                if (file[i].isDirectory()) {
                    copyDirectiory(url1, url2, file[i].getName(), tempFileName, targetFileName);
                }
            }
        }

    }
}