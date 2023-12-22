import Vehicle.Car;
import Vehicle.Motorcycle;
import Vehicle.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleTest {
    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setup() {
        car = new Car("car", "perfect", 1999);
        motorcycle = new Motorcycle("motorcycle", "perfect", 1999);
    }

    @Test
    void checkCarInstanceOfVehicle() {
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    @Test
    void carHaseFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void motorcycleHaseTwoWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void carSpeedOnTestDrive() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void MotorcycleSpeedOnTestDrive() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void carSpeedOnPark() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void MotorcycleSpeedOnPark() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}