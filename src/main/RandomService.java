package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class RandomService {

    public static List<String> randomSymbolResults = new CopyOnWriteArrayList<>();

    public static String getRandomSymbol() {
        List<Thread> threads = new LinkedList<>();

        String[] tmp1=new String[0];
       char k;
       String s;
       int y,x,r,length;
       Integer l;


         l=1;
        for (Integer i = 0; i < 123; i++) {  //big letters

//            if (i > 0 && i < 10) {
//                OurThread1 t = new OurThread1(i.toString());
//                threads.add(t);
//            }
            if ((i > 0 && i < 10) || (i > 91 && i < 96) || (i > 35 && i < 59)) {

                if (l > 9) l = 0;

                String[] newArray = Arrays.copyOf(tmp1, tmp1.length + 1);
                System.arraycopy(newArray, 0, tmp1, 0, tmp1.length);
                newArray[newArray.length - 1] = l.toString();
                tmp1 = newArray;
                l++;
            }



            if ((i > 64 && i < 91) || (i > 96 && i < 123)) {
                String[] newArray = Arrays.copyOf(tmp1, tmp1.length + 1);
                System.arraycopy(newArray, 0, tmp1, 0, tmp1.length);
                x = (int) i;
                k = (char) x;
                s = String.valueOf(k);
                newArray[newArray.length - 1] = s;
                tmp1 = newArray;
                threads.add(new OurThread1(s));
            }


            if ((i==60) || (i==90)||(i==40) || (i>30&&i<70) || (i==30)) {

                 y= tmp1.length/2;
                String[] newArray = Arrays.copyOf(tmp1, tmp1.length + 1);

                System.arraycopy(tmp1, 0, newArray, 0, y);
                s = "_";
                newArray[y] = s;
                System.arraycopy(tmp1, y, newArray, y+1, tmp1.length - y);
                tmp1 = newArray;
//                threads.add(new OurThread1(s));
            }
        }
//        System.out.println("a1");
//        for (String arr: tmp1){
//            System.out.print(arr+" , ");
//           }
//
        //System.out.println("a2");
//


          //  threads.add(new OurThread1("_"));
//            OurThread1 t = new OurThread1(i.toString());
//            threads.add(t);


        Random gen = new Random();
        length=tmp1.length-1;
        for (int i = 0; i < tmp1.length-2; i++) {
            r = gen.nextInt(tmp1.length);
            tmp1[i] = tmp1[r];
            tmp1[r] = tmp1[length];
            length--;
        }



            for (String arr: tmp1){
                // System.out.print(arr+" , ");
                threads.add(new OurThread1(arr));
            }
       // System.out.println(" ");





        for (Thread t : threads) {
            t.start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = RandomService.randomSymbolResults.get(1);
        RandomService.randomSymbolResults.clear();
        return result;
    }
}
