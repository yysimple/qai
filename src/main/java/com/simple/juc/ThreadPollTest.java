package com.simple.juc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-07-30 21:34
 **/
public class ThreadPollTest {
    // 这个是你自己的线程池
    private static final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 4);

    public void todoOther(){}

    //  获取 block
    public List<Integer> listBlock() {
        return Arrays.asList(1, 2, 3);
    }

    // 计算offset
    public void culOffset() {}

    // 下载
    public void downloadToLocal() {}

    // 记录
    public void saveFile(){}

    // 更新下载进度
    public void updateProcess(){}

    public void roundTaskMap(){}

    public void mergeFile(){}

    public void getFile() {
        // 1. 去做其他事情
        todoOther();

        // 2. 提交线程
        executorService.submit(() -> {
            // 2.1 获取 block
            List<Integer> integers = listBlock();

            // 2.2 开始子进程
            Future<?> submit = executorService.submit(() -> {
                // 3.1 计算offset
                culOffset();

                // 3.2 下载block到本地
                downloadToLocal();

                // 3.3 记录文件？怎么记录？问负责人
                saveFile();

                // 3.4 更新下载进度
                updateProcess();
            });

            // 2.3 轮询taskMap
            roundTaskMap();

            // 2.4 合并文件
            mergeFile();
        });
    }


}
