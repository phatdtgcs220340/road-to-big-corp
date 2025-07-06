package main

import "fmt"

type ListNode struct {
	Val int 
	Next *ListNode
}

// 206 Reverse Linked list
//
// Difficulty : Easy
//
// Time complexity: O(n)
func main() {
	n1 := &ListNode {Val : 1} 
	n2 := &ListNode {Val : 2} 
	n3 := &ListNode {Val : 3} 
	n1.Next = n2
	n2.Next = n3 
	
	curr := reverseList(n1)
	for curr != nil {
		fmt.Println(curr.Val)
		curr = curr.Next
	}
}

func reverseList(head *ListNode) *ListNode {
	curr := head	
	var prev *ListNode
	for curr != nil {
		next := curr.Next 
		curr.Next = prev 
		prev = curr 
		curr = next
	}

	return prev
}
