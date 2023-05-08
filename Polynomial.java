public class Polynomial {

    double[] a; //coefficients, in order from highest to lowest order
    double c; //constant of integration

    //constructor
    Polynomial(double[] a){
        this.a = new double[a.length];

        for(int i=0; i <a.length; i++){
            this.a[i] = (a[i]);
        }
    }

    //integrates each coefficient's terms
    public double[] integrate(double c){
        double[] f = new double[a.length + 1];
        int j = a.length;

        for(int i=0; i<a.length; i++){
            f[i] = a[i] / (j);
            j--;
        }
        f[f.length-1] = c;

        return f;
    }

    //derives each coefficient's terms
    public double[] derive(){
        int j = a.length - 1;
        double[] d = new double[j];

        for(int i=0; i<d.length; i++){
            d[i] = a[i] * (j);
            j--;
        }

        return d;
    }

    //evaluates polynomial at point x
    public double evaluate(double x){
        double f = 0;
        int j = a.length-1;

        for(int i=0; i<a.length; i++){
            f += a[i] * Math.pow(x,j);
            j--;
        }
        return f;
    }
    
    // Prints out polynomial
    public String toString(){
        String s = "";
        int j = a.length-1;

        s+= "f(x) = ";
        s+= String.format("%.2f",Math.abs(a[0])) + "x^" + j;
        j--;

        for(int k=1; k<a.length; k++){
            
            if(a[k] > 0){ //determines whether to print + or -
                s+= " + ";
            }else{
                s+= " - ";
            }

            if(a[k]!=0){ //prints out coefficients if they are not 0
                if(j > 1){
                    s+= String.format("%.2f",Math.abs(a[k])) + "x^" + j;
                } else if(j == 1){
                    s+= String.format("%.2f",Math.abs(a[k])) + "x";
                } else{
                    s+= String.format("%.2f",Math.abs(a[k]));
                }
            }

            j--;
        }

        return s;
    }

}
