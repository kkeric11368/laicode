//Given a stream of characters, 
//find the first non-repeating character from stream. 
//You need to tell the first non-repeating character in O(1) time at any moment.

//Implement two methods of the class:
//
//read() - read one character from the stream
//firstNonRepeating() - return the first non-repoeating character from the stream at any time when calling the method, 
//return null if there does not exist such characters

//Examples:
//read:
//a   b   c   a   c   c    b
//firstNonRepeating:
//a   a   a   b   b   b   null




// My solution
//
public class Solution {
    static class Node {
        Node prev;
        Node next;
        char key;
        Node (char key) {
            this.key = key;
        }
    }

    private Map<Character, Node> hashmap;
    private Node head;
    private Node tail;

    public Solution() {
        hashmap = new HashMap<>();
    }

    public void read(char ch) {
        if (hashmap.containsKey(ch)) {
            Node node = hashmap.get(ch);
            if (node != null) {
                hashmap.put(ch, null);
                remove(node);
            }
        } else {
            Node node = new Node(ch);
            hashmap.put(ch, node);
            append(node);
        }
    }

    public Character firstNonRepeating() {
        if (head != null) {
            return head.key;
        } else {
            return null;
        }
    }

    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (head == node) {
            head = head.next;
        }
        if (tail == node) {
            tail = tail.prev;
        }
        node.prev = node.next = null; 
    }

    private void append(Node node) {
        if (head != null) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {
            head = tail = node;

        }
    }
}




// Professional Solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.vlhv10alqe93



