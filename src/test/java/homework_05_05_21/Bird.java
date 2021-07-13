package homework_05_05_21;

public class Bird {
    String color;
    String name;
    int height;


    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor (String color) {
        this.color = color;
    }

    public String getInfo() {
        return "This bird is popug " + this.getName() + " and it is " + this.getColor() + " with " + this.height + " cm tall";
    }
}
