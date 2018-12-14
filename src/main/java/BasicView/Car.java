/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicView;

/**
 *
 * @author JHON
 */
public class Car {
    
    String randomId;
    int randomYear;
    String randomColor;
    String randomBrand;
    int randomPrice;
    boolean randomSoldState;

    public Car(String randomId, String randomBrand, int randomYear, String randomColor, int randomPrice, boolean randomSoldState) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getRandomId() {
        return randomId;
    }

    public void setRandomId(String randomId) {
        this.randomId = randomId;
    }

    public int getRandomYear() {
        return randomYear;
    }

    public void setRandomYear(int randomYear) {
        this.randomYear = randomYear;
    }

    public String getRandomColor() {
        return randomColor;
    }

    public void setRandomColor(String randomColor) {
        this.randomColor = randomColor;
    }

    public String getRandomBrand() {
        return randomBrand;
    }

    public void setRandomBrand(String randomBrand) {
        this.randomBrand = randomBrand;
    }

    public int getRandomPrice() {
        return randomPrice;
    }

    public void setRandomPrice(int randomPrice) {
        this.randomPrice = randomPrice;
    }

    public boolean isRandomSoldState() {
        return randomSoldState;
    }

    public void setRandomSoldState(boolean randomSoldState) {
        this.randomSoldState = randomSoldState;
    }
    
            
}
