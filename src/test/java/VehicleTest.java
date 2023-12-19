import Vehicle.Car;
import Vehicle.Motorcycle;
import Vehicle.Vehicle;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleTest {
    @Test
    void checkCarInstanceOfVehicle() {
        assertThat(new Car("jemve", "fqkjpyg", 423)).isInstanceOf(Vehicle.class);
    }

    @Test
    void carHaseFourWheels() {
        assertThat(new Car("jemve", "fqkjpyg", 423).getNumWheels()).isEqualTo(4);
    }

    @Test
    void motorcycleHaseTwoWheels() {
        assertThat(new Motorcycle("jrc", "lccg", 208).getNumWheels()).isEqualTo(2);
    }

    @Test
    void carSpeedOnTestDrive() {
        Car car = new Car("jemve", "fqkjpyg", 423);
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void MotorcycleSpeedOnTestDrive() {
        Motorcycle motorcycle = new Motorcycle("jemve", "fqkjpyg", 108);
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void carSpeedOnPark() {
        Car car = new Car("jemve", "fqkjpyg", 423);
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void MotorcycleSpeedOnPark() {
        Motorcycle motorcycle = new Motorcycle("jemve", "fqkjpyg", 108);
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}