public class OrdinaryRoom extends Room {


    private static double basicPrice = 500;
    private int breakfastCount = 0;



    public OrdinaryRoom(){
        super();
    }

    public static double getBasicPrice() {
        return basicPrice;
    }

    public static void setBasicPrice(double basicPrice) {
        OrdinaryRoom.basicPrice = basicPrice;
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public int anotherSettings() {
        return breakfastCount;
    }

    @Override
    public void checkIn(int number) {
        breakfastCount = number;
    }

    @Override
    public void checkOut() {
        breakfastCount = 0;
    }

    @Override
    public String toString(){
        return String.format("O %s %d",getNumber(),this.breakfastCount);
    }
}
