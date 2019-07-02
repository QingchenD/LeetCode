import com.sun.org.apache.bcel.internal.classfile.Code;
import jdk.internal.org.objectweb.asm.tree.FieldInsnNode;
import sun.reflect.generics.tree.Tree;
import sun.security.provider.Sun;

import java.util.*;

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

//        DuplicateZeros dz = new DuplicateZeros();
//        int[] numbs = {1,0,2,3,0,4,5,0};
//        dz.duplicateZeros(numbs);
//        for (int i : numbs) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println("\n******* ");
//        int[] numbs2 = {1,0,2,3};
//        dz.duplicateZeros(numbs2);
//        for (int i : numbs2) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println("\n******* ");
//        int[] numbs3 = {1,2,3,0};
//        dz.duplicateZeros(numbs3);
//        for (int i : numbs3) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println("\n******* ");
//        int[] numbs4 = {1,2,0,3};
//        dz.duplicateZeros(numbs4);
//        for (int i : numbs4) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println("\n******* ");
//        int[] numbs5 = {0,0,0,0,0,0,0};
//        dz.duplicateZeros(numbs5);
//        for (int i : numbs5) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println("\n******* ");
//        int[] numbs6 =  {8,4,5,0,0,0,0,7};
//        dz.duplicateZeros(numbs6);
//        for (int i : numbs6) {
//            System.out.print(i + " ");
//        }

//        ValidSudoku vs = new ValidSudoku();
//        char[][] shudu = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };
//        System.out.println(vs.isValidSudoku(shudu) + " shudu ");

//        RegularExpression re = new RegularExpression();
//        System.out.println(re.isMatch("aa", "a*"));

//        SearchRange sr = new SearchRange();
//        int[] numbs = {5,7,7,8,8,10};
//        int[] res = sr.searchRange(numbs, 8); //target = 8
//        for(int i : res) {
//            System.out.print(i + " ");
//        }

//        CombinationSum cs = new CombinationSum();
//        int [] candidates = {2,3,6,7};
//        int target = 7;
//        List<List<Integer>> result = cs.combinationSum(candidates, target);
//        for (List<Integer> list : result) {
//            for (Integer i : list) {
//                System.out.print(i + " ");
//            }
//            System.out.println("");
//        }
//
//        int [] candidates1 = {2,3,5};
//        target = 8;
//        List<List<Integer>> result1 = cs.combinationSum(candidates1, target);
//        for (List<Integer> list : result1) {
//            for (Integer i : list) {
//                System.out.print(i + " ");
//            }
//            System.out.println("");
//        }

//        String[] strs =  {"eat", "tea", "tan", "ate", "nat", "bat"};
//        GroupAnagrams ga = new GroupAnagrams();
//        List<List<String>> rst = ga.groupAnagrams(strs);
//        for (List<String> list : rst) {
//            for (String s : list) {
//                System.out.print(s + " ");
//            }
//            System.out.println("");
//        }

