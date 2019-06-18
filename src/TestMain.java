public class TestMain {
    public void run() {
        System.out.println("TestMain");
//
//        EvalRPN evalRPN = new EvalRPN();
//        String[] tokens =  {"2", "1", "+", "3", "*"};
//        System.out.println(evalRPN.evalRPN(tokens));
//
//        String[] tokens2 =  {"4", "13", "5", "/", "+"};
//        System.out.println(evalRPN.evalRPN(tokens2));
//
//        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
//        System.out.println(evalRPN.evalRPN(tokens3));
//
//        String[] tokens4 = {"4", "3", "-"};
//        System.out.println(evalRPN.evalRPN(tokens4));
//
//        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
//        System.out.println(circularDeque.insertLast(1));			        // 返回 true
//        System.out.println(circularDeque.insertLast(2));			        // 返回 true
//        System.out.println(circularDeque.insertFront(3));			        // 返回 true
//        System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
//        System.out.println(circularDeque.getRear());  				// 返回 2
//        System.out.println(circularDeque.isFull());				        // 返回 true
//        System.out.println(circularDeque.deleteLast());			        // 返回 true
//        System.out.println(circularDeque.insertFront(4));			        // 返回 true
//        System.out.println(circularDeque.getFront());				// 返回 4
//
//        System.out.println("*******");
//        circularDeque = new MyCircularDeque(5); // 设置容量大小为3
//        System.out.println(circularDeque.insertFront(7));			        // 返回 true
//        System.out.println(circularDeque.insertLast(0));			        // 返回 true
//        System.out.println(circularDeque.getFront());			        // 返回 true
//        System.out.println(circularDeque.insertLast(3));			        // 已经满了，返回 false
//        System.out.println(circularDeque.getFront());  				// 返回 2
//        System.out.println(circularDeque.insertFront(9));				        // 返回 true
//        System.out.println(circularDeque.getRear());			        // 返回 true
//        System.out.println(circularDeque.getFront());			        // 返回 true
//        System.out.println(circularDeque.getFront());
//        System.out.println(circularDeque.deleteLast());
//        System.out.println(circularDeque.getRear());

//        ReverseWords rw = new ReverseWords();
//        String s = "the sky is blue";
//        System.out.println(rw.reverseWords(s));
//
//        String s1 = "  hello world!  ";
//        System.out.println(rw.reverseWords(s1));
//
//        String s2 = "a good   example";
//        System.out.println(rw.reverseWords(s2));


//        IsValidBST isValidBST = new IsValidBST();
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(6);
//
//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;
//        System.out.println(isValidBST.isValidBST(node1));
//
//
//        Integer i1 = 100;
//        Integer i2 = 100;
//        Integer i3 = 200;
//        Integer i4 = 200;
//
//        System.out.println(i1 == i2);
//        System.out.println(i3 == 200);

//        NumIslands nl = new NumIslands();
//        char[][] grid = {{'1', '1', '1', '1', '0'},
//                         {'1', '1', '0', '1', '0'},
//                         {'1', '1', '0', '0', '0'},
//                         {'0', '0', '0', '0', '0'}};
//
//        System.out.println(nl.numIslands(grid));

        DuplicateZeros dz = new DuplicateZeros();
        int[] numbs = {1,0,2,3,0,4,5,0};
        dz.duplicateZeros(numbs);
        for (int i : numbs) {
            System.out.print(i + " ");
        }

        System.out.println("\n******* ");
        int[] numbs2 = {1,0,2,3};
        dz.duplicateZeros(numbs2);
        for (int i : numbs2) {
            System.out.print(i + " ");
        }

        System.out.println("\n******* ");
        int[] numbs3 = {1,2,3,0};
        dz.duplicateZeros(numbs3);
        for (int i : numbs3) {
            System.out.print(i + " ");
        }

        System.out.println("\n******* ");
        int[] numbs4 = {1,2,0,3};
        dz.duplicateZeros(numbs4);
        for (int i : numbs4) {
            System.out.print(i + " ");
        }

        System.out.println("\n******* ");
        int[] numbs5 = {0,0,0,0,0,0,0};
        dz.duplicateZeros(numbs5);
        for (int i : numbs5) {
            System.out.print(i + " ");
        }

        System.out.println("\n******* ");
        int[] numbs6 =  {8,4,5,0,0,0,0,7};
        dz.duplicateZeros(numbs6);
        for (int i : numbs6) {
            System.out.print(i + " ");
        }

    }
}
