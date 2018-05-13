package com.transport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String bookerAddress;
    private String mobileNumber;
    private String pickupLocation;
    private String dropLocation;
    private String materialType;
    private Status status = Status.OPEN;
    private String notes;//for admin


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookerAddress() {
        return bookerAddress;
    }

    public void setBookerAddress(String bookerAddress) {
        this.bookerAddress = bookerAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    enum Status{
        OPEN,INPROGRESS,LOST,WIN,CLOSE;
    }

}
