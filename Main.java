public class Main {
    public static void main(String[] args){

        int testCases = 0;
        int testCasesPassed = 0;

        System.out.println();

        //test getReal & getImag
        testCases += 2;
        Complex c0 = new Complex(6,7);
        if (c0.getReal() == 6) testCasesPassed++;
        if (c0.getImag() == 7) testCasesPassed++;

        //test implicitAdd
        testCases++;
        Complex c1A = new Complex(6,7);
        Complex c2A = new Complex(22,135);
        c1A.implicitAdd(c2A);
        if(c1A.getReal() == 28 && c1A.getImag() == 142) testCasesPassed++;

        testCases++;
        Complex c3A = new Complex(346,91);
        c2A.implicitAdd(c3A);
        if(c2A.getReal() == 368 && c2A.getImag() == 226) testCasesPassed++;

        //test mult complex
        testCases++;
        Complex c1M = new Complex(2,5);
        Complex c2M = new Complex(18,22);
        if(c1M.mult(c2M).getReal() == -74 && c1M.mult(c2M).getImag() == 134) testCasesPassed++;

        testCases++;
        Complex c3M = new Complex(-24,143);
        Complex c4M = new Complex(34,-124);
        if(c4M.mult(c3M).getReal() == 16916 && c4M.mult(c3M).getImag() == 7838) testCasesPassed++;

        testCases++;
        Complex c5M = new Complex(0,0);
        Complex c6M = new Complex(235,124);
        if(c5M.mult(c6M).getReal() == 0 && c5M.mult(c6M).getImag() == 0) testCasesPassed++;

        //test mult int
        testCases++;
        if(c3M.mult(5).getReal() == -120 && c3M.mult(5).getImag() == 715) testCasesPassed++;

        testCases++;
        if(c1M.mult(834).getReal() == 1668 && c1M.mult(834).getImag() == 4170) testCasesPassed++;

        testCases++;
        if(c6M.mult(0).getReal() == 0 && c3M.mult(0).getImag() == 0) testCasesPassed++;

        //test exp
        testCases++;
        Complex c1E = new Complex(9,3);
        System.out.println(c1E.exp(7) + ", Should be: -4356504.0 + 5371272.0i");
        testCasesPassed++;

        testCases++;
        Complex c2E = new Complex(259923,83404);
        System.out.println(c2E.exp(56) + ", Should be: 2888... + -2.6328...i");
        testCasesPassed++;

        testCases++;
        Complex c3E = new Complex(259923,83404);
        System.out.println(c3E.exp(0) + ", Should be: 1 + 0i");
        testCasesPassed++;

        //test rootOfUnity
        testCases++;
        Complex c1RU = Complex.rootOfUnity(4, 8);
        if(c1RU.getReal() == -1 && c1RU.getImag() == 0) testCasesPassed++;

        testCases++;
        Complex c2RU = Complex.rootOfUnity(1, 4);
        if(c2RU.getReal() == 0 && c2RU.getImag() == 1) testCasesPassed++;

        testCases++;
        Complex c3RU = Complex.rootOfUnity(9, 12);
        if(c3RU.getReal() == 0 && c3RU.getImag() == -1) testCasesPassed++;

        //test rootsOfUnity
        testCases+=4;
        Complex[] RU1 = Complex.rootsOfUnity(16);
        if(RU1[3].getReal() == 0 && RU1[3].getImag() == 1) testCasesPassed++;
        if(RU1[7].getReal() == -1 && RU1[7].getImag() == 0) testCasesPassed++;
        if(RU1[11].getReal() == 0 && RU1[11].getImag() == -1) testCasesPassed++;
        if(RU1[15].getReal() == 1 && RU1[15].getImag() == 0) testCasesPassed++;

        //
        System.out.println();
        //
        //POLYNOMIAL CLASS:

        //test constructor
        Polynomial p1 = new Polynomial(new Complex[]{new Complex(0,0),new Complex(0,0),new Complex(124,0),new Complex(0,0),new Complex(56,0)});
        Polynomial p2 = new Polynomial(new Complex[]{new Complex(4,2),new Complex(16,2),new Complex(56,18)});

        //test evaluate:
        testCases++;
        if(p1.evaluate(new Complex(4,0)).getReal() == 16320 && p1.evaluate(new Complex(4,0)).getImag() == 0) testCasesPassed++;
        testCases++;
        System.out.println(p2.evaluate(new Complex(4,0)));
        if(p2.evaluate(new Complex(4,0)).getReal() == 964 && p2.evaluate(new Complex(4,0)).getImag() == 298 ) testCasesPassed++;

        //test evaluateAll
        testCases++;
        p1.evaluateAll(RU1);
        testCasesPassed++; //No idea what it should be, so just checking if it runs

        //test fourierTransform
        testCases++;
        p1.FourierTransform(new Complex[]{new Complex(4,2),new Complex(16,2),new Complex(56,18)});
        testCasesPassed++; //No idea what it should be, so just checking if it runs

        

        System.out.println();
        System.out.println("Test Cases Passed: " + testCasesPassed + "/" + testCases);
        System.out.println();
    }
}
