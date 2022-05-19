package com.example.alab.service.impl;

import com.example.alab.dto.FilesRes;
import com.example.alab.service.FileService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

import static com.example.alab.config.FileNamesConfig.*;

@Service
public class FileServiceImpl implements FileService {

    @SneakyThrows
    @Override
    public FilesRes writeToFiles(Integer amount) {

        AtomicInteger atomicInteger = new AtomicInteger(1);
        BufferedWriter threadWriter1 = new BufferedWriter(new FileWriter(FIRST_THREAD_FILE));
        BufferedWriter threadWriter2 = new BufferedWriter(new FileWriter(SECOND_THREAD_FILE));
        BufferedWriter resultWriter = new BufferedWriter(new FileWriter(RESULT_FILE));

        Thread thread1 = new Thread(() -> writeToFile(atomicInteger, amount, resultWriter, threadWriter1));
        Thread thread2 = new Thread(() -> writeToFile(atomicInteger, amount, resultWriter, threadWriter2));

        Long multyThreadStart = System.currentTimeMillis();
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long multyThreadEnd = System.currentTimeMillis();

        threadWriter1.close();
        threadWriter2.close();
        resultWriter.close();

        BufferedWriter singleThreadWriter1 = new BufferedWriter(new FileWriter(SINGLE_THREAD_FIRST_FILE));
        BufferedWriter singleThreadWriter2 = new BufferedWriter(new FileWriter(SINGLE_THREAD_SECOND_FILE));
        Long singleThreadStart = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            if (checkPrime(i)) {
                singleThreadWriter1.write(i + " ");
                singleThreadWriter2.write(i + " ");
            }
        }
        Long singleThreadEnd = System.currentTimeMillis();

        singleThreadWriter1.close();
        singleThreadWriter2.close();

        return FilesRes.builder()
                .multyThreadTime(multyThreadEnd - multyThreadStart)
                .singleThreadTime(singleThreadEnd - singleThreadStart)
                .build();
    }

    @SneakyThrows
    private void writeToFile(AtomicInteger atomicInteger, Integer amount, BufferedWriter resultWriter, BufferedWriter threadWriter) {
        while (atomicInteger.get() < amount) {
            Queue<String> threadQueue = new ArrayDeque<>();
            writeAndIncrement(atomicInteger, resultWriter, threadQueue);
            while (!threadQueue.isEmpty()) {
                threadWriter.write(threadQueue.poll());
            }
        }
    }

    private synchronized void writeAndIncrement(AtomicInteger integer, BufferedWriter resultWriter, Queue<String> threadQueue) throws IOException {
        int num = integer.getAndIncrement();
        if (checkPrime(num)) {
            String text = num + " ";
            threadQueue.offer(text);
            resultWriter.write(text);
        }
    }

    private boolean checkPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
