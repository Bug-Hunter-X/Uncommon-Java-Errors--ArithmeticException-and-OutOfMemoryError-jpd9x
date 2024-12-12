public class UncommonErrorExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // Potential ArithmeticException
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.err.println("ArithmeticException caught: " + e.getMessage());
            // Additional handling or logging
        } catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
        }
        // Out of memory issues
        List<byte[]> largeList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            byte[] largeArray = new byte[1024 * 1024]; //1MB
            largeList.add(largeArray);
        }
        System.out.println("Memory intensive operations completed");
    }
}