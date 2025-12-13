package linkedlist;

public class Dll {
    Node head;

    boolean insertFirst(int val){
        Node node = new Node(val);
        if(head==null){
            node.next=head;
            head = node;
        }
        else{
            node.next = head;
            head.previous = node;
            head = node;
        }
        return true;
    }

    class Node {
        int val;
        Node next;
        Node previous;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next){
            this.val=val;
            this.next =next;
        }


        public Node(int val, Node next, Node previous) {
            this.val = val;
            this.next = next;
            this.previous = previous;
        }
    }
    public static void main(String[] args) {
        Dll d = new Dll();
        d.insertFirst(1);
        d.insertFirst(2);
        d.insertFirst(3);
        d.insertFirst(4);
        d.insertFirst(5);
        d.display();
//        d.reverse();
        d.display();
    }

//    public void reverse(){
//        while (head!=null){
//            Node next = head.next;
//            head.next = head.previous;
//            head.previous = ne
//        }
//    }

    private void display() {
        System.out.print("HEAD-->");
        Node temp = head;
        while (temp!=null){
            System.out.print(STR."\{temp.val}<-->");
            temp = temp.next;
        }
        System.out.print("END");
    }
}
