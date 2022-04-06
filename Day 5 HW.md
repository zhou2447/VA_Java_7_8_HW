# Day 5 HW

1.  Lock
    1.  synchronized
        *   The synchronized keyword may be applied to a method or statement block and provides protection for critical sections that should only be executed by one thread at a time.
        *   The synchronized keyword prevents a critical section of code from being executed by more than one thread at a time.
        *   When applied to a static method, as with MySyncStaticMethod in the examples above, the entire class is locked while the method is being executed by one thread at a time.
        *   When applied to an instance method, as with MySyncMethod in the examples above, the instance is locked while being accessed by one thread at at time.
        *   When applied to an object or array, the object or array is locked while the associated code block is executed by one thread at at time.
        ~~~
        public class MyClass
        {
            public synchronized static String mySyncStaticMethod() {

            }
            public synchronized String mySyncMethod() {

            }
        }
        public class MyOtherClass {
            Object someObj;
            public String myMethod() {
                ...
                synchronized (someObj) {
                ...
                }
            }
        }
        ~~~
    2.  Lock
        *   Compared to synchronized which is implicit monitor lock, Lock class provides more functionality and flexibility, such as chain-locking and tryLock().
        *   Lock implementations provide more extensive locking operations than can be obtained using synchronized methods and statements. They allow more flexible structuring, may have quite different properties, and may support multiple associated Condition objects. 
        *   A lock is a tool for controlling access to a shared resource by multiple threads. Commonly, a lock provides exclusive access to a shared resource: only one thread at a time can acquire the lock and all access to the shared resource requires that the lock be acquired first. However, some locks may allow concurrent access to a shared resource, such as the read lock of a ReadWriteLock.
        ~~~
        Lock l = ...;
        l.lock();
        try {
            // access the resource protected by this lock
        } finally {
            l.unlock();
        }
        ~~~

2.  Lock interface
    ~~~
    public interface Lock
    ~~~
    1.  lock()
        >   Acquires the lock.
        >   If the lock is not available then the current thread becomes disabled for thread scheduling purposes and lies dormant until the lock has been acquired.

        >   **Implementation Considerations**

        >   A Lock implementation may be able to detect erroneous use of the lock, such as an invocation that would cause deadlock, and may throw an (unchecked) exception in such circumstances. The circumstances and the exception type must be documented by that Lock implementation.


        ~~~
        void lock();
        ~~~

    2.  unlock()
        >   Releases the lock.

        >   **Implementation Considerations**

        >   A Lock implementation will usually impose restrictions on which thread can release a lock (typically only the holder of the lock can release it) and may throw an (unchecked) exception if the restriction is violated. Any restrictions and the exception type must be documented by that Lock implementation.

        ~~~
        void unlock();
        ~~~

    3.  newCondition()
        >   Returns a new Condition instance that is bound to this Lock instance. Before waiting on the condition the lock must be held by the current thread. A call to Condition.await() will atomically release the lock before waiting and re-acquire the lock before the wait returns.
        
        >   **Implementation Considerations**

        >   The exact operation of the Condition instance depends on the Lock implementation and must be documented by that implementation.
        
        >   **Returns:**
        >   A new Condition instance for this Lock instance
        
        >   **Throws:**
        >   UnsupportedOperationException - if this Lock implementation does not support conditions

        ~~~
        Condition newConditon();
        ~~~

    4.  tryLock()
        ~~~
        boolean tryLock();
        ~~~
        **Usage Idiom**
        ~~~
        Lock lock = ...;
        if (lock.tryLock()) {
            try {
                // manipulate protected state
            } finally {
                lock.unlock();
            }
        } else {
            // perform alternative actions
        }
        ~~~

        >   Acquires the lock only if it is free at the time of invocation.
        >   This usage ensures that the lock is unlocked if it was acquired, and doesn't try to unlock if the lock was not acquired.

        >   **Returns:**

        >   true if the lock was acquired and false otherwise

        ~~~
        boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
        ~~~

        >   Acquires the lock if it is free within the given waiting time and the current thread has not been interrupted.

        >   **Parameters:**

        >   time - the maximum time to wait for the lock

        >   unit - the time unit of the time argument

        >   **Returns:**

        >   true if the lock was acquired and false if the waiting time elapsed before the lock was acquired

        >   **Throws:**

        >   InterruptedException - if the current thread is interrupted while acquiring the lock (and interruption of lock acquisition is supported)

    5.  lockInterruptibly();
        ~~~
        void lockInterruptibly() throws InterruptedException;
        ~~~

        >   Acquires the lock unless the current thread is interrupted.

        >   Acquires the lock if it is available and returns immediately.

        >   **Implementation Considerations**

        >   The ability to interrupt a lock acquisition in some implementations may not be possible, and if possible may be an expensive operation. The programmer should be aware that this may be the case. An implementation should document when this is the case.

        >   An implementation can favor responding to an interrupt over normal method return.

        >   A Lock implementation may be able to detect erroneous use of the lock, such as an invocation that would cause deadlock, and may throw an (unchecked) exception in such circumstances. The circumstances and the exception type must be documented by that Lock implementation.

        >   **Throws:**

        >   InterruptedException - if the current thread is interrupted while acquiring the lock (and interruption of lock acquisition is supported).
        
