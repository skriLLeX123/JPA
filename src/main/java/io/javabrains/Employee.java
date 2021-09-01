package io.javabrains;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="EMPLOYEE_DATA")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name="age")
    private int age;

    @Column(name="emp_Name")
    private String name;

    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @Transient
    private String debugString;

    @OneToOne
    private AccessCard accessCardId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "EMAIL_GROUP_SUBSCRIPTIONS",
    joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
    inverseJoinColumns = @JoinColumn(name = "EMAIL_GROUP_SUBSCRIPTION_ID"))
    private List<EmailGroup> emailGroups = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<PayStub> payStub = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getDebugString() {
        return debugString;
    }

    public void setDebugString(String debugString) {
        this.debugString = debugString;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AccessCard getAccessCardId() {
        return accessCardId;
    }

    public void setAccessCardId(AccessCard accessCardId) {
        this.accessCardId = accessCardId;
    }

    public List<PayStub> getPayStubs() {
        return payStub;
    }

    public void setPayStubs(List<PayStub> payStub) {
        this.payStub = payStub;
    }

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }

    public void setEmailGroups(List<EmailGroup> emailGroups) {
        this.emailGroups = emailGroups;
    }

    public List<PayStub> getPayStub() {
        return payStub;
    }

    public void setPayStub(List<PayStub> payStub) {
        this.payStub = payStub;
    }

    public void addPayStub(PayStub payStub){
        this.payStub.add(payStub);
    }

    public void addEmailSubscription(EmailGroup emailGroup){
        this.emailGroups.add(emailGroup);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", type=" + type +
                ", debugString='" + debugString + '\'' +
                ", accessCardId=" + accessCardId +
                '}';
    }
}