//        LargestRectangleArea lra = new LargestRectangleArea();
//        int[] heights = {2,1,5,6,2,3};
//        System.out.println(lra.largestRectangleArea(heights));
//
//        int[] heights1 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
//        System.out.println(lra.largestRectangleArea(heights1));
//
//        int[] h = {9046155,17522430,44186957,40374643,77652689,89027934,97586333,68834337,62979669,1783127,29339118,83907628,48067922,22843915,11027247,73603247,32376863,12448072,7086475,2369889,5064817,88893600,61558880,77108330,32113014,21324782,28294417,18403046,39022240,58687324,80978280,584748,76209754,25165237,40959391,6378795,66709524,38545724,75213133,29689193,92845203,4552251,13596821,40913125,27396166,24624068,67032725,12289382,89588493,74119200,14659271,94653310,15529152,28734503,24277993,47642166,50059286,52572410,18561565,89081526,11259734,99539845,42182626,39985840,24705083,83142017,46364635,43930959,74204093,74094120,73620152,67049296,31162724,87216973,7962422,58558890,64357394,27511499,23364624,53945887,1630699,38023896,1115549,69676203,66758399,25393542,17318370,16817685,30482304,88396287,58415564,94258390,87936132,598190,34244230,65157567,36256560,80608866,9088526,10460653,7219338,82708678,77509950,38382062,22442004,37988724,49457305,39315750,65500223,72821929,93261637,19647274,63362177,46893538,89323477,30120577,24803433,59158199,99454614,55285737,47554486,10386530,2060480,88006971,63501073,36304710,53164538,99757633,69429928,14769417,62734638,76649267,49994447,40244588,15031329,24952803,30749664,64488634,64268553,48766239,89826916,10046542,68413513,53189093,56940081,10253343,83309670,81743514,69411542,35280637,89545603,69482381,98183519,91606083,57489352,61684592,27910794,63170242,13958577,49857074,30456011,76693216,26506341,80450459,69454156,94054023,5403262,52720173,11059009,22188168,1486412,885925,32234710,22416278,54075019,89174791,32669621,89901041,23434657,54597515,77698030,65496613,24079896,75881550,57102696,34085600,90082494,37529842,97255843,4041072,87386917,27711854,33250640,66409610,60678665,2704796,60463633,18598280,7941321,24038995,40786448,9427734,24924920,73021158,31844012,31516291,14712302,17029985,21417333,38146959,71627500,99115363,56159924,48223749,27513265,13262621,82309349,17595760,50792463,32081544,74153184,90695732,12309751,7403824,57105343,72988416,62624972,70085328,91586696,70566294,94124323,32373144,32510380,71565596,57910655,16870744,3081887,72622957,33900729,24499220,63286268,5528229,76130936,19446193,6268330,56160553,85225166,88577680,73756313,36017629,20659224,425849,79229714,32968975,60346025,88851409,58473744,22970998,58936737,50060440,46053644,5577413,34949937,31080376,77143009,92860592,47951120,80224896,65483549,81851849,57240469,81286169,39896430,85887757,732362,46164761,42048310,38473880,87258793,68320976,74491510,7918017,68746825,6237576,93403345,29092851,95088985,51877089,4580201,6542074,54453881,3150197,12119487,89403818,34230573,89262496,82264410,34698045,22003745,264311,16549894,31760566,81550481,8962676,70164675,34799195,7643789,64729337,73273076,94902582,85566665,280938,2820600,6829843,59034866,48740297,88439046,54123851,617386,45535599,60665925,7587619,48685796,72785413,96991438,35432721,14564261,31772200,70130766,89084358,32036512,39197012,73361276,66103345,48159688,96042303,53418892,55803478,13287993,26691968,3222412,98854658,79489258,6043012,5684501,38524124,7299661,94123547,45164327,60433399,39659146,5830253,68021019,40861294,31132018,65012457,76294015,98212631,96784657,98941133,39813342,81337521,38138145,65690970,47440866,38814186,61733274,53376111,47134016,75021267,32584431,50356428,26392277,12073690,8915793,32076779,3114166,16215454,78716678,794846,76648854,70892177,6625099,44669873,64269823,90273469,62198682,93080191,41002452,11499691,92021324,80815794,92837213,82675822,46506765,92794431,21490008,60756391,46170542,68624024,88294010,78754974,18980452,14686287,43345016,80412597,99279418,98975534,96628052,77996097,99770380,73276906,1404626,58911831,70463131,65674449,49185300,32661813,58754640,42704105,44161504,3292317,23519899,89515069,85968139,22543016,82309501,7458147,35815759,80996395,28598523,24109769,12267721,95327,91312409,8129089,80507925,90591827,7104624,77135977,21104276,59391356,2929235,22508902,18303188,73392366,40699704,20004840,6054179,51970696,62708945,2732035,55263013,38745197,92247105,93747504,13804565,27072958,53722003,2136677,8069353,82320526,26246446,72853427,82415854,70075207,80982516,15440131,60667035,40603492,45092460,81771311,99994849,48021695,56796566,70814389,21414061,50012622,43335581,79984592,1983318,6044527,35232979,9762684,97306076,27480084,3510188,63626993,7069394,57232192,65763670,15138748,92069070,44526469,40508527,27001276,14601676,21491043,42441407,75268711,14610888,40050219,9556375,67122089,88071914,66352941,37936478,62002327,16365563,81272059,94503271,70865233,39832938,29736251,33144269,37139014,9732687,89170810,53282360,16802082,46403002,19046030,84457182,90988424,63572499,24965709,17989701,30690528,98973104,12947460,5959239,13583992,52997680,68031966,80706081,93585946,34384907,71158911,8104626,3266822,52430971,2607897,26648408,44780261,32344148,59792677,34435628,42076836,48963487,87717988,11395270,47882841,59280370,95852452,91387618,75369222,20818161,61893671,6059750,19791265,74841131,64535341,85891610,80355163,32567308,19114043,26457462,19468567,42789307,34562088,75251742,95220278,37169985,1900150,92516891,22030486,14209179,26952519,16623674,15689019,67186859,28018944,63571860,26467230,23871396,54959478,1836452,97205909,16853149,60412554,69513526,44210633,24947895,55405136,77082148,10031555,27035532,56055962,82016475,69824839,90618050,57268217,17561469,80304388,11684719,10078360,2334874,78410250,89547232,71474900,94099269,56734091,99493844,10187482,35717673,23365240,65146960,37554125,73087501,34516462,50483031,42601027,31243447,27947279,50522516,60841947,37978834,77558048,16897910,19995309,47382887,60032312,29779878,17460708,40336700,93980949,80055420,95187926,72391200,69602652,66662826,19006821,78853096,66156670,29194303,14570769,42038262,46857616,4641247,15125763,33890430,55124278,57726791,65133877,83071557,8249307,78492176,73566744,38323707,95390086,46078405,38222946,55422399,75858284,55683654,95759099,22355585,35739074,43463378,47263137,57858079,10126204,66269959,89227527,76282875,47980614,3798296,70837489,94838230,60955895,85963253,28728660,68596526,96206396,46378889,4184435,56972055,24871066,77751179,95295762,20261152,76345937,33518708,28199903,4720573,89202362,76475355,27076158,77457788,19938733,26855648,87832219,30064937,93125607,77059746,58864164,41106221,33374395,82218006,88460804,94330290,68181259,69705816,15443168,16904007,16084706,19627604,73876062,93472124,49895135,69171824,66249628,26241072,2690532,94449532,83477997,44409246,23441239,10554156,74383386,43379972,37409804,14731958,25961261,83051763,91791704,37341778,76674336,77682451,19559784,65135140,72012742,40257395,34840957,39972262,57161402,3442015,12116218,31037464,96914139,62011354,52725640,63163767,40768778,55416172,10129651,24246776,52341770,33570890,87317284,26725156,29467214,77243440,41457114,55428476,60295203,85765171,45286606,36969539,63447622,64846390,54621032,87976716,57620137,41978341,27948979,14781539,45420356,40065197,98335355,94850847,54592903,51060995,58014614,47878034,58993519,20660618,72124810,11335289,54231508,11958446,90576797,83698723,89201886,84550264,91643551,2013441,22831787,36930157,38982980,86279409,54292899,46120364,26772478,11913036,40615057,7237809,79210927,38551765,99819358,77546282,33402612,54412262,81123629,43933579,2290296,40117148,64594197,26931458,3968789,18825705,38889904,94545586,55040780,80608142,31612202,46684331,82621583,54443989,83614488,74120915,40723399,90423739,20241280,20012229,2336775,60856337,27250038,34064054,99408103,27069396,11610336,85327067,33998010,45250317,29260646,88804658,85367465,46371195,15736116,89336254,17713253,7142372,36398193,72754033,87750514,68010395,19438365,70372097,22454385,3052853,44493013,15694136,93476593,17250645,35706365,48329720,30623334,15472755,82393775,82547789,95058503,46520463,20391209,29056514,91770781,2168207,70377524,29654598,48539403,38629993,71507205,66252656,45772365,7905398,39006689,86039232,75915793,58445054,8927681,98370178,14014260,5937046,66580666,60007205,75704043,2287031,60853277,6327378,70276138,95763404,41391519,65334642,42283868,61782728,46907508,86571001,63950936,17285032,68741951,12490339,55915025,40249156,31259347,54203743,670906,70266036,92759327,76586700,81227443,1687008,27473230,47758055,7624055,94053897,60281612,35844450,48857280,21134889,42171828,71649771,69414646,36079700,36984413,64214866,97862428,36408273,3302219,61813364,6209657,72044170,26820055,14641035,64809679,58079402,68844778,65480585,80861791,61604105,94583637,14605586,15807465,22056868,62363641,75947872,68627117,75161605,11792323,70000749,96296494,6480503,41650520,18227492,42560203,31151285,82442358,40422632,67559558,85744577,54752348,26285568,10305100,81572404,40926603,75114779,92168158,62287733,40595364,73029949,76408190,35179002,87635535,92215655,9752222,2515528,68163528,78379339,77677133,32472203,48380088,26489980,38952706,90030609,44717472,81512910,73698246,27159831,74451894,41257805,65420760};
//        System.out.println(lra.largestRectangleArea(h));
//
//        int[] h1 = {5,7,8,1,1,4,4,6,5,0,2};
//        System.out.println(lra.largestRectangleArea(h1));

