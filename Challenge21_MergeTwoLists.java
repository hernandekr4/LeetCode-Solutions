
//A class that represents a node in a singly linked list
class ListNode{
    int val; // to hold the value of the node
    ListNode next; // hold the reference of the next node in the linked list 
    ListNode(){}; // This is a default constructor 
    ListNode(int val){this.val=val;}// this constructor initializes a node with a value
    ListNode(int val, ListNode next){ this.val = val; this.next= next;} // this constructor initializes a node with a value and a next node
    
    
}

class Solution{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        
        //dummy node to hold the result 
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        //compare nodes from both lists and link the smaller Cloneable
        while(l1 != null && l2 != null){
          //compaares current nodes from both lists, if the valude l1 is less than that in l2, append l1 to the result list
            if(l1.val < l2.val){
                tail.next =l1; // connects the smaller node to the tail of the result list 
                l1 =l1.next; //move pointer forward
            } else{ //if the node in l2 is smaller or equal it is appended to the result list and the l2 pointer is moved forward
                tail.next =l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        //Attach remaining elements, if any 
        
        if(l1 != null){
            tail.next =l1;
        } else if (l2 != null){
            tail.next =l2;
        }
        
        //Return the merged list starting from the next of dummy
        return dummy.next;
    }
}



public class Main
{
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode (4);
        
        
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        
        
        Solution solution = new Solution();
        ListNode mergedList = solution.mergeTwoLists(l1, l2);
        
        
        
        //Print merged list
        
        while (mergedList != null){
            System.out.print(mergedList.val + " -> ");
            mergedList = mergedList.next;
        }
        System.out.println("null");
    }
}
