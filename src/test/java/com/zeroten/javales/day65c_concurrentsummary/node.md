总结
#### 1 Java7 HashMap&ConcurrentHashMap
   1）HashMap
        put(key,value)
        get(key)
        Node[] capacity(容量 为2^16 为什么不是n次方 而是16次方呢？因为16发生冲突的概率较小) entry(key,value)
        key hash(key)=hashcode
        hashcode % capacity = index // 函数计算得到下标
        Nodes[index] // 找到元素
        hash冲突：hash(key1) = hash(key2)
            两个key放到了同一个数组的位置
            如何解决冲突？key1,key2 -> 1
            链表：Node[1] = Node(key1,value1)
            Node{
                key,value,next
            }
            Node[1]=Node2(key2,value2)->Node1 // 头插法
            疑问：put(key1,value1),put(key2,value2) key1!=key2
           
            创建单链表的方法有两种，分别是头插法和尾插法。
            所谓头插法，就是按节点的逆序方法逐渐将结点插入到链表的头部（本来放尾的，调到头去）。
            反之尾插法就是按节点的顺序逐渐将节点插入到链表的尾部（本来放头的，调到尾去）。
            相对来说，头插法要比尾插法算法简单，但是最后产生的链表是逆序的，即第一个输入的节点实际是链表的最后一个节点。
            而为了习惯，通常用尾插法来创建链表。
            
            // 伪代码
            Put(key,value){
            
                // 计算hashcode
                hashCode = hash(key);
                
                // 计算数组位置
                Idx = hashcode % capacity;
                
                Node = Nodes[Idx];
                
                if (Node == null) {
                
                    Nodes[idx] = new Node(key,value);
                    
                } else {
                
                    // 采用头插法写入链表
                    Head = node;
                    Node[idx] = new Node(key,value);
                    Node[idx].next = head;
                }
            }
            
            Get(key) {
                
                // 找到位置
                if(Node[idx] == null) {
                
                    Return null;
                    
                    next = Nodes[idx];
                    
                    while(next == null) {
                        
                        if (key.equals(next,key)) {
                            Return next.value;
                        }
                        
                        Next = next.next;
                    }
                }
            
            }
   2）ConcurrentHashMap 
    Segments[16] segment->hashmap
    key->hashcode
    Segments[i] -> ReentrantLock // 每个分段里是个重入锁
    Put(key1,value1)
    Put(key2,value2)
#### 2 Java8 HashMap&ConcurrentHashMap
   1）元素小于8时，为链表，大于等于8时（<64 扩容 变成红黑树），链表变成红黑树，原因是提升查询的效率。
#### 3 乐观锁和悲观锁
   乐观锁比较适用于读多写少的情况(多读场景)，悲观锁比较适用于写多读少的情况(多写场景)。
       a.乐观锁是相对悲观锁而言，也是为了避免数据库幻读、业务处理时间过长等原因引起数据处理错误的一种机制，
       但乐观锁不会刻意使用数据库本身的锁机制，而是依据数据本身来保证数据的正确性。
       b.当要对数据库中的一条数据进行修改的时候，为了避免同时被其他人修改，最好的办法就是直接对该数据进行
       加锁以防止并发。这种借助数据库锁机制，在修改数据之前先锁定，再修改的方式被称之为悲观并发控制
       【Pessimistic Concurrency Control，缩写“PCC”，又名“悲观锁”】。
   1）乐观锁：synchronized，ReentrantLock
   2）悲观锁：CAS + volatile，AtomicInteger add