//        MaximalRectangle mr = new MaximalRectangle();
//        char [][] matrix = {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}};
//
//        System.out.println(mr.maximalRectangle(matrix));

//        MinPathSum mps = new MinPathSum();
//        int[][] grid = {
//                {1,3,1},
//                {1,5,1},
//                {4,2,1}};
//        System.out.println(mps.minPathSum(grid));

//        WordBreak wb = new WordBreak();
//        String s = "leetcode";
//        List<String> words = new ArrayList<>();
//        words.add("leet");
//        words.add("code"); //, "code"]
//        System.out.println(wb.wordBreak(s, words));

//        String s = "catsandog";
//        List<String> words = new ArrayList<>();
//        words.add("cats");
//        words.add("dog");
//        words.add("sand");
//        words.add("and");
//        words.add("cat");
//        System.out.println(wb.wordBreak(s, words));
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//
//        String[] ws = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa",
//        "aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
//        ArrayList<String> words = new ArrayList<>();
//        for (String str : ws) {
//            words.add(str);
//        }
//        long startMs = System.currentTimeMillis();
//        System.out.println(wb.wordBreak(s, words));
//        long endMs = System.currentTimeMillis();
//        System.out.println(" mordMatch need:" + (endMs - startMs) + " ms");

//        MissingNumber mn = new MissingNumber();
//        int[] nums = {9,6,4,2,3,5,7,0,1};
//        System.out.println(mn.missingNumber(nums));

       /* Rob rob = new Rob();
        int[] numbs = {1,2,3,1};
        System.out.println(rob.rob(numbs));

        int[] numbs2 = {2,7,9,3,1};
        System.out.println(rob.rob(numbs2));*/
//
//       PalindromeList pdl = new PalindromeList();
//       ListNode node1 = new ListNode(1);
//       ListNode node2 = new ListNode(2);
//       node1.next = node2;
//       System.out.println(pdl.isPalindrome(node1));
//
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(2);
//        ListNode n4 = new ListNode(1);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        System.out.println(pdl.isPalindrome(n1));

