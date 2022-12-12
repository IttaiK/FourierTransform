public class Polynomial{

    private Complex[] coeffs;

    public Polynomial(Complex[] _coeffs){
        coeffs = _coeffs;
    }

    public Complex evaluate(Complex x){
        Complex retVal = new Complex(0,0);
        for(int k = 0; k<coeffs.length; k++){
            retVal.implicitAdd(coeffs[k].mult(x.exp(k)));
        }
        return retVal;
    }

    public Complex[] evaluateAll(Complex[] x){
        Complex[] retVal = new Complex[x.length];
        for(int k = 0; k<x.length; k++){
            retVal[k] = evaluate(x[k]);
        }
        return retVal;
    }

    public Complex[] FourierTransform(Complex[] t){
        Polynomial tc = new Polynomial(t);
        return tc.evaluateAll(Complex.rootsOfUnity(t.length));
    }


    //Forgot what the use was for this:
    
    /*
    public double[] synth_div(double[]num, double[]den){
        double[] retVal = num.clone();
        double norm = den[0];
        for(int i = 0; i < num.length-den.length; i++){
            retVal[i] /= norm;
            double c = retVal[i];
            if(c!= 0){
                for (int j = 0; j < den.length; j++) {
                    retVal[i+j]-= den[j]*c;
                }
            }
        }
        return retVal;
    }
    */
}