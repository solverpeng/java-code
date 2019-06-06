# jdk1.8 Java堆
```
Heap
 PSYoungGen      total 9216K, used 1807K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 8192K, 22% used [0x00000000ff600000,0x00000000ff7c3f08,0x00000000ffe00000)
  from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
  to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
 ParOldGen       total 10240K, used 0K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 0% used [0x00000000fec00000,0x00000000fec00000,0x00000000ff600000)
 Metaspace       used 3533K, capacity 4594K, committed 4864K, reserved 1056768K
  class space    used 404K, capacity 426K, committed 512K, reserved 1048576K
```
可以看到分为了三部分：年轻代、老年代、元空间

## Java堆配置
使用 -Xms 设置堆的初始空间大小，使用 -Xmx 设置堆的最大空间大小。一般情况下，会将这两个值设置为相等。
```
java -Xms20m -Xmx30m -XX:+PrintGCDetails
```

## 年轻代（PSYoungGen）配置
参数 -Xmn 来设置年轻代内存的大小
```
java -Xms20m -Xmx20M -Xmn10m -XX:+PrintGCDetails
--------------
 PSYoungGen      total 9216K, used 1807K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 8192K, 22% used [0x00000000ff600000,0x00000000ff7c3db0,0x00000000ffe00000)
  from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
  to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
 ParOldGen       total 10240K, used 0K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 0% used [0x00000000fec00000,0x00000000fec00000,0x00000000ff600000)
```
### eden/from eden/to
使用 -XX:SurvivorRatio 这个参数，该参数设置 eden/from 空间的比例关系，默认比例为8:1。
```-XX:SurvivorRatio = eden/from = eden/to```

```
java -Xms20m -Xmx20M -Xmn10m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
--------------
Heap
 PSYoungGen      total 7680K, used 1627K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 5120K, 31% used [0x00000000ff600000,0x00000000ff796c60,0x00000000ffb00000)
  from space 2560K, 0% used [0x00000000ffd80000,0x00000000ffd80000,0x0000000100000000)
  to   space 2560K, 0% used [0x00000000ffb00000,0x00000000ffb00000,0x00000000ffd80000)
```
这里的 total 指的是可用内存，from space 和 to space 两个区域，同一时间只有一个区域是可以用的。

## 老年代配置
老年代不需要配置，老年代的大小就等于堆大小减去年轻代大小。

## 元空间
存在两个参数来设置元空间，` -XX:MetaspaceSize`和`-XX:MaxMetaspaceSize`。
` -XX:MetaspaceSize`表示元空间发生GC的初始阈值，达到这个值时，元空间发生GC，默认是20.8M。

`-XX:MaxMetaspaceSize` 则是设置元空间的最大大小，默认基本是机器的物理内存大小。
虽然可以不设置，但还是建议设置一下，因为如果一直不断膨胀，那么 JVM 进程可能会被 OS kill 掉。
```
java -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=50m -XX:+PrintGCDetails
--------------
Metaspace       used 3533K, capacity 4594K, committed 4864K, reserved 1056768K
  class space    used 404K, capacity 426K, committed 512K, reserved 1048576K
```

# 直接内存
在 JVM 中还有一块内存，它独立于 JVM 的堆内存，它就是：直接内存。我们可以使用 -XX:MaxDirectMemorySize 设置最大直接内存。
如果不设置，默认为最大堆空间，即 -Xmx。
```
java -XX:MaxDirectMemorySize=50m
```
当直接内存使用达到设置值时，就会触发垃圾回收。如果不能有效释放足够空间，就会引发直接内存溢出导致系统的 OOM。

| 参数  | 含义 |
| ------------------------ | ------ |
-Xms |	初始堆大小 |
-Xmx |	最大堆空间 |
-Xmn |	设置新生代大小 |
-XX:SurvivorRatio |	设置新生代eden空间和from/to空间的比例关系 |
-XX:PermSize |	方法区初始大小 |
-XX:MaxPermSize |	方法区最大大小 |
-XX:MetaspaceSize |	元空间GC阈值（JDK1.8） |
-XX:MaxMetaspaceSize |	最大元空间大小（JDK1.8）|
-Xss |	栈大小 |
-XX:MaxDirectMemorySize | 	直接内存大小，默认为最大堆空间 |

