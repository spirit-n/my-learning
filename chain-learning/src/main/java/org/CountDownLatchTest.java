package org;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CountDownLatchTest {
    public static void main(String[] args) throws Exception {
        // User user = new User("张三aa", 111);
        // Validator validator = new Validator();
        // validator.validate(user);

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() {
                System.out.println("hello world");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "hello world";
            }
        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(15, 30, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1000), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        List<Future<String>> futures = new ArrayList<>();
        List<String> results = new ArrayList<>();
        int count = 4;
        CountDownLatch  countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            int finalI = i;
            Future<String> submit = threadPoolExecutor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    try {
                        Thread.sleep(1000);
                        return "结果"+ finalI;
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
            futures.add(submit);

        }

        boolean success  = countDownLatch.await(800, TimeUnit.MILLISECONDS);
        try {
            if(!success){
                throw new RuntimeException("超时");
            } else {
                for (Future<String> future : futures) {
                    String result = future.get();
                    results.add(result);
                }
            }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
            futures.stream()
                    .filter(future -> !future.isDone())
                    .forEach(future -> future.cancel(true));
            threadPoolExecutor.shutdown();
        }

        System.out.println("results = " + results);
    }
}
