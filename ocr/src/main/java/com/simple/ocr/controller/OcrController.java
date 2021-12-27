package com.simple.ocr.controller;

import org.springframework.web.bind.annotation.*;
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

    /**
     * debug形式，解析一下该过程：
     * 1. 首先是http请求过来，由于我是再内网还是再本机的情况，所以网络没有那么复杂，走的是lo回环，也存在tcp
     * 具体的就是网络的知识点，可以参考：https://www.zhihu.com/question/43590414；然后就是通过软件驱动（依旧是网络层）
     * 然后拿到对应的http信息的封装（这里就是Servlet的操作），再spring中，使用的是HttpServlet来接收信息
     * -
     * 2. 我们这里就从HttpServlet开始，从java的网络处理中，最后封装成servlet 之后会调用 HttpServlet中的service();
     *
     *
     * @return
     */
    @GetMapping("/testMvc")
    public String testMvc() {
        System.out.println("我被调用了...");
        return "testMvc";
    }

    @GetMapping("/testMvcHasParam")
    public String testMvc(String name) {
        System.out.println("我被调用了...");
        return "testMvc: " + name;
    }

}
