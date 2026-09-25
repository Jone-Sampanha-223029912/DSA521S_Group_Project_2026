public class PostfixEvaluator {


    public double evaluate(String expression) {

        String[] tokens = expression.split(" ");

        PostfixStack stack =
                new PostfixStack(tokens.length);


        for (int i = 0; i < tokens.length; i++) {

            String token = tokens[i];


            // Check whether token is an operator
            if (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {


                // Second operand comes off first
                double secondOperand = stack.pop();

                double firstOperand = stack.pop();


                double result = 0;


                if (token.equals("+")) {

                    result =
                            firstOperand + secondOperand;

                } else if (token.equals("-")) {

                    result =
                            firstOperand - secondOperand;

                } else if (token.equals("*")) {

                    result =
                            firstOperand * secondOperand;

                } else if (token.equals("/")) {

                    if (secondOperand == 0) {

                        System.out.println(
                                "Cannot divide by zero."
                        );

                        return 0;
                    }

                    result =
                            firstOperand / secondOperand;
                }


                // Push result back onto stack
                stack.push(result);


                System.out.println(
                        "Operator " + token +
                        " -> result = " + result
                );

                stack.displayStack();


            } else {

                // Token is a number
                double number =
                        Double.parseDouble(token);

                stack.push(number);

                System.out.println(
                        "Push " + number
                );

                stack.displayStack();
            }
        }


        // Peek at final answer
        return stack.peek();
    }
}