package university.innopolis.stc.redis;

import org.redisson.Redisson;
import org.redisson.api.RDeque;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Config cfg = new Config();
        SingleServerConfig singleServerConfig = cfg.useSingleServer();
        singleServerConfig.setAddress("redis://localhost:6379");
        RedissonClient redissonClient = Redisson.create(cfg);

//        redissonClient.getBucket("my_bucket").expire(1, TimeUnit.MINUTES);
//        HashMap<String, String> my_bycket = redissonClient.<HashMap<String, String>>getBucket("my_bycket").get();

//        RList<String> list = redissonClient.getList("list");
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.add("6");

//        RDeque<Object> q = redissonClient.getDeque("q");
//        redissonClient.getDeque("q").push("2");
//        redissonClient.getDeque("q").push("3");
//        redissonClient.getDeque("q").push("4");

        long count = redissonClient.getKeys().count();

        RLock my_lock = redissonClient.getLock("my_lock");
        my_lock.lock(2, TimeUnit.MINUTES);

        System.out.println(String.format("Hello, world!!! We have %s keys!!!", count));
        redissonClient.shutdown();
    }
}
