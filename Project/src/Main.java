import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVLTree t=new AVLTree();
        FourWayLinkedList f=new FourWayLinkedList();
        createMatrix(f,5);
        ArrayList<Integer> array=moveBeetle(f);
        for (int i=0;i<array.size();i++) {
            t.root=t.insert(t.root,array.get(i));
        }
        System.out.println("preOrder:");
        t.preOrder(t.root);
        System.out.println(" ");
        System.out.println("inOrder:");
        t.inOrder(t.root);
        System.out.println(" ");
        System.out.println("postorder:");
        t.postorder(t.root);

    }

    static ArrayList<Integer> moveBeetle(FourWayLinkedList f){
        Beetle beetle=new Beetle(f);
        Location location=beetle.getLocation();
        f.set(location.y, location.x,f.get(location.y, location.x)+1);
        int N=(int)Math.sqrt(f.size);
        while (beetle.lookedLocations.size()!=f.size){
            beetle.move();
            f.set(location.y, location.x,f.get(location.y, location.x)+1);
        }
        ArrayList<Integer> array=new ArrayList<>();
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                array.add(f.get(i,j));
            }
        }
        System.out.println("The number of all movements is: "+beetle.getMovementAmount());
        printMatrix(f);
        return array;

    }


    static void createMatrix(FourWayLinkedList f,int N){
        for(int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                f.add(i,j,0);
            }
        }
    }
    static void printMatrix(FourWayLinkedList f){
        int N=(int)Math.sqrt(f.size);
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                sb.append(f.get(i,j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}

