package main;

import java.util.function.Function;

/**
 * Represents a general sine function of the form f(x) = A * sin(B * x + C * PI) + D
 *
 * All coefficients A, B, C, D can be functions of their own.
 * If you need A, B, C or D to be a constant value for the entire function,
 * use the constructors and methods that accept double or float values.
 *
 * The underlying sine function that will be used to calculate the result, is the Math.sin function.
 */
class SineFunction implements Function<Double, Double> {

    private static final double DEFAULT_A = 1.0;
    private static final double DEFAULT_B = 1.0;
    private static final double DEFAULT_C = 0.0;
    private static final double DEFAULT_D = 0.0;

    private Function<Double, Double> a = x -> DEFAULT_A;
    private Function<Double, Double> b = x -> DEFAULT_B;
    private Function<Double, Double> c = x -> DEFAULT_C;
    private Function<Double, Double> d = x -> DEFAULT_D;

    public SineFunction() {
    }

    public SineFunction(Function<Double, Double> a, Function<Double, Double> b,
                        Function<Double, Double> c, Function<Double, Double> d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public SineFunction(Function<Double, Double> a, Function<Double, Double> b,
                        Function<Double, Double> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public SineFunction(Function<Double, Double> a, Function<Double, Double> b) {
        this.a = a;
        this.b = b;
    }

    public SineFunction(Function<Double, Double> a) {
        this.a = a;
    }

    public SineFunction(double a, double b, double c, double d) {
        this.a = x -> a;
        this.b = x -> b;
        this.c = x -> c;
        this.d = x -> d;
    }

    public SineFunction(double a, float p, double c, double d) {
        this.a = x -> a;
        this.b = x -> (double) (1 / p);
        this.c = x -> c;
        this.d = x -> d;
    }

    public SineFunction(double a, double b, double c) {
        this.a = x -> a;
        this.b = x -> b;
        this.c = x -> c;
    }

    public SineFunction(double a, double b) {
        this.a = x -> a;
        this.b = x -> b;
    }

    public SineFunction(double a) {
        this.a = x -> a;
    }

    public void setA(Function<Double, Double> a) {
        this.a = a;
    }

    public void setA(double a) {
        this.a = x -> a;
    }

    public void setB(Function<Double, Double> b) {
        this.b = b;
    }

    public void setB(double b) {
        this.b = x -> b;
    }

    public void setC(Function<Double, Double> c) {
        this.c = c;
    }

    public void setC(double c) {
        this.c = x -> c;
    }

    public void setD(Function<Double, Double> d) {
        this.d = d;
    }

    public void setD(double d) {
        this.d = x -> d;
    }

    /**
     * Resets coefficient A to it's default value.
     */
    public void resetA() {
        this.a = x -> DEFAULT_A;
    }

    /**
     * Resets coefficient B to it's default value.
     */
    public void resetB() {
        this.b = x -> DEFAULT_B;
    }

    /**
     * Resets coefficient C to it's default value.
     */
    public void resetC() {
        this.c = x -> DEFAULT_C;
    }

    /**
     * Resets coefficient D to it's default value.
     */
    public void resetD() {
        this.d = x -> DEFAULT_D;
    }

    /**
     * Resets all coefficients to their default value.
     */
    public void reset() {
        resetA();
        resetB();
        resetC();
        resetD();
    }

    @Override
    public Double apply(Double x) {
        return a.apply(x) * Math.sin(b.apply(x) * x + c.apply(x) * Math.PI) + d.apply(x);
    }
}