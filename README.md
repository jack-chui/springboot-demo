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
1. FetchType 係請緊拎entity時LAZY拎埋入面嘅entity 定 eager一早拎埋
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

# Kafka:
https://www.tpisoftware.com/tpu/articleDetails/2518