public class Radix{
    private MyLinkedList[] pockets = new MyLinkedList[20];
    public static void radixsort(int[]data){
        for(int i = 0; i < 20; i ++){
            pockets[i] = new MyLinkedList();
        }
        radhelper (data, 0);
    }
    public static void radhelper(int [] data, int num){
        for (int i = 0; i < data.length; i ++){
            if(data[i] < 0){
                //num is how many times should be divided by 10
                pockets[9 - (data[i] % 10)].add(data [i]);
            }
            else {
                pockets[10 + (data[i] % 10)].add(data [i]);
            }
        }
        reset (data);
    }
    


}
