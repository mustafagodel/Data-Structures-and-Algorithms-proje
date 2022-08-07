public class FourWayLinkedList {
    private Node head;
    private Node tail;
    int size;
    private static class Node {
        int element;
        Node next;
        Node prev;
        Node up;
        Node down;
        public Node(int element) {
            this.element = element;
            next = prev = up = down = null;
        }
    }
    public int get(int first,int second){
        Node temp=head;
        for (int i=0;i<first;i++){
            temp=temp.down;
        }
        for (int i=0;i<second;i++){
            temp=temp.next;
        }
        return temp.element;
    }
    private Node getNode(int first,int second){
        Node temp=head;
        for (int i=0;i<first;i++){
            temp=temp.down;
        }
        for (int i=0;i<second;i++){
            temp=temp.next;
        }
        return temp;
    }
    public void set(int first,int second,int element){
        getNode(first, second).element=element;
    }
    public void add(int first,int second,int element){
        if (isEmpty()){
            head=new Node(element);
            tail=head;
            size++;
            return;
        }
        Node temp=new Node(element);
        if (head.next==null){
            head.next=temp;
            tail=temp;
            tail.prev=head;
            size++;
            return;
        }
        if (first==1 && second==0){
            head.down=temp;
            temp.up=head;
            tail=temp;
            size++;
            return;
        }
        if (first!=0){
            Node tempUp=getNode(first-1,second);
            temp.up=tempUp;
            tempUp.down=temp;
            if (second==0){
                tail=temp;
                size++;
                return;
            }
        }
        tail.next=temp;
        temp.prev=tail;
        tail=temp;
        size++;
    }
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        Node temp=head;
        sb.append("[");
        boolean isNext=true;
        int N=(int)Math.sqrt(size);
        for (int i=0;i<size;i++){
            sb.append(temp.element).append(", ");
            if (i%N==N-1){
                temp=temp.down;
                isNext=!isNext;
            }
            else if(isNext){
                temp=temp.next;
            }
            else{
                temp=temp.prev;
            }
            if (i==size-1){
                sb.delete(sb.length()-2,sb.length());
                sb.append("]");
            }
        }
        return sb.toString();
    }



}
