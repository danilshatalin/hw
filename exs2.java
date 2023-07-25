try {
    int d = 0;
    double catchedRes1 = intArray[8] / d;
    System.out.println("catchedRes1 = " + catchedRes1);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Catching ArrayIndexOutOfBoundsException: " + e);
} catch (ArithmeticException e) {
    System.out.println("Catching ArithmeticException: " + e);
}