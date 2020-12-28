package com.kurshit.leetcode.pastgoogle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructWordUsingDice {

	public static void main(String[] args) {
		String word = "hello";
		List<List<Character>> testCase1 = testCase1();

		System.out.println(possible(word, testCase1));

	}

	public static List<List<Integer>> possible(String test, List<List<Character>> input) {
		List<List<Integer>> res = new ArrayList<>();
		helper(test, 0, res, new ArrayList<>(), input);
		return res;
	}

	public static void helper(String test, int start, List<List<Integer>> res, List<Integer> temp,
			List<List<Character>> input) {

		if (temp.size() == test.length()) {
			res.add(new ArrayList<>(temp));
		} else {
			for (int i = start; i < test.length(); i++) {
				for (int j = 0; j < input.size(); j++) {
					if (!temp.contains(j)) {
						if (input.get(j).contains(test.charAt(i))) {
							temp.add(j);
							helper(test, i + 1, res, temp, input);
							//temp.remove(temp.size() - 1);  // uncomment this line to get all possible dice values
						}
					}
				}
			}
		}

	}

	public static List<List<Character>> testCase1() {
		Character[] a1 = { 'a', 'l', 'c', 'd', 'e', 'f' };
		Character[] a2 = { 'a', 'b', 'c', 'd', 'e', 'f' };
		Character[] a3 = { 'a', 'b', 'c', 'h', 'e', 'f' };
		Character[] a4 = { 'a', 'b', 'c', 'd', 'o', 'f' };
		Character[] a5 = { 'a', 'b', 'c', 'l', 'e', 'f' };

		List<List<Character>> input = new ArrayList<>();
		input.add(Arrays.asList(a1));
		input.add(Arrays.asList(a2));
		input.add(Arrays.asList(a3));
		input.add(Arrays.asList(a4));
		input.add(Arrays.asList(a5));

		return input;
	}

}
