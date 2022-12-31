# Java
1. Why Java class don't inherit annotation: https://stackoverflow.com/a/4745820

# H2
H2 console website: http://localhost:8080/h2-console

# JPA
## EntityManager vs Hibernate
https://stackoverflow.com/questions/14621495/what-is-the-difference-between-an-spring-entity-manager-and-spring-data-reposito
1. EntityManager belong to javax.persistence (now is jakarta.persistence)
2. Hibernate has a interface call JPARepository which extends CRUDRepository and integrate EntityManager. You can check the source code

## FetchType vs FetchMode
1. FetchType 係請緊拎entity時LAZY拎埋入面嘅entity 定 eager一早拎埋. 唔關join 唔join 時
2. FetchMode 係講緊拎個時用JOIN, SELECT定點拎
3. FetchMode.JOIN will be ignored when using EntityManager.createQuery() except you use EntityManager CriteriaBuilder. https://stackoverflow.com/questions/18891789/fetchmode-join-makes-no-difference-for-manytomany-relations-in-spring-jpa-reposi

## Others
1. GenerationType (IDENTITY, SEQUENCE, TABLE): https://www.hxstrive.com/subject/open_jpa/533.htm
2. @IdClass for composite primary key 
3. Relationship: check BookEntity and https://blog.csdn.net/Xu_JL1997/article/details/103018249
4. CascadeType https://blog.csdn.net/qq_43290288/article/details/105666055
5. Join and Fetch in Specification: check BookService.getBooks

# Restful APIs:
1. http://127.0.0.1:8080/book
2. http://127.0.0.1:8080/author
3. http://127.0.0.1:8080/publishing

# RabbitMQ
1. Basic: https://kucw.github.io/blog/2020/11/rabbitmq/
2. Priority Queue: https://medium.com/willhanchen/rabbitmq-%E8%A8%8A%E6%81%AF%E7%9A%84%E5%A6%82%E4%BD%95%E6%8F%92%E9%9A%8A-priority-ee7c9566b388

## Without Exchange:
1. Simple (Only one consumer)
<br/>
<img src="https://kucw.github.io/images/blog/rabbitmq_direct.png"/>
2. Worker (Multiple consumer)
<br/>
<img src="https://kucw.github.io/images/blog/rabbitmq_worker.png"/>

## With Exchange
1. Fan-out (type = fanout) (Message throw to all queue)
<br/>
<img src="https://kucw.github.io/images/blog/rabbitmq_subscribe.png"/>
2. Routing (type = direct) (當 Producer 把 message 丟給 Exchange 時，同時要在這個 message 上面帶上一個 routing key，而 Exchange 就會根據這個 routing key，將 message 丟到指定的 Queue 上)
<br/>
<img src="https://kucw.github.io/images/blog/rabbitmq_routing1.png"/>
3. Topic (type = topic) (Similar to Direct, but it can use wildcard)
<br/>
<img src="https://kucw.github.io/images/blog/rabbitmq_topics.png"/>




# Kafka:
https://www.tpisoftware.com/tpu/articleDetails/2518
1. Refer to kafka-docker
2. 