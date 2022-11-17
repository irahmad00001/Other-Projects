public class Course {
    //Create variables
    private int id ;
    private String name;
    private int credit ;
    private float score ;

    //Constructors
    public Course(int id, String name, int credit, float score) {
        this.id = id;
        this.name =name;
        this.credit = credit;
        this.score = score;
    }
    public Course() {
    }

    //Setter & Getter Methods
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }


    public void setCredit(int credit) {
        this.credit = credit;
    }
    public int getCredit(){
        return this.credit;
    }

    public void setScore(float score) {
        this.score = score;
    }
    public float getScore(){
        return this.score;
    }

    @Override
    public String toString() {
        String tmp = "\t\t\t\tCourse ID:"+ Integer.toString(id)+ "\n\t\t\t\tCourse Name:"
                + name +"\n\t\t\t\tCourse Credit:"+Integer.toString(credit)
                + "\n\t\t\t\tCourse Score:" +Float.toString(score);
        return tmp;
    }
}