//        TopKFrequent tf = new TopKFrequent();
//        int[] numbs = {1,1,1,2,2,3};
//        int k = 2;
//        List<Integer> rst = tf.topKFrequent(numbs, 2);
//        for (Integer i : rst) {
//            System.out.print(i + " ");
//        }

//        FindTargetSumWays fts = new FindTargetSumWays();
//        int[] nums = {1, 1, 1, 1, 1};
//        System.out.println(fts.findTargetSumWays(nums, 3));

//        FindUnsortedSubarray fus = new FindUnsortedSubarray();
//        int[] nums =  {2, 6, 4, 8, 10, 9, 15};
//        System.out.println(fus.findUnsortedSubarray(nums));

//        int[] nums2 =  {2, 1};
//        System.out.println(fus.findUnsortedSubarray(nums2));
//
//        int[] nums3 =  {5, 4, 3, 2, 1};
//        System.out.println(fus.findUnsortedSubarray(nums3));
//
//        int[] nums4 =  {1, 2, 3, 3, 3};
//        System.out.println(fus.findUnsortedSubarray(nums4));

//        DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(5);
//        n1.left = n2; n1.right = n3;
//        n2.left = n4; n2.right = n5;
//
//        System.out.println(dbt.diameterOfBinaryTree(n1));

//        MergeTrees mt = new MergeTrees();
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(3);
//        TreeNode t3 = new TreeNode(2);
//        TreeNode t4 = new TreeNode(5);
//        t1.left = t2; t1.right = t3;
//        t2.left = t4;
//
//        TreeNode n1 = new TreeNode(2);
//        TreeNode n2 = new TreeNode(1);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(7);
//        n1.left = n2; n1.right = n3;
//        n2.right = n4;
//        n3.right = n5;
//
//        TreeNode rst = mt.mergeTrees(t1, n1);
//        System.out.println(" rst.val:" + rst.val);

//        FindDisappearedNumbers fdn = new FindDisappearedNumbers();
//        int[] nums = {4,3,2,7,8,2,3,1};
//        List<Integer> rst = fdn.findDisappearedNumbers(nums);
//        for (Integer i : rst) {
//            System.out.print(i + " ");
//        }

//        CountBits cb = new CountBits();
//        int[] rst = cb.countBits(5);
//        for (int i : rst) {
//            System.out.print(i + " ");
//        }
//        SearchMatrix sm = new SearchMatrix();
//        int[][] matrix = {  {1, 2, 3, 4, 5},
//                            {6, 7, 8, 9, 10},
//                            {11,12,13,14,15},
//                            {16,17,18,19,20},
//                            {21,22,23,24,25}};
//        System.out.println(sm.searchMatrix(matrix, 15));

//        int[][] matrix1 = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
//        System.out.println(sm.searchMatrix(matrix1, 20));

//        FindAnagrams fa = new FindAnagrams();
//        List<Integer> rst = fa.findAnagrams("cbaebabacd", "abc");
//        for (int i : rst) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        rst = fa.findAnagrams("abab", "ab");
//        for (int i : rst) {
//            System.out.print(i + " ");
//        }
//
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String p = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//
//        System.out.println("");
//        rst = fa.findAnagrams(s, p);
//        for (int i : rst) {
//            System.out.print(i + " ");
//        }

//        SubarraySum ss = new SubarraySum();
//        int[] nums = {1, 2, 1, 2, 1};
//        System.out.println(ss.subarraySum(nums,3));

//        LengthOfLIS l = new LengthOfLIS();
//        int[] nums =  {10,9,2,5,3,7,101,1, 2, 3, 4, 5};
//        System.out.println(l.lengthOfLIS(nums));
//
//        nums = new int[]{10,9,2,5,3,4};
//        System.out.println(l.lengthOfLIS(nums));
//
//        nums = new int[]{4,10,4,3,8,9};
//        System.out.println(l.lengthOfLIS(nums));
//
//        nums = new int[] {1,3,6,7,9,4,10,5,6};
//        System.out.println(l.lengthOfLIS(nums));

//        CountSubstrings cs = new CountSubstrings();/
//        System.out.println(cs.countSubstrings("abc"));
//        System.out.println(cs.countSubstrings("aaa"));

//        SetZeroes sz = new SetZeroes();
//        int[][] matrix = new int[][] {
//            {1,1,1},
//            {1,0,1},
//            {1,1,1}
//        };
//        sz.setZeroes(matrix);
//
//        for (int[] ints : matrix) {
//            for (int i : ints) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//
//        matrix = new int[][] {
//                {0,1,2,0},
//                {3,4,5,2},
//                {1,3,1,5}
//        };
//        sz.setZeroes(matrix);
//
//        for (int[] ints : matrix) {
//            for (int i : ints) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

//        matrix = new int[][] {
//                {0,1,2,0},
//                {3,4,5,2},
//                {1,0,1,5}
//        };
//        sz.setZeroes(matrix);
//
//        for (int[] ints : matrix) {
//            for (int i : ints) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

//        matrix = new int[][] {
//                {1,1,1},
//                {0,1,2}
//        };
//
//        sz.setZeroes(matrix);
//
//        for (int[] ints : matrix) {
//            for (int i : ints) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

