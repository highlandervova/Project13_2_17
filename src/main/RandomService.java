package main;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RandomService {

    public static List<String> randomSymbolResults = new CopyOnWriteArrayList<>();

    public static String getRandomSymbol() {
        List<Thread> threads = new LinkedList<>();
        for (Integer i = 0; i < 10; i++) {
            OurThread1 t = new OurThread1(i.toString());
            threads.add(t);
        }
        threads.add(new OurThread1("_"));
        for (Thread t : threads) {
            t.start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = RandomService.randomSymbolResults.get(4);
        RandomService.randomSymbolResults.clear();
        return result;
    }
}
