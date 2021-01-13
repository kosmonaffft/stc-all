package university.innopolis.stc.redis;

import lombok.Cleanup;
import org.redisson.Redisson;
import org.redisson.api.RFuture;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Config cfg = new Config();
        SingleServerConfig singleServerConfig = cfg.useSingleServer();
        singleServerConfig.setAddress("redis://localhost:6379");
        @Cleanup("shutdown") RedissonClient redissonClient = Redisson.create(cfg);

//        var myBucket = redissonClient.getBucket("my_bucket");
//        myBucket.set("my_value");
//        myBucket.expire(30, TimeUnit.SECONDS);

//        RBucket<Object> bucket = redissonClient.getBucket("my_bucket");
//        Object value = bucket.get();
//        bucket.expire(30, TimeUnit.SECONDS);
//        System.out.printf("My value is: %s%n", value);

        RLock myListLock = redissonClient.getLock("my_list_lock");
        myListLock.lock(1, TimeUnit.MINUTES);
        RList<String> list = redissonClient.getList("my_list");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        myListLock.unlock();

//        RList<String> list = redissonClient.getList("my_list");
//        list.forEach(item -> System.out.println(item));

//        RDeque<Object> myQueue = redissonClient.getDeque("my_queue");
//        myQueue.push("2");
//        myQueue.push("3");
//        myQueue.push("4");

//        System.out.println(myQueue.pop());

        long count = redissonClient.getKeys().count();

        RLock my_lock = redissonClient.getLock("my_lock");
        my_lock.lock(2, TimeUnit.MINUTES);

        System.out.println(String.format("Hello, world!!! We have %s keys!!!", count));
    }
}
