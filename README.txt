Author: Ittai Kohavi
Acknowledgments: Mr. Kuzmaul

List of personally written methods for the Complex class:
    getReal():
        In: N/A
        Out: double
        Effect: returns the real component of the complex number

    getImag():
        In: N/A
        Out: double
        Effect: returns the imaginary component of the complex number

    implicitAdd():
        In: Complex 
        Out: N/A
        Effect: adds another complex number to the complex number called upon, changing the called upon complex number

    mult():
        In: Complex 
        Out: Complex
        Effect: mulitplies the called upon complex number by another complex number and returns the result
    
    mult():
        In: int 
        Out: Complex
        Effect: mulitplies the called upon complex number by an int and returns the result

    exp():
        In: double 
        Out: Complex
        Effect: returns the called upon complex number raised to a double power

    toString():
        In: N/A 
        Out: String 
        Effect: returns a String version of the complex number

    rootOfUnity():
        In: double, double
        Out: Complex
        Effect: returns the root of unity at a given k and n value

List of methods in the Complex class written by others:
    rootsOfUnity(): (Mr. Kuszmaul, light bug fixing by me)
        In: int 
        Out: Complex[]
        Effect: returns the called upon complex number raised to a double power

    round(): (Stack Overflow)
        In: double, int
        Out: double
        Effect: rounds a double to the requested decimal points


List of methods in the Polynomial class written by others:
    evaluate(): (Mr. Kuszmaul, light bug fixing by me)
        In: Complex 
        Out: Complex
        Effect: returns the called upon polynomial evaluated at a complex number

    evaluateAll(): (Mr. Kuszmaul, light bug fixing by me)
        In: Complex[]
        Out: Complex[]
        Effect: evaluates the called upon polynomial at many complex numbers and returns each of the results in an array

    FourierTransform(): (Mr. Kuszmaul)
        In: Complex[]
        Out: Complex[]
        Effect: returns the fourier transform of a complex array