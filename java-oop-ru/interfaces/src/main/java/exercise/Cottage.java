package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        return Double.compare(area, another.getArea());
    }

    public String toString() {
        return "%s этажный коттедж площадью %s метров".formatted(floorCount, getArea());
    }
}
// END
