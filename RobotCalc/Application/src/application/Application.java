package application;


import model.Calculator;
import util.Parser;
/**
 *
 * @author SANTY
 */
public class Application {
    private static Calculator calc;
    private static Parser parser;

    
    private static String doTheMath(String operation, String param1, String param2) {
        int p1, p2;
        operation = operation.toLowerCase();
        try {
            p1 = Integer.parseInt(param1);
            p2 = Integer.parseInt(param2);
        } catch (NumberFormatException ex) {
            p1 = 1;
            p2 = 2;
        }
//        System.out.println("=> Operation:");
        if ("sumar".equals(operation)) {
            return calc.sumar(p1, p2);
        }
        if ("restar".equals(operation)) {
            return calc.restar(p1, p2);
        }
        if ("multiplicar".equals(operation)) {
            return calc.multiplicar(p1, p2);
        }
        if ("dividir".equals(operation)) {
            return calc.dividir(p1, p2);
        }
        return "";
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        calc = new Calculator();
        parser = new Parser();
        String result;
        
        if (args.length == 3) {
            calc.init();
            System.out.println("\t" + doTheMath(args[0], args[1], args[2]) );
            
        } else if (args.length == 1) {
            System.out.println("=> Opening the xml file");
            calc.init();
            if (parser.openFile(args[0])) {
                while (parser.getNextOperation()) {
                    result = doTheMath(parser.getOperation(), parser.getParameter("p1"), parser.getParameter("p2"));
                    parser.setResult(result);
                    System.out.println("\t" + result);
                }
            } else {
                System.out.println("=> Not such file exits");
            }
        } else {
            System.out.println("=> Incorrects paramaters");
            System.exit(0);
        }
    }
    
}
