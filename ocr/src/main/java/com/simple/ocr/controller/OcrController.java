package com.simple.ocr.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-10-08 23:04
 **/
@RestController
public class OcrController {

    @PostMapping("/image/ocr")
    public String reg(@RequestBody MultipartFile file) throws IOException {
        String result = "";
        String filename = file.getOriginalFilename();
        String createFile = "E:\\ocr\\" + filename;
        File save = new File(createFile);
        System.out.println();
        if (!save.exists()) {
            save.createNewFile();
        }
        file.transferTo(save);
        String outputPath = createFile.substring(0, createFile.lastIndexOf("."));
        System.out.println("输入路径：" + createFile + ", 输出路径：" + outputPath);
        System.out.println(save.exists());
        String cmd = String.format("D:\\tools\\software\\ocr\\source\\tesseract %s %s %s", createFile, outputPath, "-l chi_sim");
        System.out.println("指令：" + cmd);
        result = cmd(cmd, outputPath);
        return result;
    }

    public String cmd(String cmd, String outputPath) {
        BufferedReader br = null;
        String result = "";
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            int i = p.waitFor();
            if (i == 0) {
                // 读取文件
                String outFile = outputPath + ".txt";
                File file = new File(outFile);
                System.out.println("最后的输出路径：" + outFile);
                br = new BufferedReader(new FileReader(file));
                String temp = "";
                StringBuffer sb = new StringBuffer();
                while ((temp = br.readLine()) != null) {
                    sb.append(temp);
                }
                // 文字结果
                result = sb.toString();
                System.out.println("最后的结果：" + result);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
