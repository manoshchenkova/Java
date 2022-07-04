
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Postfix {

    public static void main(String[] args) {

        Queue <Integer> queue = new LinkedList<Integer>();
        Stack<String> st = new Stack<>();
        var infix = "( 3 * 4 ) + ( 1 - 9 )".split(" ");

        for (int i = 0; i < infix.length; i++) {
            // System.out.println(infix[i]);
            if (isDigit(infix[i])) {
                queue.add(Integer.parseInt(infix[i]));
                // System.out.println(st);
                // System.out.println(queue);
            } 
            else if (isSign(infix[i])) {
                // System.out.println("Это знак");
                if (st.isEmpty() || st.peek() == "(") {
                    st.push(infix[i]);
                    // System.out.println(st);
                    // System.out.println(queue);
                }
                if (Priority(infix[i]) > Priority(st.peek())){
                    st.push(infix[i]);
                    // System.out.println(st);
                    // System.out.println(queue);
                }
                if (Priority(infix[i]) <= Priority(st.peek())){
                    while (Priority(infix[i]) <= Priority(st.peek()) && st.peek() != "("){
                        queue.add(Integer.parseInt(st.pop()));
                    }
                    st.push(infix[i]);
                    // System.out.println(st);
                    // System.out.println(queue);
                }
            } 
            else if (infix[i] == "("){
                st.push(infix[i]);
                // System.out.println(st);
                // System.out.println(queue);
            } 
            else if (infix[i] == ")"){
                while (st.isEmpty() == false && st.peek() != "("){
                    queue.add(Integer.parseInt(st.pop()));
                }
                st.pop();
                // System.out.println(st);
                // System.out.println(queue);
            }
            System.out.println(st);
            System.out.println(queue);
    }
    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int Priority(String c){
            if (c == "^")
            {
                return 3;
            }
            else if (c == "*" || c == "/")
            {
                return 2;
            }
            else if (c == "+" || c == "-")
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    
    public static boolean isSign(String s){
        return "^/*+-".contains(s);
    }
    
}