学习笔记

# 一 串行GC
![串行案例](http://source.icodego.com/serialgc.png)
DefNew 年轻代单线程GC收集器,标记-复制,STW  
Tenured 老年代单线程GC收集器,标记-清除-整理
跟老师课上演示不同,512m就发生了Full GC  
串行GC使用单线程GC,回收暂停时间比较长,特别是堆内存比较大的时候  
将堆内存调大后,GC次数会变少,但回收时间会变长  
将堆内存调特别小,GC频繁,且有OOM风险
# 二 并行GC
![并行案例](http://source.icodego.com/parallelgc.png)
PSYoungGen 并行年轻代垃圾收集器,标记-复制,STW  
ParOldGen 并行老年代垃圾收集器,标记-清除-整理,STW  
并行GC回收暂停时间明显比串行少  
堆内存调大调小的结果与串行类似
# 三 CMS GC
![CMS案例](http://source.icodego.com/cmsgc.png)
ParNew 年轻代并行垃圾收集,标记-复制,STW,专门配合老年代CMS垃圾收集器  
CMS Initial Mark 初始标记,STW  
CMS-concurrent-mark 并发标记  
CMS-concurrent-preclean 并发预清理  
CMS-concurrent-abortable-preclean  并发可取消预清理  
CMS Final Remark 最终标记,STW  
CMS-concurrent-sweep 并发清除  
CMS-concurrent-reset 并发重置  
CMS能够跟业务线程并发执行,一般是cpu核数1/4
堆内存调大调小的结果与前面类似
# 四 G1 GC
![G1案例](http://source.icodego.com/g1gc.png)  
(G1 Evacuation Pause) (young) 纯年轻代模式转移暂停  
Concurrent Marking 并发标记  
initial-mark 初始标记  
concurrent-root-region-scan Root区扫描  
concurrent-mark 并发标记  
remark 再次标记,STW  
cleanup 清理  
(G1 Evacuation Pause) (mixed) 转移暂停:混合模式  
G1暂停时间更小,它被设计成STW可控的垃圾回收器  
堆内存调大调小的结果与前面类似

# 压测
使用压测工具（wrk或sb），演练gateway-server-0.0.1-SNAPSHOT.jar 示例。
![压测示例](http://source.icodego.com/sb1.png)
![压测示例](http://source.icodego.com/sb2.png)
![压测示例](http://source.icodego.com/sb3.png)
![压测示例](http://source.icodego.com/sb4.png)
![压测示例](http://source.icodego.com/sb5.png)
![压测示例](http://source.icodego.com/sb6.png)

在我机器上用压测工具压,结果好像都一样的,搞不清楚啥情况了,难道是我机器性能太好了么,每次结果都没什么大差别

