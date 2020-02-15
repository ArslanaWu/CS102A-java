public class Course {
    private String name;
    private int credit;
    private String grade;
    private String teacher;

    public Course(String name){
        this.name = name;
    }
    public Course(String name, int credit, String grade, String teacher){
        this.name = name;
        this.credit = credit;
        this.grade = grade;
        this.teacher = teacher;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getCredit(){
        return credit;
    }
    public void setCredit(int credit){
        this.credit = credit;
    }
    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    public String getTeacher(){
        return teacher;
    }
    public void setTeacher(String teacher){
        this.teacher = teacher;
    }

    public String toString(){
        return name;
    }
    public String getCourseLevel() {
        if(grade.equalsIgnoreCase("junior") || grade.equalsIgnoreCase("senior")){
            return "major course";
        }else if(grade.equalsIgnoreCase("freshman") || grade.equalsIgnoreCase("sophomore")){
            return "common course";
        }else{
            return "not valid query";
        }
    }
    public String getQualificationForCourse(String personGrade) {
        if(getCourseLevel().equalsIgnoreCase("major course")){
            if(personGrade.equalsIgnoreCase("freshman") || personGrade.equalsIgnoreCase("sophomore")){
                return "You are not qualified for the course";
            }else if(personGrade.equalsIgnoreCase("junior") || personGrade.equalsIgnoreCase("senior")){
                return "You are qualified for the course";
            }else{
                return "not valid query";
            }
        }else if(getCourseLevel().equalsIgnoreCase("common course")){
            if(personGrade.equalsIgnoreCase("freshman") || personGrade.equalsIgnoreCase("sophomore")){
                return "You are qualified for the course";
            }else if(personGrade.equalsIgnoreCase("junior") || personGrade.equalsIgnoreCase("senior")){
                return "You are not qualified for the course";
            }else{
                return "not valid query";
            }
        }else{
            return "not valid query";
        }
    }
    public boolean isWithLab(){
        if(credit == 3){
            return true;
        }else{
            return false;
        }
    }
}
