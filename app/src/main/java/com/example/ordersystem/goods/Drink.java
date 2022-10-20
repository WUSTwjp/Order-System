package com.example.ordersystem.goods;
abstract class DrinkOrder{
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public abstract float cost();
    private float price;

}
class Coffee extends DrinkOrder{

    public Coffee() {
        setPrice(10.0f);
    }

    @Override
    public float cost() {
        return 10.0f;
    }
}
class Coke extends DrinkOrder{


    public Coke() {
        setPrice(10.0f);
    }

    @Override
    public float cost() {
        return 10.0f;
    }
}
class Milk extends DrinkOrder{

    public Milk() {
        setPrice(10.0f);
    }

    @Override
    public float cost() {
        return 10.0f;
    }
}
abstract class Decorator extends DrinkOrder{
    private DrinkOrder drinkOrder;

    public Decorator(DrinkOrder drinkOrder) {
        this.drinkOrder = drinkOrder;
    }

    public DrinkOrder getDrinkOrder() {
        return drinkOrder;
    }
}

class Sugar extends Decorator{

    public Sugar(DrinkOrder drinkOrder) {
        super(drinkOrder);
        setPrice(1.0f);
    }

    @Override
    public float cost() {
        return 1.0f;
    }
}

class Ice extends Decorator{


    public Ice(DrinkOrder drinkOrder) {
        super(drinkOrder);
        setPrice(1.0f);
    }

    @Override
    public float cost() {
        return 1.0f;
    }
}
public class Drink {
    DrinkOrder drinkOrder;
    float cost=0;
    public Drink(DrinkOrder drinkOrder) {
        this.drinkOrder = drinkOrder;
        cost=drinkOrder.getPrice();
    }
    public DrinkOrder addCoffee(){
        return new Coffee();
    }
    public DrinkOrder addCoke(){
        return new Coke();
    }
    public DrinkOrder addMilk(){
        return new Milk();
    }
    public void addSugar(){
        cost+=drinkOrder.getPrice();
    }
    public void addIce(){
        cost+=drinkOrder.getPrice();
    }
    public DrinkOrder getDrinkOrder() {
        return drinkOrder;
    }
    public float getCost(){
        return cost;
    }
    public void setDrinkOrder(DrinkOrder drinkOrder) {
        this.drinkOrder = drinkOrder;
    }
}
