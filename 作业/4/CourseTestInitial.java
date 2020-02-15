import java.util.ArrayList;
import java.util.Scanner;

public class CourseTestInitial {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Course> couArray = new ArrayList<>();

        while(true){
            System.out.println("Would you like to create some courses: yes or no ?");
            String reply = input.nextLine();
            if(reply.equalsIgnoreCase("no")){
                break;
            }if(reply.equalsIgnoreCase("yes")){
                String name = " ";
                int credit = 0;
                String grade = " ";
                String teacher = " ";

                System.out.println("Please input the course name:");
                name = input.nextLine();
                while(true){
                    try{
                        System.out.println("Please input the course credit:");
                        credit = Integer.parseInt(input.nextLine());
                        break;
                    }catch(NumberFormatException ex){
                        System.out.println("Your input is incorrect");
                    }
                }

                while(true){
                    System.out.println("Please input the course grade:");
                    grade = input.nextLine();
                    if(grade.equalsIgnoreCase("freshman")||grade.equalsIgnoreCase("sophomore")||grade.equalsIgnoreCase("junior")||grade.equalsIgnoreCase("senior")){
                        break;
                    }else{
                        System.out.println("Your input is incorrect");
                    }
                }
                System.out.println("Please input the course teacher:");
                teacher = input.nextLine();

                Course cou = new Course(name,credit,grade,teacher);
                couArray.add(cou);
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
                System.out.printf("There are %d courses in the system, please pick No.",couArray.size());
                int place = Integer.parseInt(input.nextLine());
                boolean x = couArray.get(place).isWithLab();
                System.out.print("The course level is: ");
                System.out.println(couArray.get(place).getCourseLevel());
                System.out.printf("Is this course with lab? %b\n",x);

                System.out.println("Please enter your grade:");
                String personGrade = input.nextLine();
                System.out.print("The result for your qualification to enroll in the course is: ");
                System.out.println(couArray.get(place).getQualificationForCourse(personGrade));

                System.out.println("Input CourseTest course credit:");
                int credit = Integer.parseInt(input.nextLine());
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


                System.out.println("Input CourseTest teacher's name:");
                String teacher = input.nextLine();
                int occurrenceee = calculateOccurrence1(couArray,teacher);
                if(occurrenceee == 0){
                    System.out.println("There are no courses taught by this teacher");
                    break;
                }else{
                    System.out.printf("The courses taught by %s are [",teacher);
                    for(int i = 0;i < couArray.size();i++){
                        int occurrence = calculateOccurrence1(couArray,teacher);
                        if (couArray.get(i).getTeacher().toLowerCase().contains(teacher)){
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
                System.out.println("Please pick the index of the course you want to remove:");
                int index = Integer.parseInt(input.nextLine());

                for(int i = 0;i < newcouArray.size();i++){
                    if (i == index){
                        newcouArray.remove(i);
                    }
                }
                if(newcouArray.size() == 0){
                    System.out.println("There are no remaining courses after removing");
                    break;
                }
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
        }
    }
    public static int calculateOccurrence1(ArrayList<Course> couArray,String teacher){
        int occurrence = 0;
        for(int i = 0;i < couArray.size();i++){
            if (couArray.get(i).getTeacher().toLowerCase().contains(teacher)){
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

