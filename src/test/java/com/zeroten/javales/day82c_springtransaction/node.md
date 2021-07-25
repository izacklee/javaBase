2021.3.2
MySQL Workbench 数据库管理工具
#### 1 Spring声明式事务原理
   一般直接@Transactional这么设置就行，用默认的，除非有特殊场景需求需要。
   注意：在@Transactional事务方法里只做一些数据库的操作，不要去调用一些接口（比如加Thread.sleep(30000)），
    否是可能会造成过于耗时引起获取数据库连接失败。
#### 2 Spring事务底层逻辑讲解