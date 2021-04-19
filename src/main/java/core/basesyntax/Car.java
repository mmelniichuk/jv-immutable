package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = Wheel.cloneWheel(wheels);
        this.engine = engine == null ? null : engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return new ArrayList<>(wheels);
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> listAfterAddingWheel = Wheel.cloneWheel(wheels);
        listAfterAddingWheel.add(newWheel);
        return new Car(year, color, listAfterAddingWheel, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car current = (Car) o;
        return this.year == current.year
                    && Objects.equals(this.color, current.color)
                    && Objects.equals(this.engine, current.engine)
                    && Objects.equals(this.wheels, current.wheels);
    }

    @Override
    public int hashCode() {
        int result = 11;
        result = 23 * result + year;
        result = 23 * result + (color == null ? 0 : color.hashCode());
        result = 23 * result + (engine == null ? 0 : engine.hashCode());
        result = 23 * result + (wheels == null ? 0 : wheels.hashCode());
        return result;
    }
}