3.  ReentrantLock class
    ~~~
    public class ReentrantLock extends Object implements Lock, Serializable
    ~~~

    >   A reentrant mutual exclusion Lock with the same basic behavior and semantics as the implicit monitor lock accessed using synchronized methods and statements, but with extended capabilities.
    
    >   A ReentrantLock is owned by the thread last successfully locking, but not yet unlocking it. A thread invoking lock will return, successfully acquiring the lock, when the lock is not owned by another thread. The method will return immediately if the current thread already owns the lock. This can be checked using methods isHeldByCurrentThread(), and getHoldCount().

    >   The constructor for this class accepts an optional fairness parameter. When set true, under contention, locks favor granting access to the longest-waiting thread. Otherwise this lock does not guarantee any particular access order. Programs using fair locks accessed by many threads may display lower overall throughput (i.e., are slower; often much slower) than those using the default setting, but have smaller variances in times to obtain locks and guarantee lack of starvation. Note however, that fairness of locks does not guarantee fairness of thread scheduling. Thus, one of many threads using a fair lock may obtain it multiple times in succession while other active threads are not progressing and not currently holding the lock. Also note that the untimed tryLock method does not honor the fairness setting. It will succeed if the lock is available even if other threads are waiting.

    >   It is recommended practice to always immediately follow a call to lock with a try block, most typically in a before/after construction such as:
    ~~~
    class X {
        private final ReentrantLock lock = new ReentrantLock();
        // ...
        public void m() {
            lock.lock();  // block until condition holds
            try {
                // ... method body
            } finally {
                lock.unlock()
            }
        }
    }
    ~~~

4.  ReadWriteLock interface
    ~~~
    public interface ReadWriteLock
    ~~~
    >   A ReadWriteLock maintains a pair of associated locks, one for read-only operations and one for writing. The read lock may be held simultaneously by multiple reader threads, so long as there are no writers. The write lock is exclusive.
    1.  method
        1.  Lock readLock()
            ~~~
            Lock readLock();
            ~~~
            >   Returns the lock used for reading.
        2.  Lock writeLock()
            ~~~
            Lock writeLock();
            ~~~
            >   Returns the lock used for writing.
    2.  ReentrantReadWriteLock
        ~~~
        public class ReentrantReadWriteLock extends Object implements ReadWriteLock, Serializable
        ~~~
        >   An implementation of ReadWriteLock supporting similar semantics to ReentrantLock.

        >   Here is a code sketch showing how to perform lock downgrading after updating a cache (exception handling is particularly tricky when handling multiple locks in a non-nested fashion):
        ~~~
        class CachedData {
            Object data;
            volatile boolean cacheValid;
            final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

            void processCachedData() {
                rwl.readLock().lock();
                if (!cacheValid) {
                    // Must release read lock before acquiring write lock
                    rwl.readLock().unlock();
                    rwl.writeLock().lock();
                    try {
                        // Recheck state because another thread might have
                        // acquired write lock and changed state before we did.
                        if (!cacheValid) {
                            data = ...
                            cacheValid = true;
                        }
                    // Downgrade by acquiring read lock before releasing write lock
                    rwl.readLock().lock();
                    } finally {
                        rwl.writeLock().unlock(); // Unlock write, still hold read
                    }
                }

                try {
                    use(data);
                } finally {
                    rwl.readLock().unlock();
                }
            }
        }
        ~~~


5.  Future vs CompletableFuture
    1.  Futrue
        ~~~
        public interface Future<V>
        ~~~
        >   A Future represents the result of an asynchronous computation. Methods are provided to check if the computation is complete, to wait for its completion, and to retrieve the result of the computation. The result can only be retrieved using method get when the computation has completed, blocking if necessary until it is ready. Cancellation is performed by the cancel method. Additional methods are provided to determine if the task completed normally or was cancelled. Once a computation has completed, the computation cannot be cancelled.
    2.  CompletableFuture
        ~~~
        public class CompletableFuture<T> extends Object implements Future<T>, CompletionStage<T>
        ~~~

        >   A Future that may be explicitly completed (setting its value and status), and may be used as a CompletionStage, supporting dependent functions and actions that trigger upon its completion. 
        >   When two or more threads attempt to complete, completeExceptionally, or cancel a CompletableFuture, only one of them succeeds.