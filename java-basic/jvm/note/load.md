# 服务器性能指标-负载
在UNIX系统中，系统负载是对当前CPU工作量的度量，被定义为特定时间间隔内运行队列中的平均线程数。load average 表示机器一段时间内的平均load。这个值越低越好。负载过高会导致机器无法处理其他请求及操作，甚至导致死机。

Linux的负载高，主要是由于CPU使用、内存使用、IO消耗三部分构成。任意一项使用过多，都将导致服务器负载的急剧攀升。

## 查看机器负载
在Linux机器上，有多个命令都可以查看机器的负载信息。其中包括uptime、top、w等。

### uptime
`uptime` 命令能够打印系统总共运行了多长时间和系统的平均负载。
uptime命令可以显示的信息显示依次为：现在时间、系统已经运行了多长时间、目前有多少登陆用户、系统在过去的1分钟、5分钟和15分钟内的平均负载。
```
[root@iz2ze88p52tbimsqsq3canz ~]# uptime
 11:09:01 up 157 days, 57 min,  2 users,  load average: 0.00, 0.01, 0.05
```
这行信息的后半部分，显示"load average"，它的意思是"系统的平均负荷"，里面有三个数字，我们可以从中判断系统负荷是大还是小。
这三个数字的意思分别是1分钟、5分钟、15分钟内系统的平均负荷。我们一般表示为load1、load5、load15。
 
### w命令
w命令的主要功能其实是显示目前登入系统的用户信息。
w命令还可以显示：当前时间，系统启动到现在的时间，登录用户的数目，系统在最近1分钟、5分钟和15分钟的平均负载。
然后是每个用户的各项数据，项目显示顺序如下：登录帐号、终端名称、远 程主机名、登录时间、空闲时间、JCPU、PCPU、当前正在运行进程的命令行。
 
### top命令
top命令是Linux下常用的性能分析工具，能够实时显示系统中各个进程的资源占用状况，类似于Windows的任务管理器。
```
 top - 11:12:58 up 157 days,  1:01,  2 users,  load average: 0.00, 0.01, 0.05
 Tasks:  71 total,   1 running,  69 sleeping,   1 stopped,   0 zombie
 %Cpu(s):  0.3 us,  0.0 sy,  0.0 ni, 99.7 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st
 KiB Mem :  1883492 total,   141916 free,   425060 used,  1316516 buff/cache
 KiB Swap:        0 total,        0 free,        0 used.  1257916 avail Mem
 
   PID USER      PR  NI    VIRT    RES    SHR S %CPU %MEM     TIME+ COMMAND
 13824 root       0 -20  127408  12096   9284 S  0.3  0.6  99:51.53 AliYunDun
     1 root      20   0   51488   3656   2448 S  0.0  0.2  21:47.55 systemd
```

## 机器正常负载范围
最好根据自己机器的实际情况，建立一个指标的基线（如近一个月的平均值），只要日常的load在基线上下范围内不太大都可以接收，如果差距太多可能就要人为介入检查了。

阮一峰在自己的博客中有过以下建议：
> 当系统负荷持续大于0.7，你必须开始调查了，问题出在哪里，防止情况恶化。
  当系统负荷持续大于1.0，你必须动手寻找解决办法，把这个值降下来。
  当系统负荷达到5.0，就表明你的系统有很严重的问题，长时间没有响应，或者接近死机了。你不应该让系统达到这个值。

以上指标都是基于单CPU的，但是现在很多电脑都是多核的。所以，对一般的系统来说，是根据cpu数量去判断系统是否已经过载（Over Load）的。
如果我们认为0.7算是单核机器负载的安全线的话，那么四核机器的负载最好保持在3(4*0.7 = 2.8)以下。

## 如何降低负载
导致负载高的原因可能很复杂，有可能是硬件问题也可能是软件问题。

如果是硬件问题，那么说明机器性能确实就不行了，那么解决起来很简单，直接换机器就可以了。前面我们提过，CPU使用、内存使用、IO消耗都可能导致负载高。

如果是软件问题，有可能由于Java中的某些线程被长时间占用、大量内存持续占用等导致。建议从以下几个方面排查代码问题：
1. 是否有内存泄露导致频繁GC 
2. 是否有死锁发生 
3. 是否有大字段的读写 
4. 会不会是数据库操作导致的，排查SQL语句问题。

这里还有个建议，如果发现线上机器Load飙高，可以考虑先把堆栈内存dump下来后，进行重启，暂时解决问题，然后再考虑回滚和排查问题。

## Java Web应用Load飙高排查思路
1. 使用uptime查看当前load，发现load飙高。
2. 使用top命令，查看占用CPU较高的进程ID。
```
➜  ~ top

PID USER      PR  NI  VIRT  RES  SHR S %CPU %MEM    TIME+  COMMAND
1893 admin     20   0 7127m 2.6g  38m S 181.7 32.6  10:20.26 java
```
发现PID为1893的进程占用CPU 181%。而且是一个Java进程，基本断定是软件问题。

3. 使用 top命令，查看具体是哪个线程占用率较高
```
➜  ~ top -Hp 1893
PID USER      PR  NI  VIRT  RES  SHR S %CPU %MEM    TIME+  COMMAND
4519 admin     20   0 7127m 2.6g  38m R 18.6 32.6   0:40.11 java
```

4. 使用printf命令查看这个线程的16进制
```
➜  ~ printf %x 4519
11a7
```
5. 使用`jstack`命令查看当前线程正在执行的方法
```
➜  ~ jstack 1893 |grep -A 200 11a7
"thread-5" #500 daemon prio=10 os_prio=0 tid=0x00007f632314a800 nid=0x11a2 runnable [0x000000005442a000]
java.lang.Thread.State: RUNNABLE
at sun.misc.URLClassPath$Loader.findResource(URLClassPath.java:684)
at sun.misc.URLClassPath.findResource(URLClassPath.java:188)
at java.net.URLClassLoader$2.run(URLClassLoader.java:569)
at java.net.URLClassLoader$2.run(URLClassLoader.java:567)
at java.security.AccessController.doPrivileged(Native Method)
at java.net.URLClassLoader.findResource(URLClassLoader.java:566)
at org.hibernate.validator.internal.xml.ValidationXmlParser.getInputStreamForPath(ValidationXmlParser.java:248)
at com.solverpeng.test.util.BeanValidator.validate(BeanValidator.java:30)
```
从上面的线程的栈日志中，可以发现，当前占用CPU较高的线程正在执行我代码的com.solverpeng.test.util.BeanValidator.validate(BeanValidator.java:30)类。
那么就可以去排查这个类是否用法有问题了。

6. 还可以使用jstat来查看GC情况，看看是否有频繁FGC，然后再使用jmap来dump内存，查看是否存在内存泄露。