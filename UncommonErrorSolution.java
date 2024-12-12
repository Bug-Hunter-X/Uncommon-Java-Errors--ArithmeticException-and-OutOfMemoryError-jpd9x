public class UncommonErrorSolution {
    public static void main(String[] args) {
        try {
            int numerator = 10;
            int denominator = 0;

            if(denominator == 0) {
                System.err.println("Cannot divide by zero");
                return;
            }
            int result = numerator / denominator;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.err.println("ArithmeticException caught: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
        }

        //Improved memory management - avoid OutOfMemoryError
        List<byte[]> largeList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            byte[] largeArray = new byte[1024 * 1024]; //1MB
            largeList.add(largeArray);
            if(i % 10000 == 0) { //Process in batches
                largeList.clear(); // Release memory
                System.gc(); //Request garbage collection
            }
        }
        System.out.println("Memory intensive operations completed");
    }
}