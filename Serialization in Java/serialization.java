import java.io.*;

// MAIN CLASS
public class serialization{
    public static void main(String[] args)
    {
        ll list = new ll();
        list.insert(list, 'L');
        list.insert(list, 'I');
        list.insert(list, 'S');
        list.insert(list, 'T');
        System.out.println("Linked List:");
        list.print(list);

/* As we can see here, I have inserted letters into the Linked List 
but since the Linked List implemetation is with <int> datatype
the letters get converted to their ASCII codes and those will be 
printed on the screen. If we use  double quotes ("") to insert 
it will show an error as by using double quotes we are forcing it
to read the input as a string.
*/
       // Serialization
        try{
            FileOutputStream fout = new FileOutputStream("serialized_list");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(list);
            out.close();
        }
        catch(Exception e){System.out.println(e);}
        // Deserialization
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("serialized_list"));
            ll ll = (ll)in.readObject();
            System.out.println("Deserialized Linked List");
            ll.print(ll);
            in.close();
        }catch(Exception e){System.out.println(e);}
    }
}

// LINKED LIST IMPLEMENTATION
class ll implements Serializable{
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    ll(){
        head = null;
    }
    ll(int d){
        head = new Node(d);
    }
    public static void insert(ll list, int data){
        Node next_node = new Node(data);
        if(list.head == null){
            head = next_node;
        }else{
            Node last = list.head;
            while(last.next!=null){
                last = last.next;
            }
            last.next = next_node;
        }
    }
    public static void print(ll l){
        Node temp = l.head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

