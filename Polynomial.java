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

    // compute the FFT of x[], assuming its length n is a power of 2
    public Complex[] FastFourierTransform(Complex[] x) {
        int n = x.length;

        // base case
        if (n == 1) return new Complex[] { x[0] };

        // radix 2 Cooley-Tukey FFT
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n is not a power of 2");
        }

        // compute FFT of even terms
        Complex[] even = new Complex[n/2];
        for (int k = 0; k < n/2; k++) {
            even[k] = x[2*k];
        }
        Complex[] evenFFT = FastFourierTransform(even);

        // compute FFT of odd terms
        Complex[] odd  = even;  // reuse the array (to avoid n log n space)
        for (int k = 0; k < n/2; k++) {
            odd[k] = x[2*k + 1];
        }
        Complex[] oddFFT = FastFourierTransform(odd);

        // combine
        Complex[] y = new Complex[n];
        for (int k = 0; k < n/2; k++) {
            double kth = -2 * k * Math.PI / n;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y[k] = evenFFT[k].add(wk.mult(oddFFT[k]));
            y[k + n/2] = evenFFT[k].subtract(wk.mult(oddFFT[k]));
        }
        return y;
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