package com.simple.juc.studyinbook.base.demo;

import com.simple.juc.studyinbook.base.PipeTest;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author WuChengXing
 * @date 2021/9/28
 */
public class PrintPipe {
    static class ReaderThread implements Runnable {
        private PipedReader reader;

        public ReaderThread(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                receive = reader.read();
                System.out.println((char) receive + "-线程");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class WriterThread implements Runnable {

        private PipedWriter writer;

        public WriterThread(PipedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            int flag = 0;
            try {
                while (flag < 10) {
                    System.out.println("A-线程");
                    writer.write("B");
                    flag++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader); // 这里注意一定要连接，才能通信

        new Thread(new ReaderThread(reader)).start();
        Thread.sleep(1000);
        new Thread(new WriterThread(writer)).start();
    }
}
