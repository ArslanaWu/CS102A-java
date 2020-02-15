public class LuxuryRoom extends Room{



    private static double basicPrice = 1200;
    private boolean addBed = false;
    private final int addBedPrice = 250;

    public LuxuryRoom(){
        super();
    }

    public static double getBasicPrice() {
        return basicPrice;
    }

    public static void setBasicPrice(double basicPrice) {
        LuxuryRoom.basicPrice = basicPrice;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public int anotherSettings() {
        if(addBed){
            return -1;
        }else{
            return -2;
        }
    }

    public boolean isAddBed() {
        return addBed;
    }

    public void setAddBed(boolean addBed) {
        this.addBed = addBed;
    }

    @Override
    public void checkIn(int number) {
        if(number == 3){
            addBed = true;
        }
    }

    @Override
    public void checkOut() {
        addBed = false;
    }

    @Override
    public String toString(){
        return String.format("L %s %s",getNumber(),this.addBed);
    }

}
