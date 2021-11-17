//143. reorder list
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode mid(ListNode head){
        ListNode slow, fast;
        slow=fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    public ListNode rev(ListNode head){
        ListNode p, c, f;
        p=f=null;
        c=head;
        
        while(c!=null){
            f=c.next;
            c.next=p;
            p=c;
            c=f;
        }
        
        return p;
    }
    
    public void reorderList(ListNode head) {
        
        ListNode mid=mid(head);
        ListNode nhead=mid.next;
        mid.next=null;
        ListNode curr1=head;
        ListNode curr2=rev(nhead);
        
        ListNode f1=head;
        ListNode f2=curr2;
        
        while(f1!=null && f2!=null){
            f1=curr1.next;
            f2=curr2.next;
            curr1.next=curr2;
            curr2.next=f1;
            curr1=f1;
            curr2=f2;
        }
    }
}

//206. Reverse Linked List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p, f, c;
        c=head;
        p=f=null;
        
        while(c!=null){
            f=c.next;
            c.next=p;
            p=c;
            c=f;
        }
        
        return p;
    }
}

//234. Palindrome linked list
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode reverse(ListNode head){
        ListNode p, f, c;
        p=f=null;
        c=head;
        
        while(c!=null){
            f=c.next;
            c.next=p;
            p=c;
            c=f;
        }
        
        return p;
    }
    
    public ListNode mid(ListNode head){
        ListNode slow=head, fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        return slow;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode mid=mid(head);
        ListNode nhead=mid.next;
        mid.next=null;
        ListNode curr2=reverse(nhead);
        ListNode curr1=head;
        
        while(curr1!=null && curr2!=null){
            if(curr1.val!=curr2.val)
                return false;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        
        nhead=reverse(nhead);
        mid.next=nhead;
        
        return true;
    }
}

//876. Mid of a linked list
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
}