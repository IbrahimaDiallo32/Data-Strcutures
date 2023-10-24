public class Rectangle {
        private double width;
        private double height;
    //has data for default rectangle object
        public Rectangle(){
            width=1.0;
            height=1.0;
        }
        //takes in 2 integers to create a custom rectangle object
        public Rectangle(int x, int y){
            width =x;
            height =y;
        }
        //returns width
        public double getWidth(){
            return width;
        }
        //returns height
        public double getHeight(){
            return height;
        }
        //calculates area
        public double getArea(){
            double area= width*height;
            return area;
        }
        //calculates perimeter
        public double getPerimeter(){
            double perimeter = (width+height)*2;
            return perimeter;
        }
        //prints valuable information about object using its data
        public void printRectangle(String name){
            System.out.println("Rectangle " + name + " is " + width + " units wide and " + height + " units high.");
        }
    }

