package ru.mirea.nikitina.practice2;

public class Worker {

    private String firstName;

    private String lastName;

    private int age;

    private String gender;

    private String catName;

    private String division;

    private String position;

    private int salary;

    private int bonus;

    private int lengthOfEmployment;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getLengthOfEmployment() {
        return lengthOfEmployment;
    }

    public void setLengthOfEmployment(int lengthOfEmployment) {
        this.lengthOfEmployment = lengthOfEmployment;
    }

    public Worker(String firstName, String lastName, int age, String gender, String catName, String division, String position, int salary, int bonus, int lengthOfEmployment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.catName = catName;
        this.division = division;
        this.position = position;
        this.salary = salary;
        this.bonus = bonus;
        this.lengthOfEmployment = lengthOfEmployment;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Имя: ").append(firstName).append('\n');
        sb.append("Фамилия: ").append(lastName).append('\n');
        sb.append("Возраст: ").append(age).append('\n');
        sb.append("Пол: ").append(gender).append('\n');
        if (catName != null){
            sb.append("Имя кота: ").append(catName).append('\n');
        }
        sb.append("Название отдела: ").append(division).append('\n');
        sb.append("Должность: ").append(position).append('\n');
        sb.append("Зарплата: ").append(salary).append('\n');
        if (bonus > 0){
            sb.append("Премия: ").append(bonus).append('\n');
        }
        sb.append("Длительность работы в компании (в годах): ").append(lengthOfEmployment).append('\n');
        return sb.toString();
    }
}
