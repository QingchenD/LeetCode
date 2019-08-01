import mykotlin.KotLinTestMain;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        KotLinTestMain kotLinTestMain = new KotLinTestMain();
        kotLinTestMain.run();

        System.out.println();
        TestMain testMain = new TestMain();
        testMain.run();
    }
}
