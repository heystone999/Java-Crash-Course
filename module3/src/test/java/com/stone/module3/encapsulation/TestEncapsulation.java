package com.stone.module3.encapsulation;

/**
 * 尽可能让访问范围更小
 *      private < 默认 < protected < public
 *      尤其是fields 建议设置为private
 *      想让child类用 考虑设置为protected
 */
public class TestEncapsulation {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.y);
        car.test();
    }
}
