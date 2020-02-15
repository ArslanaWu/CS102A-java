import java.util.ArrayList;
import java.util.Scanner;

public class CourseTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Course> couArray = new ArrayList<>();

        while(true){
            System.out.println("Would you like to create some courses: yes or no ?");
            String reply = input.nextLine();
            if(reply.equalsIgnoreCase("no")){
                break;
            }if(reply.equalsIgnoreCase("yes")){
                inputCourseInformation(input,couArray);
            }
        }
        while(true){
            System.out.println("Would you like to obtain course information: yes or no ? ");
            String reply = input.nextLine();
            if(reply.equalsIgnoreCase("no")){
                break;
            }if(reply.equalsIgnoreCase("yes")){
                if(couArray.size() == 0){
                    System.out.println("Sorry, there are no courses in the system");
                    break;
                }
                obtainCourseInformation(input,couArray);
                printCreditCourse(input,couArray);
                printTeacherCourse(input,couArray);
            }
        }

        ArrayList<String> newcouArray = new ArrayList<>();
        for(int i = 0;i < couArray.size();i++){
            newcouArray.add(couArray.get(i).getName());
        }
        while(true){
            System.out.println("Would you like to obtain course information after removing certain courses: yes or no ?");
            String reply = input.nextLine();
            if(reply.equalsIgnoreCase("no")){
                break;
            }if(reply.equalsIgnoreCase("yes")){
                if(newcouArray.size() == 0){
                    System.out.println("Sorry, there are no courses in the system");
                    break;
                }
                removeCertainCourse(input,newcouArray);

                if(newcouArray.size() == 0){
                    System.out.println("There are no remaining courses after removing");
                    break;
                }
                printRemainingCourses(newcouArray);
            }
        }
    }
    public static void inputCourseInformation(Scanner input,ArrayList<Course> couArray){
        System.out.println("Please input the course name:");
        String name = input.nextLine();
        System.out.println("Please input the course credit:");
        int credit = inputCredit(input);
        System.out.println("Please input the course grade:");
        String grade = inputGrade(input);
        System.out.println("Please input the course teacher:");
        String teacher = input.nextLine();

        Course cou = new Course(name,credit,grade,teacher);
        couArray.add(cou);
    }
    public static int inputCredit(Scanner input){
        int credit;
        while(true){
            try{
                credit = Integer.parseInt(input.nextLine());
                break;
            }catch(NumberFormatException ex){
                System.out.println("Your input is incorrect, please input it again");
            }
        }
        return credit;
    }
    public static String inputGrade(Scanner input){
        String grade;
        while(true){
            grade = input.nextLine();
            if(grade.equalsIgnoreCase("freshman")||grade.equalsIgnoreCase("sophomore")||grade.equalsIgnoreCase("junior")||grade.equalsIgnoreCase("senior")){
                break;
            }else{
                System.out.println("Your input is incorrect, please input it again");
            }
        }
        return grade;
    }

    public static void obtainCourseInformation(Scanner input,ArrayList<Course> couArray){
        int place;
        boolean x;
        while(true){
            try{
                System.out.printf("There are %d courses in the system, please pick No.",couArray.size());
                place = Integer.parseInt(input.nextLine());
                x = couArray.get(place).isWithLab();
                break;
            }catch(IndexOutOfBoundsException ex){
                System.out.println("Your input is incorrect, please input it again");
            }
        }
        System.out.print("The course level is: ");
        System.out.println(couArray.get(place).getCourseLevel());
        System.out.printf("Is this course with lab? %b\n",x);

        System.out.println("Please enter your grade:");
        String personGrade = inputGrade(input);
        System.out.print("The result for your qualification to enroll in the course is: ");
        System.out.println(couArray.get(place).getQualificationForCourse(personGrade));
    }

    public static void printCreditCourse(Scanner input,ArrayList<Course> couArray){
        System.out.println("Input CourseTest course credit:");
        int credit = inputCredit(input);
        int occurrencee = calculateOccurrence2(couArray,credit);
        if(occurrencee == 0){
            System.out.printf("There are no courses with %d credits\n",credit);
        }else{
            System.out.printf("The courses with %d credits are [",credit);
            for(int i = 0;i < couArray.size();i++){
                int occurrence = calculateOccurrence2(couArray,credit);
                if (couArray.get(i).getCredit() == credit){
                    if(occurrence == 1){
                        System.out.print(couArray.get(i).getName());
                    }else{
                        System.out.print(couArray.get(i).getName());
                        if(i < couArray.size() - 1){
                            System.out.print(", ");
                        }
                    }
                }
                if(i == couArray.size() - 1){
                    System.out.println("]");
                }
            }
        }
    }
    public static void printTeacherCourse(Scanner input,ArrayList<Course> couArray){
        System.out.println("Input CourseTest teacher's name:");
        String teacher = input.nextLine();
        int occurrenceee = calculateOccurrence1(couArray,teacher);
        if(occurrenceee == 0){
            System.out.println("There are no courses taught by this teacher");
        }else{
            System.out.printf("The courses taught by %s are [",teacher);
            for(int i = 0;i < couArray.size();i++){
                int occurrence = calculateOccurrence1(couArray,teacher);
                if (couArray.get(i).getTeacher().toLowerCase().contains(teacher.toLowerCase())){
                    if(occurrence == 1){
                        System.out.print(couArray.get(i).getName());
                    }else{
                        System.out.print(couArray.get(i).getName());
                        if(i < couArray.size() - 1){
                            System.out.print(", ");
                        }
                    }
                }
                if(i == couArray.size() - 1){
                    System.out.println("]");
                }
            }
        }
    }
    public static void printRemainingCourses(ArrayList<String> newcouArray){
        System.out.print("The remaining courses are [");
        for(int i = 0;i < newcouArray.size();i++){
            int occurrence = newcouArray.size();
            if(occurrence == 1){
                System.out.print(newcouArray.get(i));
            }else{
                System.out.print(newcouArray.get(i));
                if(i < newcouArray.size() - 1){
                    System.out.print(", ");
                }
            }
            if(i == newcouArray.size() - 1){
                System.out.println("]");
            }
        }
    }

    public static void removeCertainCourse(Scanner input,ArrayList<String> newcouArray){
        int index;
        while(true){
            System.out.println("Please pick the index of the course you want to remove:");
            index = Integer.parseInt(input.nextLine());
            if(index < newcouArray.size() && index>-1){
                break;
            }else{
                System.out.println("Your input is incorrect, please input it again");
            }
        }
        for(int i = 0;i < newcouArray.size();i++){
            if (i == index){
                newcouArray.remove(i);
            }
        }
    }

    public static int calculateOccurrence1(ArrayList<Course> couArray,String teacher){
        int occurrence = 0;
        for(int i = 0;i < couArray.size();i++){
            if (couArray.get(i).getTeacher().toLowerCase().contains(teacher.toLowerCase())){
                occurrence = occurrence + 1;
            }
        }
        return occurrence;
    }
    public static int calculateOccurrence2(ArrayList<Course> couArray,int credit){
        int occurrence = 0;
        for(int i = 0;i < couArray.size();i++){
            if (couArray.get(i).getCredit() == credit){
                occurrence = occurrence + 1;
            }
        }
        return occurrence;
    }
}

