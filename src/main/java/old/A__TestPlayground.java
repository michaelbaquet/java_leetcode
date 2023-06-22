package old;

public class A__TestPlayground {


    static int[] nums = new int[10];
    static int[] root = {0,0,1,2,3};
    public static void main(String[] args) {


        System.out.println(1 << 31);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        long l = 2L << 62;
        int i = Integer.MAX_VALUE;
        System.out.println(2147483647L * 1000000000L);
        System.out.println(Long.MAX_VALUE);
        System.out.println(l - 1);
        System.out.println(-9/5);
//        old.RandomizedSet set = new old.RandomizedSet();
//
//        set.insert(0);
//        set.insert(1);
//        set.remove(0);
//        set.insert(2);
//        set.remove(1);
//        System.out.println(set.getRandom());
//["old.MaxStack","push","peekMax","push","peekMax","push","pop","pop","push","peekMax","push","popMax","top","push","push","peekMax","popMax","popMax"]
//[[],[92],[],[54],[],[22],[],[],[-57],[],[-24],[],[],[26],[-71],[],[],[]]


    }

    public static int find(int a) {
        if(root[a] == a) {
            return a;
        }
        return root[a] = find(root[a]);
    }

}
