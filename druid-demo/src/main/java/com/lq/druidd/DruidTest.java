package com.lq.druidd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: huang
 * @BelongsPackage: com.lq.druidd
 * @Author: LuQing
 * @CreateTime: 2023-02-25  16:11
 * @Description: TODO
 * @Version: 1.0
 */
public class DruidTest {
    private static final List<Object> druidList = new ArrayList<>();
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    static {
        lock.lock();
        for (int i = 0; i < 10; i++) {
            if (druidList.size() < 10) {
                druidList.add(new Object());
            }
        }
        lock.unlock();
    }
}
