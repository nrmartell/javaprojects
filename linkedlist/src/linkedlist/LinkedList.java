package linkedlist;


public class LinkedList {

   private NodeList head, tail;

   private int size;

   public LinkedList() {

       head = null;

       size = 0;

       tail = null;

   }

   public void append(int data) {

       // if list is null

       if(head == null){

           head = new NodeList(data);

           tail = head;

           return;

       }

      

       NodeList newNode = new NodeList(data);

       tail.next = newNode;

       tail = newNode;

   }

  

   public void deleteLast(){

       if(head == null){

           System.out.println("List is empty");

           return ;

       }

      

       if(head.next == null){ // only one node

           head = tail = null;

       }

      

       NodeList temp = head;

       while(temp.next != tail)

           temp = temp.next;

      

       temp.next = null;

       tail = temp;

   }

  

   public void deleteNthNode(int n){

       if(size < n){

           System.out.println("Less than "+n+"node in list");

           return;

       }

      

       if(n==1){// delete first element

           head = head.next;

           return;

       }

      

       if(size == n){ // delete last

           deleteLast();

           return;

       }

      

       NodeList temp = head;

       for(int i=1; i<n-1; i++)

           temp = temp.next;

       temp.next = temp.next.next;

   }

  

   public void insertAfter(int data, int n){

       if(n > size + 1){

           System.out.println("Total number of elements in list is "+size);

           return;

       }

      

       NodeList newNode = new NodeList(data);

       if(n==1){//inserting at first

           newNode.next = head;

           head = newNode;

          

           if(tail == null)

               tail = head;

       }

       else if(size+1 == n){ // inserting at last

           tail.next = newNode;

           tail = newNode;

       }

       else{

           NodeList temp = head;

           for(int i=1; i<n-1; i++){

               temp = temp.next;

           }

           newNode.next = temp.next;

           temp.next = newNode;

       }

   }

  

   public int size(){

       return size;

   }

   public void display(){

       NodeList temp = head;

      

       while(temp != null){

           if(temp.next!=null)

               System.out.print(temp.data+"-->");

           else

               System.out.println(temp.data);

           temp = temp.next;

       }

       System.out.println();

   }

}

// ####################