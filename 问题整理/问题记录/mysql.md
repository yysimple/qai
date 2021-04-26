### 参考文章
https://juejin.cn/post/6850037271233331208#heading-17
https://blog.csdn.net/weixin_44704261?t=1

### 问题
1. mysql的架构？
2. mysql的查询，select的过程？
3. mysql的更新，update的过程？
https://zhuanlan.zhihu.com/p/163851471
4. mysql的插入，insert的过程？
https://juejin.cn/post/6919263740122628109
5. mysql的删除，delete的过程？
6. mysql的事务？
7. mysql的隔离级别以及对应为了解决什么问题？
8. 可重复读mysql怎么实现的？
9. mvcc是什么？
10. 存储引擎是作用于谁的？了解多少存储引擎，其各自的区别？
https://blog.csdn.net/weixin_44704261/article/details/106646236
11. mysql文件存储结构和位置？
12. 哪个存储引擎执行 select count(*) 更快，为什么?
> MyISAM更快，因为MyISAM内部维护了一个计数器，可以直接调取。 
> InnoDB事务特性有关，由于多版本并发控制（MVCC）的原因，InnoDB 表“应该返回多少行”也是不确定的。

13. CHAR 和 VARCHAR 的区别？
> - char不论实际存储的字符数都会占用n个字符的空间，
而varchar只会占用实际字符应该占用的字节空间加1（实际长度length，0<=length<255）或加2（length>255）。
> - 因为varchar保存数据时除了要保存字符串之外还会加一个字节来记录长度（如果列声明长度大于255则使用两个字节来保存长度）。
能存储的最大空间限制不一样：char的存储上限为255字节。
> - char在存储时会截断尾部的空格，而varchar不会。

14. 说说你对 MySQL 索引的理解(btree b+tree hash 聚簇/非聚簇)？
15. 索引时全部存在内存中的吗？说说看？
16. 索引的优缺点？
17. B-tree和B+tree在mysql中的逻辑讲讲？
18. 什么是回表操作？怎么减少？
19. mysql要是表中没有建立主键，会怎么做？
20. 为何不采用Hash方式？为什么Mysql索引要用B+树不是B树？
21. MySQL中 in和 exists 的区别？
> - exists：exists对外表用loop逐条查询，每次查询都会查看exists的条件语句，当exists里的条件语句能够返回记录行时（无论记录行是的多少，只要能返回），
条件就为真，返回当前loop到的这条记录；反之，如果exists里的条件语句不能返回记录行，则当前loop到的这条记录被丢弃，exists的条件就像一个bool条件，
当能返回结果集则为true，不能返回结果集则为false
> - in：in查询相当于多个or条件的叠加

- 如果查询的两个表大小相当，那么用in和exists差别不大。
- 如果两个表中一个较小，一个是大表，则子查询表大的用exists，子查询表小的用in：

22. 分布式事务实现方式？TCC？二阶段提交？
http://seata.io/zh-cn/docs/overview/what-is-seata.html
23. MySQL 中有哪几种锁，列举一下？
24. mysql的gap锁？
25. MySQL 遇到过死锁问题吗，你是如何解决的？
26. mysql怎么调优说下？
https://blog.csdn.net/weixin_44704261/article/details/106648309
27. 查询中哪些情况不会使用索引？
https://blog.csdn.net/weixin_44704261/article/details/106650963
28. Buffer Pool讲讲是什么？
29. 怎么知道 Buffer Pool 中的数据就是脏数据了？
30. Buffer Pool 中的脏数据这么多，哪些应该先输入到磁盘中呢？Buffer Pool 满了又该怎么办？
31. 讲讲数据库的分库分表？
32. 分库分表后的后遗症？怎么解决？
33. 单机mysql数据库的性能瓶颈是多少？
34. OLTP与OLAP的关系是什么？
 



