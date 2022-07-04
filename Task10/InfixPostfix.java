//*Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения. 

import java.util.Stack;

public class InfixPostfix {

    
    public static void main(String[] args) {
      
        var exp = "3 4 * 1 9 - +".split(" "); 
        
        int result = 0;
        System.out.println(exp);
        
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length; i++) {

            if (isDigit(exp[i])) {
                st.push(Integer.parseInt(exp[i]));
            } else {
                switch (exp[i]) {
                    case "+":
                        result = st.pop() + st.pop();
                        st.push(result);
                        break;
                    case "-":
                        result = -st.pop() + st.pop();
                        st.push(result);
                        break;
                    case "*":
                        result = st.pop() * st.pop();
                        st.push(result);
                        break;
                    case "/":
                        result =  st.pop()/ st.pop();
                        st.push(result);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.printf("%d\n", st.pop());

    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}