//        Flatten flatten = new Flatten();
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(5);
//        TreeNode n4 = new TreeNode(3);
//        TreeNode n5 = new TreeNode(4);
//        TreeNode n6 = new TreeNode(6);
//        n1.left = n2; n1.right = n3;
//        n2.left = n4; n2.right = n5;
//        n3.right = n6;
//
//        flatten.flatten(n1);
//        TreeNode n = n1;
//        while (n != null) {
//            System.out.print(n.val + " " + " left is null:" + (n.left == null) + " | ");
//            n = n.right;
//        }

//        FindPeakElement fpe = new FindPeakElement();
//        int[] nums = new int[] {1,2,3,1};
//        System.out.println(fpe.findPeakElement(nums));
//
//        nums = new int[] {1,2,1,3,5,6,4};
//        System.out.println(fpe.findPeakElement(nums));

//        FractionToDecimal ftd = new FractionToDecimal();
//        System.out.println(ftd.fractionToDecimal(1, 2));
//        System.out.println(ftd.fractionToDecimal(2, 1));
//        System.out.println(ftd.fractionToDecimal(2, 3));
//        System.out.println(ftd.fractionToDecimal(1, 6));
//        System.out.println(ftd.fractionToDecimal(1, 7));
//        System.out.println(ftd.fractionToDecimal(1, 11));
//        System.out.println(ftd.fractionToDecimal(1, 17));
//        System.out.println(ftd.fractionToDecimal(-50, 8));
//        System.out.println(ftd.fractionToDecimal(-1, -2147483648));

//        GetSum gs = new GetSum();
//        System.out.println(gs.getSum(1,2));
//        System.out.println(gs.getSum(-2,3));

//        ShortestPathBinaryMatrix spbm = new ShortestPathBinaryMatrix();
//        int[][] matrix = new int[][] {{0,0,0},{1,1,0},{1,1,0}};
//        System.out.println(spbm.shortestPathBinaryMatrix(matrix));
//
//        matrix = new int[][] {{0,0,1,0},{1,0,1,0},{1,1,0,1},{0,0,0,0}};
//        System.out.println(spbm.shortestPathBinaryMatrix(matrix));
//
//        matrix = new int[][]{{0,0,0,0,1},{1,0,0,0,0},{0,1,0,1,0},{0,0,0,1,1},{0,0,0,1,0}};
//        System.out.println(spbm.shortestPathBinaryMatrix(matrix));

//        SumOfDigits sd = new SumOfDigits();
//        int[] nums = {34,23,1,24,75,33,54,8};
//        System.out.println(sd.sumOfDigits(nums));
//
//        int[] nums1 = {99,77,33,66,55};
//        System.out.println(sd.sumOfDigits(nums1));

//        HighFive hf = new HighFive();
//        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
//        int[][] rst = hf.highFive(items);
//        for (int[] score : rst) {
//            System.out.println("[" + score[0] + "," + score[1] + "]");
//        }

//        ConfusingNumberII cn = new ConfusingNumberII();
//        System.out.println(cn.confusingNumberII(20));
//        System.out.println(cn.confusingNumberII(100));
//        long startMs = System.currentTimeMillis();
//        System.out.println(cn.confusingNumberII(1000000000));
//        long endMs = System.currentTimeMillis();
//        System.out.println(1000000000 + " need ms:" + (endMs - startMs));

//        MedianFinder obj = new MedianFinder();
//        obj.addNum(2);
//        System.out.println(obj.findMedian());
//        obj.addNum(5);
//        System.out.println(obj.findMedian());
//        obj.addNum(3);
//        System.out.println(obj.findMedian());
//        obj.addNum(1);
//        System.out.println(obj.findMedian());
//        obj.addNum(9);
//        System.out.println(obj.findMedian());
//        obj.addNum(0);
//        System.out.println(obj.findMedian());
//        obj.addNum(4);
//        System.out.println(obj.findMedian());

//        CoinChange cc = new CoinChange();
//        int[] coins = {1, 2, 5};
//        int amount = 11;
//        System.out.println(cc.coinChange(coins, amount));

//        coins = new int[]{2};
//        System.out.println(cc.coinChange(coins, 3));

//        coins = new int[] {1,2147483647};
//        System.out.println(cc.coinChange(coins, 2));

//        coins = new int[] {1};
//        System.out.println(cc.coinChange(coins, 0));

//        coins = new int[]{1,2147483647};
//        System.out.println(cc.coinChange(coins, 2));

//        long statMs = System.currentTimeMillis();
//        coins = new int[]   {186,419,83,408}; //{1,2, 5}; //
//        System.out.println(cc.coinChange(coins, 6249)); //100));
//        long endMs = System.currentTimeMillis();
//        System.out.println(" use ms: " + (endMs - statMs));

//        FindOcurrences fo = new FindOcurrences();
//        String text = "alice is a good girl she is a good student", first = "a", second = "good";
//        String[] rst = fo.findOcurrences(text,first, second);
//        for (String s : rst) {
//            System.out.print(s + " ");
//        }
//        System.out.println();
//
//        String text1 = "we will  we will   rock you", first1 = "we", second1 = "will";
//        rst = fo.findOcurrences(text1, first1, second1);
//        for (String s : rst) {
//            System.out.print(s + " ");
//        }
//        System.out.println();
//
//        String text2 ="jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa";
//        String first2 = "kcyxdfnoa";
//        String second2 = "jkypmsxd";
//        rst = fo.findOcurrences(text2, first2, second2);
//        for (String s : rst) {
//            System.out.print(s + " ");
//    }

