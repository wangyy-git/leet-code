package com.wanyy.ltd.datastructure.changeFileName;

import java.io.File;

public class ChangeFilesName {

    public static void main(String[] args) {
        String fileFolderPath = "E:\\视频\\尚硅谷 韩顺平 Java数据结构和算法\\视频";

        File fileFolder = new File(fileFolderPath);
        if (fileFolder.isDirectory()) {
            String[] list = fileFolder.list();
            for (String filePath:list){
//                System.out.println(filePath);
                String fileName = fileFolderPath + "\\" + filePath;
                File file = new File(fileName);
                file.renameTo(new File(fileName.replace("尚硅谷-老韩图解Java数据结构和算法-","")));
            }
        }
    }
    
    
}
