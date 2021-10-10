### ocr简介
这个项目是用来识别图片的，使用的是tesseract开源的ocr算法技术，只有简单的图片识别功能，其他的训练场景并没有做

这个项目是因为我自己不想开一个笔记平台的会员，也是我只要 ocr的功能，所以还不如自己搞一个，之后还可以研究一下其他的训练

### 使用
这里的使用很简单，直接启动项目，然后访问接口就行，注意几个地方：
- tesseract 软件是需要下载的，下载地址：https://digi.bib.uni-mannheim.de/tesseract/
  
- 上面最好配置一下path环境，把安装路径配置即可，其实无所谓，因为在代码里用的是全路径
```text
String cmd = String.format("D:\\tools\\software\\ocr\\source\\tesseract %s %s %s", createFile, outputPath, "-l chi_sim");
```
- 这里还需要配置几个文件夹。因为我在测试使用临时目录的时候很麻烦，又因为我大概率就是自己在电脑上用即可，一般不会
放在服务器上，所以，只要简单的用下即可
```text
String createFile = "E:\\ocr\\" + filename;
```  