//        ReverseBits rb = new ReverseBits();
//        System.out.println(rb.reverseBits(-3)) ;//(int)4294967293L));

//        RotateArray rotateArray = new RotateArray();
//        int[] array = {1,2,3,4,5,6,7};
//        rotateArray.rotate(array, 3);
//        for (int i : array) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

//        array = new int[]{-1,-100,3,99};
//        rotateArray.rotate(array, 2);
//        for (int i : array) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        array = new int[]{-1};
//        rotateArray.rotate(array, 2);
//        for (int i : array) {
//            System.out.print(i + " ");
//        }
//        NumDecodings nd = new NumDecodings();
//        System.out.println(nd.numDecodings("12"));
//        System.out.println(nd.numDecodings("226"));
//        System.out.println(nd.numDecodings("1122323432562"));
//        System.out.println(nd.numDecodings("0"));
//        System.out.println(nd.numDecodings("10"));
//        System.out.println(nd.numDecodings("101"));

//        Trie trie = new Trie();
//        trie.insert("apple");
//        System.out.println(trie.search("apple"));   // 返回 true
//        System.out.println(trie.search("app"));     // 返回 false
//        System.out.println(trie.startsWith("app")); // 返回 true
//        trie.insert("app");
//        System.out.println(trie.search("app"));     // 返回 true

//        int[] nums = {1,2,3};
//        ShuffleArray sa = new ShuffleArray(nums);
//        int[] rst = sa.shuffle();
//        for (int i : rst) {
//            System.out.print(i + " ");
//        }
//        rst = sa.reset();
//        for (int i : rst) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println();
//        Random random = new Random();
//        for (int i = 0; i < 20; i++) {
//            System.out.print(random.nextInt()  + " ");
//        }
//
//        System.out.println();
//        for (int i = 0; i < 20; i++) {
//            System.out.print(Math.random() + " ");
//        }
//
//        Date date = new Date();
//        date.getTime();
//        System.out.println();
//        for (int i = 0; i < 20; i++) {
//            System.out.print(System.nanoTime()%20 + " ");
//        }
//
//        System.out.println();
//        System.out.println( -1 >> 1);
//        System.out.println( -1 >>> 1);

//        Codec codec = new Codec();
//        String s = "[1,2,3,null,null,4,5]";
//        TreeNode root = codec.deserialize(s);
//        System.out.println(codec.serialize(root));
//
//        s = "[1]";
//        root = codec.deserialize(s);
//        System.out.println(codec.serialize(root));

//        SingleNumberIII singleNumberIII = new SingleNumberIII();
//        int[] nums =  {1,2,1,3,2,5};
//        int[] rst = singleNumberIII.singleNumber(nums);
//        for (int i : rst) {
//            System.out.print(i + " ");
//        }

//        RangeBitwiseAnd rangeBitwiseAnd = new RangeBitwiseAnd();
//        System.out.println(rangeBitwiseAnd.rangeBitwiseAnd(5, 7));
//        System.out.println(rangeBitwiseAnd.rangeBitwiseAnd(0, Integer.MAX_VALUE));
//        System.out.println(rangeBitwiseAnd.rangeBitwiseAnd(1 << 30, Integer.MAX_VALUE));
//        long startms = System.currentTimeMillis();
//        int rst = rangeBitwiseAnd.rangeBitwiseAnd(700000000, 2147483641);
//        long endMs = System.currentTimeMillis();
//        System.out.println("rst:" + rst + " use:" + (endMs - startms));
//
//        System.out.println(rangeBitwiseAnd.rangeBitwiseAnd((1 << 30), (1 << 31) - 1));
//        System.out.println((Integer.MAX_VALUE << 4) & 0xff);
//
//        System.out.println( 5 & (Integer.MAX_VALUE << 2));

//        KthSmallestMatrix ksm = new KthSmallestMatrix();
//        int[][] matrix = new int[][] {
//                        {1,  5,  9},
//                        {10, 11, 13},
//                        {12, 13, 15}
//                        };

        //System.out.println(ksm.kthSmallest(matrix, 8));

//        matrix = new int[][] {
//                {1,  5,  9, 110},
//                {10, 11, 13, 170},
//                {12, 13, 15, 220},
//                {100, 200, 300, 400}
//        };
//
//        System.out.println(ksm.kthSmallest(matrix, 11));

//        GenerateParenthesis gp = new GenerateParenthesis();
//        List<String> rst = gp.generateParenthesis(3);
//        for (String s : rst) {
//            System.out.println(s);
//        }
//        CombinationSum2 cs2 = new CombinationSum2();
//        int[] candidates = {10,1,2,7,6,1,5};
//        int target = 8;
//        List<List<Integer>> rst = cs2.combinationSum2(candidates, target);
//        for (List<Integer> list : rst) {
//            for (Integer i : list) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

