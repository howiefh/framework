package io.github.howiefh.mybatis;

import java.util.Map;

/**
 * @author fenghao on 2016/5/16
 * @version 1.0
 * @since 1.0
 */
public class MybatisPageTest {
    private static int[] pageSizes = new int[]{5,10,20,30,50,100};
    private static int group = 10;

    public static void main(String[] args) {
        MybatisPage page;
        System.out.println("使用分页插件分页");
        page = new PageHelper();
        test(page);
        System.out.println("使用原始的SQL分页");
        page = new NativeSqlPage();
        test(page);

        System.out.println("使用原始的SQL分页");
        page = new NativeSqlPage();
        test(page);
        System.out.println("使用分页插件分页");
        page = new PageHelper();
        test(page);
    }

    private static void test(MybatisPage pager) {
        for (int i = 0; i < pageSizes.length; i++){
            long sum = 0;
            int pages = 0;
            for (int j = 0; j < group; j++){
                Map<String, Number> result = pager.execute(pageSizes[i]);
                long time = (Long) result.get("time");
                pages = (Integer) result.get("pages");
                sum += time;
                System.out.println("第 [" + (j+1) + "] 组，执行时间：" + time + "毫秒");
            }
            System.out.println("共 [" + pages + "] 页，测试 [" + group + "] 组，平均时间：" + (double)sum/(double)group + "毫秒");
        }
    }
}
