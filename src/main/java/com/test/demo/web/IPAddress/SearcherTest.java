package com.test.demo.web.IPAddress;

import org.lionsoul.ip2region.xdb.Searcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/7/27 11:51
 */
public class SearcherTest {

    public static void main(String[] args) {
        // 1、创建 searcher 对象
        //ip2region.xdb通过ip2region的github项目生成出来的，编译项目并运行jar包，指定srcFile = "data/ip.merge.txt", dstFile = "E:/test/ip2region.xdb";，运行test生成
        //github地址：https://github.com/lionsoul2014/ip2region
        String dbPath = "E:/test/ip2region.xdb";
        Searcher searcher = null;
        byte[] cBuff;
        try {
            cBuff = Searcher.loadContentFromFile(dbPath);
        } catch (IOException e) {
            System.out.printf("failed to create searcher with `%s`: %s\n", dbPath, e);
            return;
        }

        // 2、使用上述的 cBuff 创建一个完全基于内存的查询对象。
        try {
            searcher = Searcher.newWithBuffer(cBuff);
        } catch (Exception e) {
            System.out.printf("failed to create content cached searcher: %s\n", e);
            return;
        }

        // 2、查询
        String ip = new String();
        try {
            ip = "116.28.65.102";
            long sTime = System.nanoTime();
            String region = searcher.search(ip);
            long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
            System.out.printf("{region: %s, ioCount: %d, took: %d μs}\n", region, searcher.getIOCount(), cost);
        } catch (Exception e) {
            System.out.printf("failed to search(%s): %s\n", ip, e);
        }

        // 3、备注：并发使用，每个线程需要创建一个独立的 searcher 对象单独使用。
    }

}
