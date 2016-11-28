package cn.tk.generic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xiedan11 on 2016/11/16.
 * 1.���Խ�Arrays.asList���������list,�����ڵײ���Ȼ�����飬��˲��ܵ����ߴ硣
 * ������ͼ��add()��delete()�������б������ӻ���ɾ��Ԫ�أ�������ʱ��á�java.lang.UnsupportedOperationException������
 */
class Snow{}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}
public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Powder(), new Crusty(), new Slush());
        List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
        //snow1.add(new Crusty());
        for (Snow x:
             snow1) {
            System.out.println("snow1:" + x.getClass());
        }
        for (Snow x:
                snow2) {
            System.out.println("snow2:" + x.getClass());
        }
    }
}