//        System.out.println("****************");
//        candidates = new int[]{2,5,2,1,2};
//        List<List<Integer>> rst = cs2.combinationSum2(candidates, 5);
//        for (List<Integer> list : rst) {
//            for (Integer i : list) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

//        PermuteUnique permuteUnique = new PermuteUnique();
//        int[] nums = new int[] {1, 1, 2};
//        List<List<Integer>> rst = permuteUnique.permuteUnique(nums);
//        for (List<Integer> list : rst) {
//            for (Integer i : list) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

//        LeastOpsExpressTarget loe = new LeastOpsExpressTarget();
//        System.out.println(loe.leastOpsExpressTarget(5, 19));
//
//        CanCross cc = new CanCross();
//        int[] stones = {0,1,3,5,6,8,12,17};
//        System.out.println(cc.canCross(stones));
//
//        stones = new int[] {0,1,2,3,4,8,9,11};
//        System.out.println(cc.canCross(stones));
//
//        stones = new int[] {0,2};
//        System.out.println(cc.canCross(stones));

//        stones = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421,422,423,424,425,426,427,428,429,430,431,432,433,434,435,436,437,438,439,440,441,442,443,444,445,446,447,448,449,450,451,452,453,454,455,456,457,458,459,460,461,462,463,464,465,466,467,468,469,470,471,472,473,474,475,476,477,478,479,480,481,482,483,484,485,486,487,488,489,490,491,492,493,494,495,496,497,498,499,500,501,502,503,504,505,506,507,508,509,510,511,512,513,514,515,516,517,518,519,520,521,522,523,524,525,526,527,528,529,530,531,532,533,534,535,536,537,538,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,554,555,556,557,558,559,560,561,562,563,564,565,566,567,568,569,570,571,572,573,574,575,576,577,578,579,580,581,582,583,584,585,586,587,588,589,590,591,592,593,594,595,596,597,598,599,600,601,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,644,645,646,647,648,649,650,651,652,653,654,655,656,657,658,659,660,661,662,663,664,665,666,667,668,669,670,671,672,673,674,675,676,677,678,679,680,681,682,683,684,685,686,687,688,689,690,691,692,693,694,695,696,697,698,699,700,701,702,703,704,705,706,707,708,709,710,711,712,713,714,715,716,717,718,719,720,721,722,723,724,725,726,727,728,729,730,731,732,733,734,735,736,737,738,739,740,741,742,743,744,745,746,747,748,749,750,751,752,753,754,755,756,757,758,759,760,761,762,763,764,765,766,767,768,769,770,771,772,773,774,775,776,777,778,779,780,781,782,783,784,785,786,787,788,789,790,791,792,793,794,795,796,797,798,799,800,801,802,803,804,805,806,807,808,809,810,811,812,813,814,815,816,817,818,819,820,821,822,823,824,825,826,827,828,829,830,831,832,833,834,835,836,837,838,839,840,841,842,843,844,845,846,847,848,849,850,851,852,853,854,855,856,857,858,859,860,861,862,863,864,865,866,867,868,869,870,871,872,873,874,875,876,877,878,879,880,881,882,883,884,885,886,887,888,889,890,891,892,893,894,895,896,897,898,899,900,901,902,903,904,905,906,907,908,909,910,911,912,913,914,915,916,917,918,919,920,921,922,923,924,925,926,927,928,929,930,931,932,933,934,935,936,937,938,939,940,941,942,943,944,945,946,947,948,949,950,951,952,953,954,955,956,957,958,959,960,961,962,963,964,965,966,967,968,969,970,971,972,973,974,975,976,977,978,979,980,981,982,983,984,985,986,987,988,989,990,991,992,993,994,995,996,997,998,99999999};
//        System.out.println(cc.canCross(stones));

//        MyQueue queue = new MyQueue();
//        queue.push(1);
//        queue.push(2);
//        System.out.println(queue.peek());  // 返回 1
//        System.out.println(queue.pop());   // 返回 1
//        System.out.println(queue.empty()); // 返回 false

//        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // 返回 1
//        cache.put(3, 3);    // 去除 key 2
//        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
//        System.out.println(cache.get(3));       // 返回 3
//        cache.put(4, 4);    // 去除 key 1
//        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
//        System.out.println(cache.get(3));       // 返回 3
//        System.out.println(cache.get(4));       // 返回 4

//        LFUCache cache = new LFUCache( 0 /* capacity (缓存容量) */ );
//
//        cache.put(0, 0);
//        System.out.println(cache.get(0));       // 返回 -1

//        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
//
//        cache.put(2, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(2));
//        cache.put(1, 1);
//        cache.put(4, 1);
//        System.out.println(cache.get(2));
//        ["LFUCache","put","put","get","put","put","get"]
//[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]

//        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
//        cache.put(2, 1);
//        cache.put(3, 2);
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(2));
//        cache.put(4, 3);
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));
//        ["LFUCache","put","put","get","get","put","get","get","get"]
//[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]

