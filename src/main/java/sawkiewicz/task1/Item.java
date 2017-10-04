package sawkiewicz.task1;

public class Item {
    private char name;
    private int unit;

    public Item(char name, int unit) {
        this.name = name;
        this.unit = unit;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int giveTotalPrice() {
        int price = 0;
        int specialUnitNumber = 0;
        int specialPrice = 0;

        switch (name) {
            case 'A':
                price = 40;
                specialUnitNumber = 3;
                specialPrice = 70;
                break;
            case 'B':
                price = 10;
                specialUnitNumber = 2;
                specialPrice = 15;
                break;
            case 'C':
                price = 30;
                specialUnitNumber = 4;
                specialPrice = 60;
                break;
            case 'D':
                price = 25;
                specialUnitNumber = 2;
                specialPrice = 40;
                break;
            default:
                break;
        }

        return unit / specialUnitNumber * specialPrice + unit % specialUnitNumber * price;
    }

}
