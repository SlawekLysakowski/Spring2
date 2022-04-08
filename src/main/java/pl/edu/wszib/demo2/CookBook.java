package pl.edu.wszib.demo2;

import java.time.Duration;

public class CookBook {
    private Integer id;
    private String nazwa;
    private Integer duration;
     String[] Ingredients;
//    enum Ingredients {
//        POTATOS,
//        VEGETABLES,
//        MEAT
//    }
//    private Ingredients ingredients;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String[] getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String[] ingredients) {
        Ingredients = ingredients;
    }
}
