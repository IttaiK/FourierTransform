import java.math.BigDecimal;
import java.math.RoundingMode;

public class Complex {

    //complex numbers are kept in the form a + bi
    //a is a real number, b is the leading coeff for an imaginary (i)

    private double real;
    private double imag;

    public Complex(double _real, double _imag){
        real = _real;
        imag = _imag;
    }

    public double getReal(){
        return real;
    }

    public double getImag(){
        return imag;
    }

    public void implicitAdd(Complex o){//this + o
        real += o.getReal();
        imag += o.getImag();
    }

    public Complex add(Complex o){//return this + o
        double r = o.getReal()+real;
        double im = o.getImag()+imag;
        return new Complex(r,im);
    }

    public Complex subtract(Complex o){//return this - o
        double r = real-o.getReal();
        double im = imag-o.getImag();
        return new Complex(r,im);
    }

    public Complex mult(Complex o){
        double a = (o.getReal()*real)-(o.getImag()*imag);
        double b = (o.getReal()*imag)+(o.getImag()*real);
        return new Complex(a, b);
    }
    public Complex mult(int o){
        return new Complex(real*o, imag*o);
    }

    //this^o
    // sometimes this will come back as e^pi*i, this is polar coordinates (kinda like vectors),
    //  to turn into (x,y) take the cos for the real (x) and sin for the imag (y)
    public Complex exp(double k){
        double mag = Math.sqrt((real*real)+(imag*imag));
        double ang = Math.atan(imag/real);
        double r = Math.pow(mag,k)*Math.cos(k*ang);
        double _imag = Math.pow(mag,k)*Math.sin(k*ang);
        return new Complex(r, _imag);
    }

    public static Complex rootOfUnity(double k, double n){
        double a = Math.cos(2*Math.PI*(k/n)); 
        double b = Math.sin(2*Math.PI*(k/n));
        return new Complex(round(a,12), round(b,12));
    }

    public static Complex[] rootsOfUnity(int n){
        Complex[] retVal = new Complex[n];
        for(int k=0; k<n; k++){
            retVal[k] = rootOfUnity(k+1,n);
        }
        return retVal;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public String toString(){
        return real + " + " + imag + "i";
    }
}
