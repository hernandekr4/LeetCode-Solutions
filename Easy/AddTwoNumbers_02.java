package Easy;
//Defining ListNode class 
class ListNode{
    int val; // value of current node 
    ListNode next; //pointer to the next node in the list
    ListNode (){}; //default contructor 

    // Constructor with value
    ListNode(int val){
        this.val = val;
    }

    //contrcutor parametized
    ListNode(int val, ListNode next){
        this.val =val;
        this.next = next;
    }
}


public class AddTwoNumbers_02{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        //create a duymym node for edge cases (adding first node )
            ListNode dummyHead = new ListNode(0);
            ListNode current = dummyHead; // 'current' pointer helps in building the resultant list 
            //Keep track of overflow 
            int carry =0;

            //loop continues aslong as ther are nodes in  either list or there is a carry
            while(l1 != null || l2 != null || carry !=0){
                int sum = carry; //start with carry of previous iteration
                //Add value of current node from the first list if available
                if(l1 != null){
                    sum += l1.val; //add value of current l1's current node 
                    l1 = l1.next;   //Move to the next node in l1
                }
                //Add the value of the current node from the second list(if available)
                if(l2 != null){
                    sum += l2.val; //add the value of l2's current node 
                    l2 = l2.next;   // move to next node in l2
                }
                //compute the new carry for the next iteration (e.g 12/10= 1)
                carry = sum/10;
                //create a new node for the current digit (e.g 12 &10 =2)
                current.next = new ListNode(sum %10);
                //move the 'current' pointer to the next node in the resultant list.
                current = current.next;
            }
            //return the resultant list starting from the node after dummyHead
            return dummyHead.next;
    }

    public static void main(String[] args){
        // Test case: Create first linked list [2 -> 4 -> 3] (342 in reverse)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Test case: Create second linked list [5 -> 6 -> 4] (465 in reverse)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Create an instance of the AddTwoNumbersEfficient class
        AddTwoNumbers_02 solution = new AddTwoNumbers_02();

        // Call the addTwoNumbers method and get the result
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the resulting linked list
        System.out.print("Result: ");
        printLinkedList(result);
    }

     // Helper method to print the linked list
     private static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }


}
