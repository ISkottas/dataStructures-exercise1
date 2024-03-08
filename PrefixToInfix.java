import java.util.Scanner;

    public class PrefixToInfix {

        public static String converter(String expression){
            String[] tokens = expression.split(" ");
            StringDoubleEndedQueueImpl dLinkedList = new StringDoubleEndedQueueImpl();

            for (int i = tokens.length - 1; i>=0; i--){
                String token = tokens[i];
                if(isOperator(token)){
                    String operand1 = dLinkedList.removeFirst();
                    String operand2 = dLinkedList.removeFirst();
                    String infixExp = "(" + operand1 + " " + token + " " + operand2 + ")";
                    dLinkedList.addLast(infixExp);

                } else {
                    dLinkedList.addLast(token);
                }
            }

            return dLinkedList.removeFirst();

        }

        private static boolean isOperator(String token){
            return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") ;
        }


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the Prefix expression: ");
            String prefixExp = scanner.nextLine();

            String infixExp = converter(prefixExp);

            System.out.println(infixExp);

        }
    }



