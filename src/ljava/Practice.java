package ljava;

public class Practice {
    public void practice(int x) {
        System.out.print("x:" + x +" ");
        int count = 0;
        while(x != 1) {
            if (x % 2 ==0) x /= 2;
            else x = 3 * x + 1;

            count ++;
            System.out.print("count:" + count + "-x:" + x + " ");
        }

        System.out.println("");
    }


    public long runTime() {
        int i ;
        long n = 1000000000;
        double fa;
        long start = System.currentTimeMillis();
        for (int j = 0; j < n; j++) {
            fa = Math.sqrt(10.0);
        }

        long cost = System.currentTimeMillis() - start;
        return cost;
    }

    public long runTime2() {
        int i ;
        long n = 100000 * 2;
        double fa;
        long start = System.currentTimeMillis();
        for (int j = 0; j < n; j++) {
            for (int k = 0; k <n ; k++) {
                fa = Math.sqrt(10.0);
            }
        }

        long cost = System.currentTimeMillis() - start;
        return cost;
    }


    public long modeTime() {
        long i = 0;
        long n = 100000;
        long start = System.currentTimeMillis();
        for (int j = 0; j < n; j++) {
            for (int k = 0; k <n ; k++) {
                i = n % 100;
                i = n % 101;
                i = n % 102;
                i = n % 103;
                i = n % 104;
                i = n % 105;
                i = n % 106;
                i = n % 107;
                i = n % 108;
                i = n % 108;
                i = n % 109;
/*
                i = n % 110;
                i = n % 111;
                i = n % 112;
                i = n % 113;
                i = n % 114;
                i = n % 115;
                i = n % 116;
                i = n % 117;
                i = n % 118;
                i = n % 118;
                i = n % 119;

                i = n % 120;
                i = n % 121;
                i = n % 122;
                i = n % 123;
                i = n % 124;
                i = n % 125;
                i = n % 126;
                i = n % 127;
                i = n % 128;
                i = n % 129;
                i = n % 130;

                i = n % 120;
                i = n % 121;
                i = n % 122;
                i = n % 123;
                i = n % 124;
                i = n % 125;
                i = n % 126;
                i = n % 127;
                i = n % 128;
                i = n % 129;
                i = n % 130;

                i = n % 120;
                i = n % 121;
                i = n % 122;
                i = n % 123;
                i = n % 124;
                i = n % 125;
                i = n % 126;
                i = n % 127;
                i = n % 128;
                i = n % 129;
                i = n % 130;*/
            }
        }

        long cost = System.currentTimeMillis() - start;
        return cost;
    }

    public long logicTime() {
        long i = 0;
        long n = 100000;
        long start = System.currentTimeMillis();
        for (int j = 0; j < n; j++) {
            for (int k = 0; k <n ; k++) {
                if (i >= 0) ;
                if (i >= 1) ;
                if (i >= 2) ;
                if (i >= 3) ;
                if (i >= 4) ;
                if (i >= 5) ;
                if (i >= 6) ;
                if (i >= 7) ;
                if (i >= 8) ;
                if (i >= 9) ;
/*
                if (i >= 10) ;
                if (i >= 11) ;
                if (i >= 12) ;
                if (i >= 13) ;
                if (i >= 14) ;
                if (i >= 15) ;
                if (i >= 16) ;
                if (i >= 17) ;
                if (i >= 18) ;
                if (i >= 19) ;

                if (i >= 20) ;
                if (i >= 21) ;
                if (i >= 22) ;
                if (i >= 23) ;
                if (i >= 24) ;
                if (i >= 25) ;
                if (i >= 26) ;
                if (i >= 27) ;
                if (i >= 28) ;
                if (i >= 29) ;

                if (i >= 20) ;
                if (i >= 21) ;
                if (i >= 22) ;
                if (i >= 23) ;
                if (i >= 24) ;
                if (i >= 25) ;
                if (i >= 26) ;
                if (i >= 27) ;
                if (i >= 28) ;
                if (i >= 29) ;

                if (i >= 20) ;
                if (i >= 21) ;
                if (i >= 22) ;
                if (i >= 23) ;
                if (i >= 24) ;
                if (i >= 25) ;
                if (i >= 26) ;
                if (i >= 27) ;
                if (i >= 28) ;
                if (i >= 29) ;
                */
            }
        }

        long cost = System.currentTimeMillis() - start;
        return cost;
    }

}
