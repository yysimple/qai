package com.simple.page.util;

import com.simple.io.ZipUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.UUID;

/**
 * @author WuChengXing
 * @date 2021/9/6
 */
public class WebToZipUtils {
    /*public static <T> void toWebZip(List<T> userList) {
        if (userList.size() > 0) {
            *//** 下面为下载zip压缩包相关流程 *//*
            HttpServletRequest request = ServletActionContext.getRequest();
            FileWriter writer;
            *//** 1.创建临时文件夹  *//*
            String rootPath = request.getSession().getServletContext().getRealPath("/");
            File temDir = new File(rootPath + "/" + UUID.randomUUID().toString().replaceAll("-", ""));
            if (!temDir.exists()) {
                temDir.mkdirs();
            }
            *//** 2.生成需要下载的文件，存放在临时文件夹内 *//*
            // 这里我们直接来10个内容相同的文件为例，但这个10个文件名不可以相同
            for (int i = 0; i < 10; i++) {
                dataMap.put("userList", userList);
                Map<String, String> endMap = new HashMap<>();
                endMap.put("user", "老王");
                endMap.put("time", "2017-10-10 10:50:55");
                dataMap.put("endMap", endMap);
                Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
                cfg.setServletContextForTemplateLoading(ServletActionContext.getServletContext(), "/ftl");
                Template template = cfg.getTemplate("exportExcel.ftl");
                writer = new FileWriter(temDir.getPath() + "/excel" + i + ".xls");
                template.process(dataMap, writer);
                writer.flush();
                writer.close();
            }
            *//** 3.设置response的header *//*
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment; filename=excel.zip");
            *//** 4.调用工具类，下载zip压缩包 *//*
            // 这里我们不需要保留目录结构
            ZipUtils.toZip(temDir.getPath(), response.getOutputStream(), false);
            *//** 5.删除临时文件和文件夹 *//*
            // 这里我没写递归，直接就这样删除了
            File[] listFiles = temDir.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                listFiles[i].delete();
            }
            temDir.delete();
        }
    }*/
}
