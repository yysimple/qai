### 参考文章
https://juejin.cn/post/6844904125935665160

1. mq的工作模式？
2. 如何保证RabbitMQ消息的顺序性？
> 拆分多个 queue(消息队列)，每个 queue(消息队列) 一个 consumer(消费者)，就是多一些 queue (消息队列)而已，确实是麻烦点；
> == 或者就一个 queue (消息队列)但是对应一个 consumer(消费者)，然后这个 consumer(消费者)内部用内存队列做排队，
> 然后分发给底层不同的 worker 来处理。
3. 消息如何分发？
> 若该队列至少有一个消费者订阅，消息将以循环（round-robin）的方式发送给消费者。
> 每条消息只会分发给一个订阅的消费者（前提是消费者能够正常处理消息并进行确认）。

4. 消息怎么路由？
5. 如何保证消息的幂等（过滤重复消息）、重试？
> 幂等可用mysql唯一索引做（生产者生成唯一id）
> 重试 ==》  14实现方案
6. 如何解决消息队列的延时以及过期失效问题？消息队列满了以后该怎么处理？有几百万消息持续积压几小时，怎么办？
7. 如何保证RabbitMQ消息的可靠传输（保证消息不丢失）？
> 生产者：boolean b = rabbitTemplate.waitForConfirms(1000);
> https://blog.csdn.net/weixin_39836943/article/details/110516528

8. 怎么自己实现广播和点对点？
> 使用socket
9. mq死信队列的原理？
10. vhost 是什么？起什么作用？
> vhost 可以理解为虚拟 broker ，即 mini-RabbitMQ  server。
> 其内部均含有独立的 queue、exchange 和 binding 等，但最最重要的是，
> 其拥有**独立的权限系统**，可以做到 vhost 范围的用户控制。
> 当然，从 RabbitMQ 的全局角度，vhost 可以作为不同权限隔离的手段（一个典型的例子就是不同的应用可以跑在不同的 vhost 中）。
11. 消息怎么顺序发送？
12. rabbitmq底层的结构？
blocker ==》 node 
13. 什么是死信消息？
> - 消息被拒绝（Basic.Reject或Basic.Nack）并且设置 requeue 参数的值为 false
> - 消息过期了
> - 队列达到最大的长度

14. 消息手动重试 + redis记录重试次数 + 重试次数超过一定次数投递到死信队列中（做相对应的消费失败处理）
15. 什么是元数据？元数据的存储、类型等？
16. 在单 node 系统和多 node 构成的 cluster 系统中声明 queue、exchange ，以及进行 binding 会有什么不同？
17. RabbitMQ 中的 broker 是指什么？cluster 又是指什么？
> broker 是指一个或多个 erlang node 的逻辑分组，且 node 上运行着 RabbitMQ 应用程序。cluster 是在 broker 的基础之上，
> 增加了 node 之间共享元数据的约束。
18. RabbitMQ 概念里的 channel、exchange 和 queue 是逻辑概念，还是对应着进程实体？分别起什么作用？
> queue 具有自己的 erlang 进程；
> exchange 内部实现为保存 binding 关系的查找表；
> channel 是实际进行路由工作的实体，即负责按照 routing_key 将 message 投递给 queue 。
> 由 AMQP 协议描述可知，channel 是真实 TCP 连接之上的虚拟连接，所有 AMQP 命令都是通过 channel 发送的，且每一个 channel 有唯一的 ID。
> 一个 channel 只能被单独一个操作系统线程使用，故投递到特定 channel 上的 message 是有顺序的。但一个操作系统线程上允许使用多个 channel 。

