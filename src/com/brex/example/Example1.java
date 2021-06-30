package com.brex.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Example1 {
    public static void main(String[] args) throws IOException {
        // Typically in Java we use a Deque (Double Ended Queue) for a Stack or a Queue.
        // ArrayDeque implements a Deque with a Dynamic Array
        Deque<Character> deque = new ArrayDeque<>();
        // LinkedList is a linked list data structure that implements the Stack interface.
        deque = new LinkedList<>();

        // What does this program do?
        System.out.println("Enter a line of text\n");
        String input = null;

        input = new BufferedReader(new InputStreamReader(System.in)).readLine();

        System.out.println(stackReverse(input));
        System.out.println(reverse(input));

        var chars = input.toCharArray();
        reverse(chars);
        System.out.println(new String(chars));
    }

    public static String stackReverse(String s) {
        final Deque<Character> stack = new ArrayDeque<>(s.length());
        final StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void reverse(char[] string) {
        for (int i = 0, j = string.length - 1; i < j; ++i, --j) {
            char temp = string[i];
            string[i] = string[j];
            string[j] = temp;
        }
    }
}


