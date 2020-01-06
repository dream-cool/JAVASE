package ording;

import util.RandomUtil;

/**
 * @author ：clt
 * @Date ：Created in 21:04 2019/9/2
 */
public class address {

    public static void main(String[] args) {
//        String[][][] address = {{{},{},{}},{{},{},{}},{{},{},{}}};
//        String[][] strings = {{"131","!$1"},{"141","141"},{"141"}};
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.getRandomAddressCity());
        }
    }
}
