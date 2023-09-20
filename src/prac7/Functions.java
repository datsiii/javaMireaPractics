package prac7;


import java.util.Stack;

public class Functions {

    public static <T> void insert_at_bottom(Stack<T> stack, T x) {
        if (stack.isEmpty()) stack.push(x); else {
            T a = stack.peek();
            stack.pop();
            insert_at_bottom(stack, x);
            stack.push(a);
        }
    }

    public static <T> Stack<T> reverse(Stack<T> stack) {
        if (stack.size() > 0) {
            T x = stack.peek();
            stack.pop();
            reverse(stack);
            insert_at_bottom(stack, x);
        }
        return stack;
    }
}

