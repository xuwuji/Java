package com.xuwuji.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * 
 * @author i509669
 *
 */
public class L2AddTwoNumbers {

	/**
	 * 刚开始想到的办法，将两个链表转换成数字然后相加，得到和之后再转换成链表
	 * 
	 * 没想到的问题：两个链表有可能非常长，无法用数字进行表示
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int times1 = 1;
		int times2 = 1;
		long num1 = 0;
		long num2 = 0;
		while (l1 != null) {
			num1 = num1 + l1.val * times1;
			times1 = times1 * 10;
			l1 = l1.next;
		}
		while (l2 != null) {
			num2 = num2 + l2.val * times2;
			times2 = times2 * 10;
			l2 = l2.next;
		}
		String value = String.valueOf(num1 + num2);
		// System.out.print(value);
		ListNode dummy = new ListNode(0);
		ListNode pointer = dummy;
		for (int i = value.length() - 1; i >= 0; i--) {
			int current = Integer.valueOf(String.valueOf(value.charAt(i)));
			// System.out.println(current);
			pointer.next = new ListNode(current);
			pointer = pointer.next;
		}
		return dummy.next;
	}

	/**
	 * 解题思路：有p1和p2两个指针，分别对两个链表进行扫描，对相同分位的数字进行相加
	 * 
	 * 模10后的值就是此位相加后的值，除10后可以判断是否进1
	 * 
	 * 如果进1则将这个1加到下一位
	 * 
	 * 最后注意一个边界条件，就是最后两位相加之后如果进1，则需要把这个1放到最后得节点上
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		ListNode p1 = l1, p2 = l2;
		int sum = 0;
		while (p1 != null || p2 != null) {
			if (p1 != null) {
				sum = sum + p1.val;
				p1 = p1.next;
			}
			if (p2 != null) {
				sum = sum + p2.val;
				p2 = p2.next;
			}
			current.next = new ListNode(sum % 10);
			current = current.next;
			sum = sum / 10;
		}
		if (sum == 1) {
			current.next = new ListNode(1);
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// System.out.println("107".charAt(2));
		L2AddTwoNumbers l2AddTwoNumbers = new L2AddTwoNumbers();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		// l2AddTwoNumbers.addTwoNumbers2(l1, l2);
		l2AddTwoNumbers.addTwoNumbers(l1, l2);
	}
}
