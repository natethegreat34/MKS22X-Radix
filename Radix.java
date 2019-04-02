import java.util.*;
public class Radix{
    private MyLinkedList[] pockets = new MyLinkedList[20];
    private int [] data;
    private int num;
    public static void radixsort(int[]datl){
      if (data.length == 0){
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
      if (c > num){
        return;
      }
        for (int i = 0; i < data.length; i ++){
            if(data[i] < 0){
                //num is how many times should be divided by 10
                // might need to take into account the negative sign
                pockets[9 - (-1 *(data[i] / (Math.pow(10,i) % 10)))].add(data [i]);


            }
            else {
                pockets[10 + (data[i] / (Math.pow(10,i) % 10))].add(data [i]);
            }
    }
        reset (data);
        radhelper(data, c++);''
    }
    public static void reset (int [] data){
      int y = 0;
      for (int i = 0; i < pockets.length < i ++){
        while (pockets[i].size()> 0){
          data [y] = pockets[i].removeFront();
          y ++;
        }
      }
    }
    private int maxd(int [] datl){
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
