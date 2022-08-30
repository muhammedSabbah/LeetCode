package com.amazon;

import java.util.HashMap;

public class Trie {

	static class TrieNode {
		HashMap<Character, TrieNode> children;
		boolean isEndOfWord;

		TrieNode() {
			isEndOfWord = false;
			children = new HashMap<>();
		}
	}

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode runner = root;
		for (int level = 0; level < word.length(); level++) {
			Character current = word.charAt(level);
			if (!runner.children.containsKey(current)) {
				runner.children.put(current, new TrieNode());
			}
			runner = runner.children.get(current);
		}
		runner.isEndOfWord = true;
	}

	public boolean search(String word) {
		TrieNode runner = root;
		for (int level = 0; level < word.length(); level++) {
			if (!runner.children.containsKey(word.charAt(level))) {
				return false;
			}
			runner = runner.children.get(word.charAt(level));
		}
		return runner.isEndOfWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode runner = root;
		for (int level = 0; level < prefix.length(); level++) {
			if (!runner.children.containsKey(prefix.charAt(level))) {
				return false;
			}
			runner = runner.children.get(prefix.charAt(level));
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		boolean search = trie.search("apple"); // return True
		System.out.println(search);
		trie.search("app"); // return False
		trie.startsWith("app"); // return True
		trie.insert("app");
		trie.search("app"); // return True
	}

}
