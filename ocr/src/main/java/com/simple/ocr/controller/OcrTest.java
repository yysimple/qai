package com.simple.ocr.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WuChengXing
 * @date 2021/10/9
 */
public class OcrTest {
    /**
     * @param imageFile
     *            传入的图像文件
     * @param flag
     *            是否识别中文
     *
     * @return 识别后的字符串
     */
    public String recognizeByOne(File imageFile, Boolean flag) throws Exception {

        // 将识别出的内容保存在txt临时文本中,目录与图片在同一级,读取万临时文件内容后会删除该文件
        File tempFile = new File(imageFile.getParentFile(), "temp");
        StringBuffer result = new StringBuffer(); // 接收识别结果

        // cmd 输出格式[C:\Program Files (x86)\Tesseract-OCR\tesseract, 1.png,
        // output,-l, chi_sim]
        List<String> cmd = new ArrayList<String>();
        // 注意: C:\\Program Files (x86)\\Tesseract-OCR是你的tesseract-OCR的安装目录
        // 我这里是默认安装目录C:\Program Files (x86)\Tesseract-OCR\
        cmd.add("D:\\tools\\software\\ocr\\source\\tesseract");
        cmd.add("");
        cmd.add(tempFile.getName()); // 指定识别出内容保存位置
        cmd.add("-l"); // 语言参数标志 注意 :这里是字母l 不是数字1
        if (flag) { // 设置语言库 中文 chi_sim 英文 eng
            cmd.add("chi_sim");
        } else {
            cmd.add("eng");
        }

        // ProcessBuilder类是J2SE 1.5在java.lang中新添加的一个新类，
        // 此类用于创建操作系统进程，它提供一种启动和管理进程（也就是应用程序）的方法。
        // 也可用 Runtime.getRuntime().exec("tesseract.exe 1.jpg 1 -l chi_sim"); 执行
        ProcessBuilder pb = new ProcessBuilder();
        pb.directory(imageFile.getParentFile()); // 设置进程工作目录
        cmd.set(1, imageFile.getName());
        pb.command(cmd);
        pb.redirectErrorStream(true);

        Process process = pb.start();
        int w = process.waitFor(); // 进程等待
        if (w == 0)// 0代表正常退出
        {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(tempFile.getAbsolutePath() + ".txt"), "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) { // 读取识别结果
                result.append(str + "\n"); // 这里每读取一行需要添加换行符
                // （否则识别出的结果在用记事本打开不会换行，但是用notepad会看见换行）
            }
            in.close();
        } else {
            String msg;
            switch (w) {
                case 1:
                    msg = "Errors accessing files. There may be spaces in your image's filename.";
                    break;
                case 29:
                    msg = "Cannot recognize the image or its selected region.";
                    break;
                case 31:
                    msg = "Unsupported image format.";
                    break;
                default:
                    msg = "Errors occurred.";
            }
            throw new RuntimeException(msg);
        }
        new File(tempFile.getAbsolutePath() + ".txt").delete(); // 删除临时生成的txt文件
        return result.toString();
    }

    /**
     * 根据文件目录识别图片
     *
     * @param folder
     *            需要识别的图片文件夹
     * @param flag
     *            是否识别中文图片
     */
    public String recognizeByFolder(String folder, Boolean flag) {

        String result = "";// 保存识别出的结果
        String[] fileNames = null;// 获取所有图片名称 ImagesIO.getFileNames(folder)
        for (String filename : fileNames) {
            String impPath = folder + "/" + filename; // 图片路径
            try {
                result += this.recognizeByOne(new File(impPath), false) + "\n";
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //单张图片识别方法
        File file = new File("E:\\images\\test.jpg");
        try {
            System.out.println(new OcrTest().recognizeByOne(file, false));//英文识别 false 中文识别 true
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //文件夹识别方法
//		String folder = "D:\\images";
//		try {
//			System.out.println(new OCRHelper().recognizeByFolder(folder, false));//英文识别 false 中文识别 true
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }

    public String cmd(String[] cmds, String outputPath) {
        BufferedReader br = null;
        String result = "";
        try {
            Process p = Runtime.getRuntime().exec(cmds);
            // 读取文件
            File file = new File(outputPath + ".txt");
            System.out.println("最后的输出路径：" + outputPath);
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

    public String cmd03(String[] cmds) {
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(cmds);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            return sb.toString();
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


    public String cmd01(String cmd) {
        System.out.println("cmd01: " + cmd);
        Process process = null;
        StringBuilder sb = new StringBuilder();
        try {
            process = Runtime.getRuntime().exec(cmd);
            final InputStream is1 = process.getInputStream();
            new Thread(() -> {
                BufferedReader bufferedReader = null;
                String line = null;
                try {
                    bufferedReader = new BufferedReader(
                            new InputStreamReader(is1));
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    is1.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            InputStream is2 = process.getErrorStream();
            BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
            StringBuilder buf = new StringBuilder(); // 保存输出结果流
            String line2 = null;
            while ((line2 = br2.readLine()) != null) buf.append(line2); //
            System.out.println("最后结果：" + buf.toString());
            return buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String excuteBatFile(String file, boolean isCloseWindow) {
        String cmdCommand = null;
        String res = null;
        if (isCloseWindow) {
            cmdCommand = "cmd.exe /c " + file;
        } else {
            cmdCommand = "cmd.exe /k " + file;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmdCommand);
            final InputStream is1 = process.getInputStream();
            new Thread(new Runnable() {
                public void run() {
                    BufferedReader bufferedReader = null;
                    String line = null;
                    try {
                        bufferedReader = new BufferedReader(
                                new InputStreamReader(is1, "GBK"));
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line + "\n");
                        }
                        is1.close();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start(); // 启动单独的线程来清空p.getInputStream()的缓冲区
            InputStream is2 = process.getErrorStream();
            BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
            StringBuilder buf = new StringBuilder(); // 保存输出结果流
            String line2 = null;
            while ((line2 = br2.readLine()) != null) buf.append(line2); //
            return stringBuilder + "&" + buf;
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public static void testocr() {
        try {
            Runtime rt = Runtime.getRuntime();
            String imageFilePath = "E:\\images\\test.jpg";
            String outputFilePath = "E:\\images\\test";
            String[] commands = {"tesseract", imageFilePath, outputFilePath};

            Process pr = rt.exec("D:\\tools\\software\\ocr\\source\\tesseract E:\\images\\test.jpg E:\\images\\test -l chi_sim");

            BufferedReader input = new BufferedReader(new InputStreamReader(
                    pr.getInputStream()));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code " + exitVal);
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
