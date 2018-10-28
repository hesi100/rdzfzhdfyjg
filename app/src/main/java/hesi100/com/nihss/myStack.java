package hesi100.com.nihss;

import java.util.Stack;

/**
 * Created by hesi100 on 6/10/2018.
 */

public class myStack {
    public static Stack<Integer> e=new Stack<Integer>();
    myStack()
    {
        e=new Stack<Integer>();
    }
    public static void push(int x)
    {
        e.push(x);
    }
    public static int pop()
    {
        return e.pop();
    }

}
