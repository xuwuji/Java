package com.xuwuji.leetcode;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。  
 * 
 * 请注意，你的答案必须是子串的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * @author i509669
 *
 */
public class L3LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0 || s == null) {
			return 0;
		}

		HashMap<Character, Integer> map = new HashMap<>();

		int maxLength = 0;
		/**
		 * 维护一个滑动的窗口，窗口中的字符串永远保证是不重复的
		 * 
		 * left代表窗口的左下标，right代表窗口的右下标
		 * 
		 * 对字符串进行依次扫描
		 */
		for (int left = 0, right = 0; right < s.length(); right++) {
			char current = s.charAt(right);
			// 如果在滑动过程中，出现了窗口内已有的字符
			if (map.containsKey(current)) {
				/**
				 * 1、将左下标进行右移到已出现字符的下一位
				 * 
				 * 2、因为此时，原来窗口中左下标到已出现字符的这一段是重复的
				 */
				left = Math.max(left, map.get(current) + 1);
			}
			// 更新窗口的右坐标
			map.put(current, right);
			// 最长子串的长度即为此时窗口的长度与历史窗口长度其中的最大值
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}
}
