package com.simple.io;

import java.io.File;

/**
 * @author WuChengXing
 * @date 2021/10/28
 */
public class FileUtil {

    public static void main(String[] args) {
        File file = pngAndJpeg2jpg(new File("D:\\1门头照.jpg"));
    }

    public static File pngAndJpeg2jpg(File sourceFile) {
        String sourceName = sourceFile.getName();
        File targetFile = null;
        String newFileName = sourceName;
        int lastSplitIndex = sourceName.lastIndexOf(".");
        if (lastSplitIndex != -1) {
            String prefixName = sourceName.substring(0, lastSplitIndex);
            String suffixName = sourceName.substring(lastSplitIndex + 1);
            if ("jpeg".equals(suffixName) || "png".equals(suffixName)) {
                newFileName = prefixName + ".jpg";
                targetFile = new File(newFileName);
                boolean b = sourceFile.renameTo(targetFile);
            }
        }
        return targetFile;
    }

}
