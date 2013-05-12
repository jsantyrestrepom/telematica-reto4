package application;


import model.Calculator;
/**
 *
 * @author SANTY
 */
public class Application {
    private static Calculator calc;

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String result;
        int p1, p2;
        
        if (args.length == 3) {
            calc = new Calculator();
            calc.init();
            String op = args[0].toLowerCase();
            try {
                p1 = Integer.parseInt(args[1]);
                p2 = Integer.parseInt(args[2]);
            } catch (NumberFormatException ex) {
                p1 = 1;
                p2 = 2;
            }
            System.out.println("=> Operation:");
            if ("sumar".equals(op)) {
                 System.out.println( calc.sumar(p1, p2) );
            }
            if ("restar".equals(op)) {
                System.out.println( calc.restar(p1, p2) );
            }
            if ("multiplicar".equals(op)) {
                System.out.println( calc.multiplicar(p1, p2) );
            }
            if ("dividir".equals(op)) {
                System.out.println( calc.dividir(p1, p2) );
            }
//        } else if (args.length == 1) {     read xml file
            
        } else {
            System.out.println("=> Incorrects paramaters");
            System.exit(0);
        }
    }
    
}
