2021.2.23
#### 1 Spring事务传播特性
   可以设置传播性，对应不同的场景，影响不同的行为。
#### 2 Spring声明式事务原理
   1）@Transactional只支持非public修饰的方法失效，调用含自调用的方法失效
   2）检查异常默认不回滚
    2.1）在默认情况下，抛出非检查异常会触发回滚，而检查异常不会。
        只有在RuntimeException和Error的实例，即非检查异常，或在@Transactional中通过rollbackFor属性指定回滚异常
        类新，才会回滚事务。否则将继续提交事务。
        伪代码：
            // @Transactional
            @Transactional(rollbackFor = {Exception.class}) // 加了rollbackFor以下抛出的Exception事务才回滚
            public void test() throws Exception {
            
                // 数据库操作
                // insert
                
                throw new Exception();  // 这种异常不会回滚事务 加rollbackFor属性后就可回滚了
                
                // throw new IllegalArgumentException() // 会回滚事务 因继承了RuntimeException 即非检查异常
            } 
   3）catch异常无法回滚
        伪代码：
        @Transactional
        public void insert(List<User> users) {
        
            // 数据库操作
            try {
            
            } catch (Exception e) { // 异常catch住 不往外抛的话 事务是无法回滚的
                e.printStackTrace();  
            }
        }            