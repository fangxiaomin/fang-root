package com.fang.user.JUC.cas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author:fxm
 * @createTime:2021/12/30 17:19
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("z3",24);
        User li4 = new User("li4",45);

        AtomicReference<User> atomicReferenceUser = new AtomicReference<>();
        atomicReferenceUser.set(z3);

        System.out.println(atomicReferenceUser.compareAndSet(z3,li4)+"\t "+ atomicReferenceUser.get().toString());
        System.out.println(atomicReferenceUser.compareAndSet(z3,li4)+"\t "+ atomicReferenceUser.get().toString());
    }
}

@Getter
@ToString
@AllArgsConstructor
class User {
    String userName;
    int age;
}
