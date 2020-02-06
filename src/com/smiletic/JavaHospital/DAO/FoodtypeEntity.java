package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FOODTYPE", schema = "main", catalog = "")
public class FoodtypeEntity {
    private Short idFoodType;
    private String foodType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDFoodType")
    public Short getIdFoodType() {
        return idFoodType;
    }

    public void setIdFoodType(Short idFoodType) {
        this.idFoodType = idFoodType;
    }

    @Basic
    @Column(name = "FoodType")
    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return foodType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodtypeEntity that = (FoodtypeEntity) o;
        return Objects.equals(idFoodType, that.idFoodType) &&
                Objects.equals(foodType, that.foodType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFoodType, foodType);
    }
}
