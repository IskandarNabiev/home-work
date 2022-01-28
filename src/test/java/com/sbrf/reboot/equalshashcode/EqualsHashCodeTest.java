package com.sbrf.reboot.equalshashcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EqualsHashCodeTest {

     class Car {
        String model;
        String color;
        Calendar releaseDate;
        int maxSpeed;

        @Override
        public boolean equals(Object o) {

            //Рефлексивность: объект должен равняться самому себе
            if (o == this)
                return true;
            // Cравнение объектов двух одинаковых классов и сравнение на null
            if (o == null || getClass() != o.getClass())
                return false;
            //Приведение к типу класса
            Car otherCarObj = (Car) o;
            //Симметричность: если a.equals(b) == true, то и b.equals(a) должно возвращать true
            return model.equals(otherCarObj.model) &&  color.equals(otherCarObj.color) &&
                    releaseDate.equals(otherCarObj.releaseDate) && maxSpeed == otherCarObj.maxSpeed;
        }

        @Override
        public int hashCode() {
            //Можем умножить каждое поле на 31 или 29, чтобы уменьшить вероятность коллизий
            int result = maxSpeed;
            result = result + model.hashCode();
            result = result + color.hashCode();
            result = result + releaseDate.hashCode();
            return result;
        }


     }

     class Moto {
         String model;
         String color;
         Calendar releaseDate;
         int maxSpeed;


         @Override
         public boolean equals(Object o) {
             if (o == this)
                 return true;
             if (o == null || getClass() != o.getClass())
                 return false;
             Moto otherMotoObj = (Moto) o;
             return model.equals(otherMotoObj.model) &&  color.equals(otherMotoObj.color) &&
                     releaseDate.equals(otherMotoObj.releaseDate) && maxSpeed == otherMotoObj.maxSpeed;
         }

         @Override
         public int hashCode() {
             int result = maxSpeed;
             result = result + model.hashCode();
             result = result + color.hashCode();
             result = result + releaseDate.hashCode();
             return result;
         }
     }

    @Test
    public  void assertTrueEquals() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, 0, 25);
        car2.maxSpeed = 10;


        Assertions.assertTrue(car1.equals(car2));
    }

    @Test
    public void assertFalseEquals() {
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertFalse(car1.equals(car2));
    }

    @Test
    public void successEqualsHashCode(){
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Mercedes";
        car2.color = "black";
        car2.releaseDate = new GregorianCalendar(2020, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertEquals(car1.hashCode(),car2.hashCode());

    }

    @Test
    public void failEqualsHashCode(){
        Car car1 = new Car();
        car1.model = "Mercedes";
        car1.color = "black";
        car1.releaseDate = new GregorianCalendar(2020, 0, 25);
        car1.maxSpeed = 10;

        Car car2 = new Car();
        car2.model = "Audi";
        car2.color = "white";
        car2.releaseDate = new GregorianCalendar(2017, 0, 25);
        car2.maxSpeed = 10;

        Assertions.assertNotEquals(car1.hashCode(),car2.hashCode());

    }

    @Test
    public void notEqualClass() {
        Car car = new Car();
        car.model = "Mercedes";
        car.color = "black";
        car.releaseDate = new GregorianCalendar(2020, 0, 25);
        car.maxSpeed = 10;

        Moto moto = new Moto();
        moto.model = "Mercedes";
        moto.color = "black";
        moto.releaseDate = new GregorianCalendar(2020, 0, 25);
        moto.maxSpeed = 10;

        Assertions.assertTrue(car.equals(moto));
    }


}
