public class Employee {

  private Integer Id;
  private String name;
  private String doj;

  public Employee(Integer id, String name, String doj) {
    Id = id;
    this.name = name;
    this.doj = doj;
  }

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDoj() {
    return doj;
  }

  public void setDoj(String doj) {
    this.doj = doj;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "Id=" + Id +
        ", name='" + name + '\'' +
        ", doj='" + doj + '\'' +
        '}';
  }
}
