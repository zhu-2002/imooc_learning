package reflect;

public class Addition implements MathOperation{

    @Override
    public float operate(int a, int b) {
        return a+b+0.0f;
    }
}
