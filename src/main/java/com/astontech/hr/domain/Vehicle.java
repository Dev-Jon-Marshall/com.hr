package com.astontech.hr.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Jonathan.Marshall on 3/13/2017.
 */
@Entity
public class Vehicle
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleId")
    private Integer id;

    @Version
    private Integer version;

    private Integer year;
    private String licensePlate;
    private String vin;
    private String color;
    private String isPurchase;
    private Integer purchasePrice;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate purchaseDate;

    public Vehicle() {}

    public Vehicle(Integer year, String licensePlate, String vin, String color, String isPurchase, Integer purchasePrice, LocalDate purchaseDate)
    {
        this.setYear(year);
        this.setLicensePlate(licensePlate);
        this.setVin(vin);
        this.setColor(color);
        this.setIsPurchase(isPurchase);
        this.setPurchasePrice(purchasePrice);
        this.setPurchaseDate(purchaseDate);
    }


    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public Integer getYear()
    {
        return year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
    }

    public String getLicensePlate()
    {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }

    public String getVin()
    {
        return vin;
    }

    public void setVin(String vin)
    {
        this.vin = vin;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getIsPurchase()
    {
        return isPurchase;
    }

    public void setIsPurchase(String isPurchase)
    {
        this.isPurchase = isPurchase;
    }

    public Integer getPurchasePrice()
    {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }

    public LocalDate getPurchaseDate()
    {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate)
    {
        this.purchaseDate = purchaseDate;
    }
}
