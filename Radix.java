import java.util.*;
public class Radix{
    private static MyLinkedList <Integer> [] pockets = new MyLinkedList [20];
    private static int o;
    private static int [] data;
    private static int num;
    public static void radixsort(int[]datl){
    // System.out.println(pockets.length);
      if (datl.length == 0){
        return ;
      }
      num = maxd(datl);
      data = datl;
        for(int i = 0; i < 20; i ++){
            pockets[i] = new MyLinkedList();
        }
        radhelper (data, 0);
    }
    public static void radhelper(int [] data, int c){
        // System.out.println(c + "it is more cs");
      if (c <= num){
    int current = (int) Math.pow(10,c);
        for (int i = 0; i < data.length; i ++){
            if(data[i] < 0){
                //num is how many times should be divided by 10
                // might need to take into account the negative sign
                pockets[9 + ((data[i] / current) % 10)].add(data [i]);
            }
            else {
                pockets[10 + ((data[i] / current) % 10)].add(data [i]);

            }
    }
    // System.out.println(c + "  its a c" + o ++);
        reset (data, c);
    }
}
    public static void reset (int [] data, int c){
      int y = 0;
      for (int i = 0; i < pockets.length ; i ++){
        while (pockets[i].size()> 0){
          data [y] = pockets[i].removeFront();
          y ++;
        }
      }
      // System.out.println(c ++);



      radhelper(data, c+1);
      // System.out.println("k");
    }
    private static int maxd(int [] datl){
      int m = datl [0];
      for (int i = 1; i < datl.length; i ++){
        if (m < datl [i]){
          m = datl [i];
        }
      }
      int n = 1;
      while (m > 9){
        m = m / 10;
        n ++;
      }
      return n;
    }


}
