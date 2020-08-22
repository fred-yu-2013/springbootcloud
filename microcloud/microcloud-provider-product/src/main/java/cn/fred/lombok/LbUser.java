package cn.fred.lombok;

import lombok.extern.java.Log;
import lombok.val;

@Log
public class LbUser {
    public static void main(String[] args) {
        testVal();
    }

    private static void testVal() {
        // 相当于val= final LbStudent, 不需要final用var
        val student = new LbStudent();
        student.setName("张三");
        student.setAge(24);
        log.info("student is " + student);
    }
}
