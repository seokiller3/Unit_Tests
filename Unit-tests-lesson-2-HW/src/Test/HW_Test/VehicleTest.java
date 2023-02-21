package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @BeforeEach
    public void testCarInit() {
        Car car = new Car("Dodge", "Ram", 2010);
        car.getCompany();
        car.getModel();
        car.getYearRelease();
    }

    @BeforeEach
    public void testMotoInit() {
        Motorcycle motorcycle = new Motorcycle("Kavasaki", "zx10100", 1990);
        motorcycle.getCompany();
        motorcycle.getModel();
        motorcycle.getYearRelease();
    }


    @Test
    public void testCarIsInstanceOfVehicle() {
        Car car = new Car("Dodge", "Ram", 2010);
        assertTrue(car instanceof Vehicle);
    }

    @Test
    public void testCarHasFourWheels() {
        Car car = new Car("Dodge", "Ram", 2010);
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    public void testMotoHasTwoWheels() {
        Motorcycle motorcycle = new Motorcycle("Kavasaki", "zx10100", 1990);
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    public void testCarTestDriveSpeed() {
        Car car = new Car("Dodge", "Ram", 2010);
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    public void testMotoDriveSpeed() {
        Motorcycle motorcycle = new Motorcycle("Kavasaki", "zx10100", 1990);
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    public void testCarTestDriveSpeedThanParkSpeed() {
        Car car = new Car("Dodge", "Ram", 2010);
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    public void testMotoDriveSpeedThanParkSpeed() {
        Motorcycle motorcycle = new Motorcycle("Kavasaki", "zx10100", 1990);
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}