
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

        if (head.next == null) {      return null; 
        } 
        Node<T> second_last = head; 

        while (second_last.next.next != null) 

            second_last = second_last.next;
        second_last.next = null; 
        return head; 

    }
    
    /**
    * This method reverses a singly linked list in-place.
    * It iterates through the linked list, changing the direction
    * of each node's 'next' pointer to reverse the list.
    *
    * Time Complexity: O(n) - Linear time, where 'n' is the number of nodes in the linked list.
    *   The method iterates through all 'n' nodes once.
    *
    * Space Complexity: O(1) - Constant space, as the method uses a fixed number of pointers (prev, current, next)
    *   and does not create additional data structures proportional to the input size.
    *
    * @param node The head of the linked list to be reversed.
    * @return The new head of the reversed linked list.
    */
    Node<T> reverse(Node<T> node)

    {
        Node<T> prev = null;
        Node<T> current = node;
        Node<T> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // function to check the linkedlist is either empty or not
    public boolean isEmpty() {
        return head == null;
    }

    // function to give the sum of all the data in the nodes.
    public int sum(Node<T> head) {
        if(head.data instanceof String){
            System.out.println("Cannot find sum of strings");
            return 0;
        }
        int sum = 0;
        Node<T> curr = head;
        while (curr != null) {
            sum += (int)curr.data;
            curr = curr.next;
        }
        return sum;
    }
    public static void main(String args[]) {

        // LinkedList<String> ll = new LinkedList<String>();
        LinkedList<Integer> ll = new LinkedList<>();
       ll.addLast(10);
       ll.addLast(20);
       ll.addLast(30);
       ll.addLast(40);
       ll.addFirst(50);
        // ll.addLast("Hello");
        // ll.addLast("i");
        // ll.addLast("am");
        // ll.addLast("Harsh Goyal");
        System.out.println("Original List:");
        ll.printList();
        System.out.println("The sum of List is: " + ll.sum(ll.head));
        ll.head = ll.reverse(ll.head);
        System.out.println("Reversed List:");
        ll.printList();
        System.out.println("The list is empty: " + ll.isEmpty());
    }

}
