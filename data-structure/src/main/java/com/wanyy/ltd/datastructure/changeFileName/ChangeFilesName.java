package com.wanyy.ltd.datastructure.changeFileName;

import java.io.File;

public class ChangeFilesName {

    public static void main(String[] args) {
        String fileFolderPath = "G:\\白夜追凶";

        File fileFolder = new File(fileFolderPath);
        if (fileFolder.isDirectory()) {
            String[] list = fileFolder.list();
            for (String filePath:list){
//                System.out.println(filePath);
                String fileName = fileFolderPath + "\\" + filePath;
                File file = new File(fileName);
                file.renameTo(new File(fileName.replace(".（热映资源关注微信公众号：dycncn）","")));
            }
        }
    }
    
    
}
