package com.example.ordersystem.goods;
abstract class ChickenWings {
public abstract String getName();
public abstract String getContent();
public abstract float getPrice();
}

class RoastChickenWings extends ChickenWings {

    @Override
    public String getName() {
        return "烤鸡翅";
    }

    @Override
    public String getContent() {
        return "null";
    }

    @Override
    public float getPrice() {
        return 10;
    }
}
class FriedChickenWings extends ChickenWings {

    @Override
    public String getName() {
        return "炸鸡翅";
    }

    @Override
    public String getContent() {
        return "null";
    }

    @Override
    public float getPrice() {
        return 10;
    }
}

abstract class ChickenLeg {
    public abstract String getName();
    public abstract String getContent();
    public abstract float getPrice();
}
class FriedChickenLeg extends ChickenLeg {

    @Override
    public String getName() {
        return "炸鸡腿";
    }

    @Override
    public String getContent() {
        return "null";
    }

    @Override
    public float getPrice() {
        return 0;
    }
}
class RoastChickenLeg extends ChickenLeg {

    @Override
    public String getName() {
        return "null";
    }

    @Override
    public String getContent() {
        return "null";
    }

    @Override
    public float getPrice() {
        return 0;
    }
}
abstract class WholeChicken {
    public abstract String getName();
    public abstract String getContent();
    public abstract float getPrice();
}
class FriedWholeChicken extends WholeChicken {

    @Override
    public String getName() {
        return "null";
    }

    @Override
    public String getContent() {
        return "null";
    }

    @Override
    public float getPrice() {
        return 0;
    }
}
class RoastWholeChicken extends WholeChicken {

    @Override
    public String getName() {
        return "null";
    }

    @Override
    public String getContent() {
        return "null";
    }

    @Override
    public float getPrice() {
        return 0;
    }
}

abstract class Methods{
   public abstract ChickenWings createChickenWings();
    public abstract ChickenLeg createChickenLeg();
    public abstract WholeChicken createWholeChicken();
}
class Roast extends Methods{

    @Override
    public ChickenWings createChickenWings() {
        return new RoastChickenWings();
    }

    @Override
    public ChickenLeg createChickenLeg() {
        return new RoastChickenLeg();
    }

    @Override
    public WholeChicken createWholeChicken() {
        return new RoastWholeChicken();
    }
}
class Fried extends Methods {
    @Override
    public ChickenWings createChickenWings() {
        return new FriedChickenWings();
    }

    @Override
    public ChickenLeg createChickenLeg() {
        return new FriedChickenLeg();
    }

    @Override
    public WholeChicken createWholeChicken() {
        return new FriedWholeChicken();
    }
}
public class Food {
    Methods roast=new Roast();
    Methods fried=new Fried();

    public Food(Methods roast, Methods fried, ChickenWings wings1, ChickenWings wings2, ChickenLeg leg1, ChickenLeg leg2, WholeChicken wholeChicken1, WholeChicken wholeChicken2) {
        this.roast = roast;
        this.fried = fried;
        this.wings1 = wings1;
        this.wings2 = wings2;
        this.leg1 = leg1;
        this.leg2 = leg2;
        this.WholeChicken1 = wholeChicken1;
        this.WholeChicken2 = wholeChicken2;
    }

    public ChickenWings getWings1() {
        return wings1;
    }

    public ChickenWings getWings2() {
        return wings2;
    }

    public ChickenLeg getLeg1() {
        return leg1;
    }

    public ChickenLeg getLeg2() {
        return leg2;
    }

    public WholeChicken getWholeChicken1() {
        return WholeChicken1;
    }

    public WholeChicken getWholeChicken2() {
        return WholeChicken2;
    }

    ChickenWings wings1=roast.createChickenWings();
    ChickenWings wings2=fried.createChickenWings();
    ChickenLeg leg1=roast.createChickenLeg();
    ChickenLeg leg2=fried.createChickenLeg();
    WholeChicken WholeChicken1=roast.createWholeChicken();
    WholeChicken WholeChicken2=fried.createWholeChicken();

}
