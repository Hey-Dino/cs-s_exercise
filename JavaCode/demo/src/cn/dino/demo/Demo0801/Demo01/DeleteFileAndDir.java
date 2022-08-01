package cn.dino.demo.Demo0801.Demo01;

import java.io.File;
import java.io.IOException;

public class DeleteFileAndDir {
    public static void main(String[] args) throws IOException {
        File file = new File("MyFile\\DeleteFileAndDir\\dir1\\dir1-1\\dir1-1-1");
        file.mkdirs();
        File childFile = new File(file, "newfile.txt");
        childFile.createNewFile();
        deleteDir(file);
    }

    /*
    * 此方法仅支持删除包含文件的单个文件夹
    * 无法删除到路径底端
    * */
    public static void deleteDir(File src) {
        // 先删掉文件夹内的文件，随后删除文件夹本身
        File[] files = src.listFiles();
        // 1、遍历File对象，获得其下边的每个文件和包裹它的文件夹
        for (File file : files) {
            // 2、判断遍历到的对象，是文件还是文件夹
            if (file.isFile()) {
                file.delete();
            } else {
                deleteDir(file);
            }
        }

        // 3、删除包裹文件的文件夹
        src.delete();
    }
}
