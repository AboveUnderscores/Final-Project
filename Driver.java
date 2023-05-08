public class Driver{

    public static void main(String args[]){
        

        //NEED UI
        int n = 4; //degree of polynomial (must be inputted to prompt user to input coefficients)
        double[] a = new double[n]; //array of coefficients from  highest to lowest degree (ax^2 + bx + c)
        double c = 12; //constant of integration
        double start = 0; //x minimum
        double end = 1; //x maximum

        //creates array that polynomial evaluated from start to end
        final int evalPoints = 10000; //how many points polynomial is evaluated at
        double stepSize = (end-start)/evalPoints;
        double[] polyeval = new double[evalPoints];
        double[] deriveval = new double[evalPoints];
        double[] inteval = new double[evalPoints];

        //testing code with initialized array
        a[0] = 1.3; //x^3
        a[1] = 12; //x^2
        a[2] = -7.2; //x
        a[3] = -5; // constant
        

        //original inputted polynomial
        Polynomial p = new Polynomial(a);

        //derived polynomial
        double[] d = p.derive();
        Polynomial deriv = new Polynomial(d);

        //integrated polynomial
        System.out.println("\n\n");
        double[] g = p.integrate(c);
        Polynomial intg = new Polynomial(g);
       
        //outputs polynomails for viewing (will be output in GUI)
        System.out.print("Original Function:\n" + p.toString() + "\n\n");
        System.out.print("Derivative:\n" + deriv.toString() + "\n\n");
        System.out.print("Integral:\n" + intg.toString() + "\n\n");

        //evalutates polynomial, derivative, and integral and stores it in output array
        double x = start;
        for(int i=0; i<evalPoints; i++){
            polyeval[i] = p.evaluate(x);
            deriveval[i] = deriv.evaluate(x);
            inteval[i] = intg.evaluate(x);
            x += stepSize;
        }


        //checking output (temp code)
        boolean checkFxnOutput = false; //just because im too lazy to keep toggling the line comment
        if(checkFxnOutput){
            for(int j=0; j<polyeval.length;j++){
                System.out.print(String.format("%.4f",polyeval[j]) + "  ");
            }
        }

        boolean checkDerivOutput = false;
        if(checkDerivOutput){
            for(int j=0; j<deriveval.length;j++){
                System.out.print(String.format("%.4f",deriveval[j]) + "  ");
            }
        }

        boolean checkIntOutput = false;
        if(checkIntOutput){
            for(int j=0; j<inteval.length;j++){
                System.out.print(String.format("%.4f",inteval[j]) + "  ");
            }
        }

    }
}