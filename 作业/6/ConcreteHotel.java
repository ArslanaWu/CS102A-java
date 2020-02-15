import java.util.ArrayList;
import java.util.List;

public class ConcreteHotel implements Hotel {
    private List<Room> rooms = new ArrayList<>();
    private Day currentDay = Day.MONDAY;

    private ArrayList<Double> incomes = new ArrayList<>();
    private int whichDay = 0;

    @Override
    public void addRoom(int type, int count) {
        if (type == 0) {
            for(int i = 0;i < count;i++){
                rooms.add(new LuxuryRoom());
            }
        }else if(type == 1){
            for(int i = 0;i < count;i++){
                rooms.add(new OrdinaryRoom());
            }
        }
    }

    @Override
    public void addRoom(Room room) {
        if(room.getType() == 0){
            rooms.add(room);
        }else if(room.getType() == 1){
            rooms.add(room);
        }
    }

    @Override
    public void setPrice(int type, double price) {
        if(type == 0){
            LuxuryRoom.setBasicPrice(price);
        }else{
            OrdinaryRoom.setBasicPrice(price);
        }
    }

    @Override
    public double getPrice(int type) {
        if(type == 0){
            return LuxuryRoom.getBasicPrice();
        }else{
            return OrdinaryRoom.getBasicPrice();
        }
    }

    @Override
    public double getRoomPrice(String number) {
        for(Room room : rooms){
            if(room.getNumber().equals(number)){
                if(!room.getCheckIn()){
                    return 0;
                }else{
                    if(room.getType() == 0){
                        if(room.anotherSettings() == -1){
                            return LuxuryRoom.getBasicPrice() * currentDay.getRate() + 250;
                        }else if(room.anotherSettings() == -2){
                            return LuxuryRoom.getBasicPrice() * currentDay.getRate();
                        }
                    }else if(room.getType() == 1){
                        return + OrdinaryRoom.getBasicPrice() * currentDay.getRate() + room.anotherSettings() * 180;
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public void displayAllRooms() {
        for(Room room : rooms){
            System.out.println(room);
        }
    }

    @Override
    public List<Room> getAllCheckedRooms() {
        ArrayList<Room> checked = new ArrayList<>();
        for(Room room : rooms){
            if(room.getCheckIn()){
                checked.add(room);
            }
        }
        return checked;
    }

    @Override
    public void displayEveryDayInfo() {
        Day[] days = Day.values();
        for(Day day : days){
            System.out.println(day.toString());
        }
    }

    @Override
    public void displayTodayInfo() {
        Day[] days = Day.values();
        for(Day day : days){
            if(currentDay == day){
                System.out.println(day.toString());
                break;
            }
        }
    }

    @Override
    public void checkIn(int type, int number) {
        for(Room room : rooms){
            if(room.getType() == type){
                if(!room.getCheckIn()){
                    room.setCheckIn(true);
                    room.checkIn(number);
                    break;
                }
            }
        }
    }

    @Override
    public void checkOut(String... roomNumber) {
        double income = 0;
        for(Room room : rooms){
            if(room.getCheckIn()){
                if(room.getType() == 0){
                    if(room.anotherSettings() == -1){
                        income = income + LuxuryRoom.getBasicPrice() * currentDay.getRate() + 250;
                    }else if(room.anotherSettings() == -2){
                        income = income + LuxuryRoom.getBasicPrice() * currentDay.getRate();
                    }
                }else if(room.getType() == 1){
                    income = income + OrdinaryRoom.getBasicPrice() * currentDay.getRate() + room.anotherSettings() * 180;
                }
            }
        }

        incomes.add(income);
        whichDay = whichDay + 1;


        for(int i = 0;i < roomNumber.length;i++){
            for(Room room : rooms){
                if(room.getNumber().equals(roomNumber[i])){
                    room.setCheckIn(false);
                    room.checkOut();
                }
            }
        }

        Day[] days = Day.values();
        if(currentDay == Day.SUNDAY){
            currentDay = Day.MONDAY;
        }else{
            for(int i = 0;i < days.length;i++){
                if(days[i] == currentDay){
                    currentDay = days[i + 1];
                    break;
                }
            }
        }
    }

    @Override
    public double income() {
        return incomes.get(whichDay - 1);
    }

    @Override
    public double income(int recentTimes) {
        double income = 0;
        for(int i = 1;i <= recentTimes;i++){
            income = income + incomes.get(whichDay - i);
        }
        return income;
    }

}
