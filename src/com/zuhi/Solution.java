package com.zuhi;

import java.util.*;

public class Solution {
    
    private static class Node{
        private int data;
        private Node next;
        private Node(int data){
            this.data = data;
        }
    }
    
    private Node top;
    
    public boolean isEmpty(){
        return top == null;
    }
    
    public int peek(){
        return ( !isEmpty() ? top.data : -1);
    }
    
    public void push(int data){
        Node node = new Node(data);
        node.next = top;
        top = node;
    }
    
    public int pop(){
        int data = top.data;
        top = top.next;
        return data;
    }
    
    public static void main(String[] args) {
        Solution stack = new Solution();
        Solution maxStack = new Solution();
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        
        while(number > 0){
            int type = input.nextInt();
            switch(type){
                case 1:
                    int value = input.nextInt();
                    if (value >= maxStack.peek()) {
                        maxStack.push(value);
                    }
                    stack.push(value);
                    break;
                case 2:
                    if(stack.peek() == maxStack.peek()){
                        maxStack.pop();
                    }
                    stack.pop();
                    break;
                case 3:
                    System.out.println(maxStack.peek());
                    break;
            } 
            
            number--;
        }
        input.close();
    }
}
