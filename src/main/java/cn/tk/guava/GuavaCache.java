package cn.tk.guava;

import com.google.common.cache.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static java.lang.System.*;

/**
 * Created by xiedan11 on 2016/11/23.
 * Guava Cache有两种创建方式：
 * 1.cacheLoader
 * 2.callable callback
 * 通过这两种方法创建的cache，和通常用map来缓存的做法比，不同在于，这两种方法都实现了一种逻辑——从缓存中取key X的值，如果该值已经缓存过了，则返回缓存中的值，如果没有缓存过，可以通过某个方法来获取这个值。
 * 但不同的在于cacheloader的定义比较宽泛，是针对整个cache定义的，可以认为是统一的根据key值load value的方法。而callable的方式较为灵活，允许你在get的时候指定。
 */
public class GuavaCache {
    /**
     * 1.普通的map允许返回null.
     * 2.cacheloader不允许返回null.
     * 3.如果缓存中已经有该key的值，则返回key对应的value，如果没有缓存过，可以通过某个方法来获取这个值.
     * @throws Exception
     */
    @Test
    public void testLoadingCache() throws Exception {
        LoadingCache<String, String> loadingCache = CacheBuilder
                .newBuilder()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String k1) throws Exception {
                        String strProValue = "hello " + k1 + "!";
                        return strProValue;
                    }
                });
        Map map = new HashMap<String, String>();
        out.println("Map Value===========:" );
        out.println("jerry value:" + map.get("jerry"));
        out.println("LoadingCache Value===========:" );
        out.println("jerry value:"+loadingCache.apply("jerry"));
        out.println("peida value:" + loadingCache.get("peida"));
        loadingCache.put("harry", "ssdded");
        out.println("harry value:" + loadingCache.get("harry"));
    }

    @Test
    public void testCallableCache() throws Exception{
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String resultVal = cache.get("jerry", new Callable<String>() {
            @Override
            public String call() throws Exception {
                String strProValue="hello " + "jerry" + "!";
                return strProValue;
            }
        });
        out.println("CallableCache Value===========:" );
        out.println("jerry value: " + resultVal);
        resultVal = cache.get("peida", () -> {
            String strProValue="hello " + "peida" + "!";
            return strProValue;
        });
        out.println("peida value: " + resultVal);
    }
    /**
     *java8的computeIfAbsent方法可以在key所对应的value值不存在的情况下，计算一个新的value值。
     */
    @Test
    public void localCacheJava8() {
        Map<String, String> cache = new HashMap<String, String>();
        out.println("Java8 computeIfAbsent Value===========:" );
        out.println("coco value:" + cache.computeIfAbsent("coco", this::f));
    }

    public String f(String s) {
        return "hello " + s;
    }


    /**============================ 基于泛型的CacheLoader封装 start======================================*/
    public <K, V> LoadingCache<K, V> cached(CacheLoader<K, V> cacheLoader) {
        LoadingCache<K, V> cache = CacheBuilder
                .newBuilder()
                .maximumSize(3)
                .weakKeys()
                .softValues()
                .refreshAfterWrite(120, TimeUnit.SECONDS)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .removalListener(new RemovalListener<K, V>() {
                    @Override
                    public void onRemoval(RemovalNotification<K, V> removalNotification) {
                        out.println(removalNotification.getKey()+"被移除");
                    }
                })
                .build(cacheLoader);
        return cache;
    }
    /**============================ 基于泛型的CacheLoader封装 end======================================*/

    /**
     * 基于泛型的CacheLoader实现
     */

    public LoadingCache<String, String> commonCache(final String key) throws Exception {
        LoadingCache<String, String> commonCache = cached(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return "hello " + key + "!";
            }
        });
        return commonCache;
    }
    @Test
    public void testCache() throws Exception {
        LoadingCache<String, String> cache = commonCache("jetty");
        out.println("jetty value:" + cache.get("jetty"));
        cache.get("nut");
        out.println("nut value:" + cache.get("nut"));
        cache.get("lisa");
        out.println("lisa value:" + cache.get("lisa"));
        cache.get("lisa");
        out.println("lisa value:" + cache.get("lisa"));
        cache.get("pangsun");
        out.println("pangsun value:" + cache.get("pangsun"));
        cache.get("heihei");
        out.println("heihei value:" + cache.get("heihei"));
    }

    /**============================ 基于泛型的Callable Cache封装 start======================================*/
    private static Cache<String, String> cacheFormCallable = null;

    public static <K, V> Cache<K, V> callableCached() throws Exception {
        Cache<K, V> cache = CacheBuilder
                .newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();
        return cache;
    }
    /**============================ 基于泛型的Callable Cache封装 end======================================*/
    /**
     * 基于泛型的Callable Cache实现
     */
    public String getCallableCache(final String userName) {
        try {
            //Callable只有在缓存值不存在时，才会调用
            return cacheFormCallable.get(userName, () -> {
                out.println(userName + " from db");
                return "hello " + userName + "!";
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testCallableImlCache() throws Exception{
        final String u1name = "peida";
        final String u2name = "jerry";
        final String u3name = "lisa";
        cacheFormCallable = callableCached();
        out.println("peida:" + getCallableCache(u1name));
        out.println("jerry:" + getCallableCache(u2name));
        out.println("lisa:" + getCallableCache(u3name));
        out.println("peida:" + getCallableCache(u1name));
    }

}
