package io.javabrains;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private LocalDate issuedDate;
    private boolean isActive;
    private String firmwareVersion;

    @OneToOne(mappedBy = "accessCardId")
    private Employee owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }



    @Override
    public String toString() {
        return "AccessCard{" +
                "id=" + id +
                ", issuedDate=" + issuedDate +
                ", isActive=" + isActive +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                '}';
    }
}
