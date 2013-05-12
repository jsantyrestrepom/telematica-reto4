package model;


import services.ServiceClient;
/**
 *
 * @author SANTY
 */
public class Calculator {
    private ServiceClient client;
    
    
    public void init() {
        client = new ServiceClient();
        client.init();
    }
    
    public String sumar(int a, int b) {
        String r = client.callService("sumar", a +"", b +"");
        if (r.startsWith("error")) {
            return r;
        } else {
            return (a + " + " + b + " = " + r);
        }
    }
    
    public String restar(int a, int b) {
        String r = client.callService("restar", a +"", b +"");
        if (r.startsWith("error")) {
            return r;
        } else {
            return (a + " - " + b + " = " + r);
        }
    }
    
    public String multiplicar(int a, int b) {
        String r = client.callService("multiplicar", a +"", b +"");
        if (r.startsWith("error")) {
            return r;
        } else {
            return (a + " * " + b + " = " + r);
        }
    }
    
    public String dividir(int a, int b) {
        String r = client.callService("dividir", a +"", b +"");
        if (r.startsWith("error")) {
            return r;
        } else {
            return (a + " / " + b + " = " + r);
        }
    }
    
}
