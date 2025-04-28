import java.util.*;

public class stack {
    Stack <Integer> s = new Stack<Integer>();
    Stack<Integer> a = new Stack<Integer>();

    void getmin(){
        if (a.isEmpty()){
            System.out.println("no element inserted ");
        }
        else{
            System.out.println(a.peek());

        }
    }
    void peek(){
        if(s.isEmpty()){
            System.out.println("no element inserted ");
        }
        else{
            System.out.println(s.peek());
        }
    }
    void push(int ele){
        if (s.isEmpty()){
            s.push(ele);
            a.push(ele);
        }
        else{
            s.push(ele);
            if(ele < a.peek()){
                a.push(ele);
            }
        }

    }
    void pop(){
        if (s.isEmpty()){
            System.out.println("no element to pop");
        }
        else{
            int t = s.pop();
            System.out.println("element poped is "+ t);
            if(t == a.peek()){
                a.pop();
            }
        }
        
    }
    public static void main(String[] args) {

        stack mystack = new stack();
        mystack.push(1);
        mystack.push(4);
        mystack.peek();
        mystack.pop();
        mystack.push(12);
        mystack.push(0);
        mystack.getmin();

        
    }
}
