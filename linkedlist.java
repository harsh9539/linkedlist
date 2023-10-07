
class LinkedList<T> {
    Node<T> head;

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(T data) {
        Node<T> temp = new Node<T>(data);
        if (head == null) {
            head = temp;
            return;
        }
        temp.next = head;
        head = temp;
    }

    public void addLast(T data) {
        Node<T> temp = new Node<T>(data);
        if (head == null) {
            head = temp;
            return;
        }
        Node<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
    }

    public void printList() {
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node<T> curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty. Cannot remove.");
            return;
        }

        head = head.next;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty. Cannot remove.");
            return;
        }

        if (head.next == null) {
            // When the head is the only element
            head = null;
            return;
        }

        Node<T> curr = head;
        Node<T> prev = null;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
    }

    public Node<T> removeLastNode(Node<T> head)
    { 
        if (head == null) 
            return null; 

        if (head.next == null) {      
            return null; 
        } 
        Node<T> second_last = head; 

        while (second_last.next.next != null) 

            second_last = second_last.next;
        second_last.next = null; 
        return head; 

    } 
    public LinkedList<String> reverse(Node<T> head)

    {
        LinkedList<String> reverse=new LinkedList<String>();
        Node<T> temp = head;
        while(temp!=null){
            reverse.addFirst(temp.data.toString());
            temp = temp.next;
        }
        return reverse;
    }
    public static void main(String args[]) {
        LinkedList<String> ll = new LinkedList<String>();
//        ll.addLast(10);
//        ll.addLast(20);
//        ll.addLast(30);
//        ll.addLast(40);
//        ll.addFirst(50);
        ll.addLast("Hello");
        ll.addLast("i");
        ll.addLast("am");
        ll.addLast("Harsh Goyal");
        ll.printList();
        LinkedList<String> llreverse = ll.reverse(ll.head);
        llreverse.printList();
    }

}
