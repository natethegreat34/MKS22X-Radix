
public class MyLinkedList<E>{
    private Node start;
    private Node end;
    private int length;
    // -------------------------------------------------------------------------
    public String toString(){
        String happy = "[";
        Node lol = start;
        if (length == 1 && start != null){
            return "[" + start + "]";
        }
        else{
            while (lol != end && lol != null){
                happy = happy + lol + ", ";
                lol = lol.next();
            }
        }
        if (end != null){
            return happy + end + "]";
        }
        else{
            return happy + "]";
        }
    }
    // -------------------------------------------------------------------------
    public MyLinkedList () {
        //sets everything up
        start = null;
        end = null;
        length = 0;
    }
    // -------------------------------------------------------------------------
    public boolean add(Integer value){
        //adding so it just makes the last one be its previous
        Node gat = new Node (null, null, value);
        if (length == 0){
            start = gat;
        }
        else{
            gat.setPrev(end);
            end.setNext(gat);
        }
        end = gat;
        length ++;
        return true;
    }
    // -------------------------------------------------------------------------
    public void add(int index, Integer value){
        if (index < 0 || index > length){
            throw new IndexOutOfBoundsException();
        }
        else if (index == length){
          //if added to the end, can use other add function
            add(value);
        }

        else if (index == 0){
          //if added to beginning have change the start and then fix the next/prev
            Node gat = new Node (null,null, value);
            start.setPrev(gat);
            gat.setNext(start);
            start = gat;
            length ++;
        }
        else{
            int i = 0;
            Node love = start;
            while ( love != null && i <= index - 1){
                love = love.next();
                i ++;
            }
            Node gat = new Node (null,null, value);
            gat.setPrev(love.prev());
            gat.setNext(love);
            love.prev().setNext(gat);
            love.setPrev(gat);
            length ++;
        }
    }

    // -------------------------------------------------------------------------
    public void extend(MyLinkedList other){
        if (this.size() == 0){
            //if the thing you want to extend is nothing, then the thing
            //becomes the other thing you want to extend it by
            this.setStart(other.start());
            this.setEnd(other.end());
            length = other.size();}
        else{
            if (other.size() !=0){
                this.end().setNext(other.start());
                other.start().setPrev(this.end());
                end = other.end();
                length = this.size() + other.size();
            }
        }
        other.setStart(null);
        other.setEnd(null);
        other.clear();
    }
    // -------------------------------------------------------------------------
    public Integer removeFront(){
        //same as the void add but instead we are getting rid of the next,
        //prev and forming new ones
        Node gat = new Node (null,null, 0);
          // if it's at the beginning the one aftre it become the start
        gat = start;
        start = start.next();
        length --;
        return gat.getData();
    }
    // -------------------------------------------------------------------------
    public Node start(){
        return start;
    }
    public Node end(){
        return end;
    }
    public void setStart(Node other){
      start = other;
    }
    public void setEnd(Node other){
      end = other;
    }
    public void clear (){
      length = 0;
      start = null;
      end = null;
    }

    public int size() {
        return length;
    }
    // -------------------------------------------------------------------------







    private class Node{
      private int data;
      private Node next,prev;
      public Node (Node n, Node p, int d){
        next = n;
        prev = p;
        data = d;
      }
        public Node next(){
          return next;
        }
        public Node prev(){
          return prev;
        }
        public void setNext(Node other){
          next = other;
        }
        public void setPrev(Node other){
          prev = other;
        }
        public Integer getData(){
          return data;
        }
        public Integer setData(Integer i){
          int sigh = data;
          data = i;
          return sigh;
        }
        public String toString(){
          String y = "";
          return y + data;
        }
     }
     }
