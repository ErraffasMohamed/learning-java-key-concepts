package annotations;

@Entity(tableName = "students")
public class Student {
    @Column(columnName = "student_id", isPrimaryKey = true)
    private int id;

    @Column(columnName = "student_name")
    private String name;


    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