//        TreeNode root = new TreeNode(7);
//        TreeNode n1 = new TreeNode(3);
//        TreeNode n2 = new TreeNode(15);
//        TreeNode n3 = new TreeNode(9);
//        TreeNode n4 = new TreeNode(20);
//        root.left = n1; root.right = n2;
//        n2.left = n3; n2.right = n4;
//        BSTIterator iterator = new BSTIterator(root);
//        System.out.println(iterator.next());    // 返回 3
//        System.out.println(iterator.next());    // 返回 7
//        System.out.println(iterator.hasNext()); // 返回 true
//        System.out.println(iterator.next());    // 返回 9
//        System.out.println(iterator.hasNext()); // 返回 true
//        System.out.println(iterator.next());    // 返回 15
//        System.out.println(iterator.hasNext()); // 返回 true
//        System.out.println(iterator.next());    // 返回 20
//        System.out.println(iterator.hasNext()); // 返回 false

//        List<Integer> nums = new ArrayList<>() ;//{1, 2, 3};
//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//        PeekingIterator pi = new PeekingIterator(nums.iterator());
//        System.out.println(pi.next());
//        System.out.println(pi.peek());
//        System.out.println(pi.next());
//        System.out.println(pi.next());
//        System.out.println(pi.hasNext());

//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//        nums.add(4);
//
//        PeekingIterator pi = new PeekingIterator(nums.iterator());
//        System.out.println(pi.hasNext());
//        System.out.println(pi.peek());
//        System.out.println(pi.peek());
//        System.out.println(pi.next());
//        System.out.println(pi.next());
//        System.out.println(pi.peek());
//        System.out.println(pi.peek());
//        System.out.println(pi.next());
//        System.out.println(pi.hasNext());
//        System.out.println(pi.peek());
//        System.out.println(pi.hasNext());
//        System.out.println(pi.next());
//        System.out.println(pi.hasNext());

//        Twitter twitter = new Twitter();
//
//        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//        twitter.postTweet(1, 5);
//        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        List<Integer> rst = twitter.getNewsFeed(1);
//        System.out.println("User:" + 1 + " messages:");
//        for (Integer i : rst) {
//            System.out.print("" + i + " ");
//        }
//        System.out.println();
//        // 用户1关注了用户2.
//        twitter.follow(1, 2);
//        // 用户2发送了一个新推文 (推文id = 6).
//        twitter.postTweet(2, 6);
//
//        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
//        rst = twitter.getNewsFeed(1);
//        System.out.println("User:" + 1 + " messages:");
//        for (Integer i : rst) {
//            System.out.print("" + i + " ");
//        }
//        System.out.println();
//
//        // 用户1取消关注了用户2.
//        twitter.unfollow(1, 2);
//
//        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        // 因为用户1已经不再关注用户2.
//        rst = twitter.getNewsFeed(1);
//        System.out.println("User:" + 1 + " messages:");
//        for (Integer i : rst) {
//            System.out.print("" + i + " ");
//        }
//        System.out.println();

//        Twitter twitter = new Twitter();
//
//        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//        twitter.postTweet(1, 1);
//        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        List<Integer> rst = twitter.getNewsFeed(1);
//        System.out.println("User:" + 1 + " messages:");
//        for (Integer i : rst) {
//            System.out.print("" + i + " ");
//        }
//        System.out.println();
//        // 用户1关注了用户2.
//        twitter.follow(2, 1);
//        rst = twitter.getNewsFeed(2);
//        System.out.println("User:" + 1 + " messages:");
//        for (Integer i : rst) {
//            System.out.print("" + i + " ");
//        }
//        System.out.println();
//
//        twitter.unfollow(2,1);
//        rst = twitter.getNewsFeed(2);
//        System.out.println("User:" + 1 + " messages:");
//        for (Integer i : rst) {
//            System.out.print("" + i + " ");
//        }
//        System.out.println();

//        Twitter twitter = new Twitter();
//        twitter.follow(1, 5);
//        List<Integer> rst = twitter.getNewsFeed(1);
//        System.out.println("User:" + 1 + " messages:");
//        for (Integer i : rst) {
//            System.out.print("" + i + " ");
//        }
//        System.out.println();

//        Twitter twitter = new Twitter();
//        twitter.postTweet(1, 5);
//        twitter.follow(1, 1);
//        List<Integer> rst = twitter.getNewsFeed(1);
//        System.out.println("User:" + 1 + " messages:");
//        for (Integer i : rst) {
//            System.out.print("" + i + " ");
//        }
//        System.out.println();

//        Twitter twitter = new Twitter();
//        twitter.postTweet(1, 4);
//        twitter.postTweet(2, 5);
//        twitter.unfollow(1, 2);
//        twitter.follow(1, 2);
//        List<Integer> rst = twitter.getNewsFeed(1);
//        System.out.println("User:" + 1 + " messages:");
//        for (Integer i : rst) {
//            System.out.print("" + i + " ");
//        }
//        System.out.println();


        // 初始化一个空的集合。
        RandomizedCollection collection = new RandomizedCollection();

        // 向集合中插入 1 。返回 true 表示集合不包含 1 。
        collection.insert(1);

        // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
        collection.insert(1);

        // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
        collection.insert(2);

        // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
        System.out.println(collection.getRandom());

        // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
        System.out.println(collection.remove(1));

        // getRandom 应有相同概率返回 1 和 2 。
        System.out.println(collection.getRandom());

    }
}
