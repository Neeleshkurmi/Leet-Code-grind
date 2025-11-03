package linkedlist;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LL {
    ListNode head;
    ListNode tail;


    class ListNode {

        int val;
        ListNode next;

        public ListNode(){}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void insertFirst(int val){
            ListNode newNode = new ListNode(val);


            newNode.next = head;
            head = newNode;
        }

        public void insertLast(int val){
            ListNode temp = head;

            while (temp.next!=null){
                temp = temp.next;
            }

            ListNode newNode = new ListNode(val);

            temp.next = newNode;

        }

        public void insertAt(int val, int index){

            ListNode temp = head;

            for(int i=1; i<index-1; i++){
                temp = temp.next;
            }
            ListNode newNode = new ListNode(val,temp.next);

            temp.next = newNode;
        }

        public int deleteLast(){
            ListNode temp = head;

            while(temp.next.next!=null){
                temp = temp.next;
            }
            int val = temp.next.val;

            temp.next =null;
            return val;
        }

        public int deleteAt(int index){
            int val;
            ListNode temp = head;

            for(int i=1; i<index-1; i++){
                val = temp.val;
                temp = temp.next;
            }
            int va = temp.next.val;
            temp.next = temp.next.next;

            return va;
        }

        public int deleteFirst(){
            ListNode temp = head;
            head = head.next;
            int val  = temp.val;
            temp.next =null;
            return val;
        }

        public ListNode getNode(int pos, ListNode head){
            ListNode temp = head;
            int count =0;

            while(count!=pos){
                temp = temp.next;
                count++;
            }
            return temp;
        }

        public void creteCycle(int lastPos, int pos, ListNode head){

            ListNode lastNode = getNode(lastPos, head);
            ListNode cylicNode = getNode(pos , head);

            lastNode.next = cylicNode;

        }

        public void display(){
            ListNode temp = head;
            System.out.print("HEAD -> ");

            while(temp!=null){
                System.out.print(temp.val+" -> ");
                temp=temp.next;
            }

            System.out.println("NULL");
        }

        public void display(ListNode head){
            ListNode temp = head;
            System.out.print("HEAD -> ");

            while(temp!=null){
                System.out.print(temp.val+" -> ");
                temp=temp.next;
            }

            System.out.println("NULL");
        }


        public ListNode addLists(ListNode head1, ListNode head2){
            ListNode head = new ListNode(0);
            ListNode current = head;

            int sum=0, carry=0;

            ListNode temp1 = head1;
            ListNode temp2 = head2;

            while(temp2!=null && temp1!=null){
                int digit1 = temp1.val;
                int digit2 = temp2.val;

                sum = carry + digit1 + digit2;
                carry = sum/10;

                ListNode node = new ListNode(sum%10);
                current.next = node;
                current = current.next;

                temp1 =temp1.next;
                temp2 = temp2.next;
            }


            while(temp2!=null){
                sum = temp2.val + carry;
                carry = sum/10;

                ListNode node = new ListNode(sum%10);
                current.next = node;
                current = current.next;

                temp2 = temp2.next;
            }
            while(temp1!=null){
                sum = temp1.val + carry;
                carry = sum/10;

                ListNode node = new ListNode(sum%10);
                current.next = node;
                current = current.next;

                temp1 = temp1.next;
            }

            if(carry > 0){
                ListNode node = new ListNode(carry);
                current.next = node;
            }

            return head.next;
        }

        public ListNode convert(int[] arr){
            ListNode node = new ListNode();

            for(int i= arr.length-1; i>=0; i--){
                ListNode newNode = new ListNode(arr[i]);
                newNode.next = head;
                head = newNode;
            }
            return head;
        }

        public ListNode convert(ArrayList<Integer> arr){
            ListNode node = new ListNode();

            for(int i= arr.size()-1; i>=0; i--){
                ListNode newNode = new ListNode(arr.get(i));
                newNode.next = head;
                head = newNode;
            }
            return head;
        }


        public ListNode getHead(){
            return head;
        }

        public void addition(ListNode node1 , ListNode node2){
            ListNode myHead = addLists(node1, node2);
            myHead.display(myHead);
        }

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            ListNode dummyHead = new ListNode(0);
            ListNode current = dummyHead;

            while(list1!=null && list2!=null){
                int digit = Math.min(list1.val, list2.val);

                ListNode node = new ListNode(digit);
                current.next = node;
                current = current.next;

                if(list1.val<=list2.val){
                    list1 = list1.next;
                }
                else {
                    list2 = list2.next;
                }
            }

            while(list1!=null){
                ListNode node = new ListNode(list1.val);
                current.next = node;
                current = current.next;

                list1 = list1.next;
            }

            while(list2!=null){
                ListNode node = new ListNode(list2.val);
                current.next = node;
                current = current.next;

                list2 = list2.next;
            }
            return dummyHead.next;
        }

        public void mergeTwoList(ListNode list1, ListNode list2) {
            ListNode node = mergeTwoLists(list1,list2);
            node.display(node);
        }


        public ListNode deleteDuplicates(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }

            ListNode current = head;
            ListNode next = current.next;

            while(current!=null && next!=null){
                if(current.val==next.val){
                    current.next = next.next;
                    next = current.next;
                }
                else{
                    current = next;
                    next = next.next;
                }
            }

            return head;
        }

        public void deleteDuplicate(ListNode head){
            ListNode node = deleteDuplicates(head);
            node.display(node);
        }
        public boolean hasCycle(ListNode head) {

            if(head==null || head.next==null){
                return false;
            }

            ListNode slow = head;
            ListNode fast = head;

            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;

                if(slow==fast){
                    return true;
                }
            }

            return false;
        }

        public ListNode sortList(ListNode head) {
//        ListNode node = head;
////        ListNode temp = head;
//
//        while(temp!=null){
//            int min = temp.val;
//            ListNode inner = temp;
//            ListNode swap = new ListNode();
//            while(inner!=null){
//                if(inner.val< min){
//                    min = inner.val;
//                    swap = inner;
//                }
//                inner = inner.next;
//            }
//            swap.val = temp.val;
//            temp.val = min;
//            temp = temp.next;
//        }
//        return node;
            ListNode temp = head;
            ArrayList<Integer> list = new ArrayList<>();

            while(temp!=null){
                list.add(temp.val);
                temp = temp.next;
            }
            Collections.sort(list);
            int i=0; temp = head;

            while (temp!=null){
                temp.val = list.get(i++);
                temp = temp.next;
            }

//            convert(list);
            return head;
        }
    }










    public static void main(String[] args) {
        LL myList = new LL();
        ListNode m = myList.new ListNode();



//        m.insertFirst(0);
//        m.insertFirst(4);
//        m.insertFirst(3);
//        m.insertFirst(5);
//        m.insertFirst(-1);
//
//        myList.sortList(m.getHead());
//        m.display();

        m.convert(new int[]{1,2,3,4,5,6,7,8});
        m.display();


//
//        LL list = new LL();
//        ListNode p = list.new ListNode();
//        ListNode n = list.new ListNode();
////        m.insertFirst(9);
//        m.insertFirst(8);
//        m.insertFirst(7);
//        m.insertFirst(9);
////        m.insertFirst(9);
////        m.insertFirst(9);
////        m.insertFirst(9);
//
//        m.insertFirst(2);
//
//        m.creteCycle(3,1,m.getHead());
//
//        System.out.println(m.hasCycle(m.getHead()));
//        System.out.println(n.hasCycle(n.getHead()));
//        System.out.println(n.hasCycle(null));
//        p.insertFirst(2);
//        System.out.println(n.hasCycle(p.getHead()));
//        m.display();


//        n.insertFirst(2);
//        n.insertFirst(9);
//        n.insertFirst(9);
//        n.insertFirst(9);
//        n.insertFirst(9);





//        n.insertFirst(1);

//        System.out.println(34510+8);

//        n.insertFirst(1);
//
//        LL a = new LL();
//        ListNode add = a.new ListNode();
//        add.deleteDuplicate(m.getHead());
//        add.deleteDuplicate(n.getHead());

//        add.mergeTwoList(n.getHead(), m.getHead());
//
//        add.addition(m.getHead(),n.getHead());

//        m.display();
//        n.display();


//        System.out.println("before insertion: ");
//        m.display();
//
//        System.out.println("insertion at bigining: ");
//        m.insertFirst(9);
//        m.insertFirst(10);
//        m.insertFirst(12);
//        m.display();
//
//        System.out.println("insertion at end: ");
//        m.insertLast(8);
//        m.insertLast(7);
//        m.insertLast(6);
//        m.insertLast(5);
//        m.insertLast(4);
//        m.insertLast(3);
//        m.insertLast(2);
//        m.insertLast(1);
//        m.display();
//
//        System.out.println("after insertion at index 2");
//        m.insertAt(11,2);
//        m.display();
//
//        System.out.println("deletion at end: ");
//        System.out.println(m.deleteLast());
//
//        System.out.println("deletion at bigining: ");
//        System.out.println(m.deleteFirst());
//
//        System.out.println("deletion at specific position:5 ");
//        System.out.println(m.deleteAt(5));

//        m.display();



         /*
         public ListNode addTwoNumbers(ListNode head1, ListNode head2){
            ListNode head = null;
            int sum=0, carry=0;
            ListNode temp1 = head1;
            ListNode temp2 = head2;

            while(temp2!=null && temp1!=null){
                int digit1 = temp1.val;
                int digit2 = temp2.val;
                sum = carry + digit1 + digit2;
                carry = sum/10;
                ListNode node = new ListNode(sum%10);
                node.next= head;
                head = node;
                temp1 =temp1.next;
                temp2 = temp2.next;
            }

            while(temp2!=null){
                sum = temp2.val + carry;
                carry = sum/10;
                ListNode node = new ListNode(sum%10);
                node.next=head;
                head = node;
                temp2 = temp2.next;
            }
            while(temp1!=null){
                sum = temp1.val + carry;
                carry = sum/10;
                ListNode node = new ListNode(sum%10);
                node.next=head;
                head = node;
                temp1 = temp1.next;
            }
            return head;
        }
          */


    }
}
