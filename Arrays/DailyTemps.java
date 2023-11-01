import java.util.Scanner;
public class DailyTemps{
    Scanner myScanner = new Scanner(System.in);
    int [] temperatures = new int[7];
    String [] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    //this constructor collects user input and assigns it to an index in array of temperatures
    public DailyTemps(){
        System.out.print("Monday:      ");
        temperatures[0] = myScanner.nextInt();
        System.out.print("Tuesday:     ");
        temperatures[1] = myScanner.nextInt();
        System.out.print("Wednesday:   ");
        temperatures[2] = myScanner.nextInt();
        System.out.print("Thursday:    ");
        temperatures[3] = myScanner.nextInt();
        System.out.print("Friday:      ");
        temperatures[4] = myScanner.nextInt();
        System.out.print("Saturday:    ");
        temperatures[5] = myScanner.nextInt();
        System.out.print("Sunday:      ");
        temperatures[6] = myScanner.nextInt();

    }
    //this method will take in an index for day of week and set to a new temperature which is also passed in.
    public void setTemp(int index ,int newTemp){
        temperatures[index] = newTemp;
    }
    //returns the amount of days it was freezing in the week
    public int freezing(){
        int counter =0;
        for(int i=0; i< temperatures.length; i++){
            //if the temperature at index is freezing it will add one to the counter
            if(temperatures[i]<32){
                counter++;
            }
        }
        return counter;
    }
    //this function will return the warmest day of the week as an index. It assumes the first index is the highest then compares its value with every other index in the array.
    public int warmest(){
        int highest = temperatures[0];
        int index=0;
        for(int i=0; i<temperatures.length; i++){
            if(highest <temperatures[i]){
                highest = temperatures[i];
                index =i;
            }
        }
        return index;
    }
    //This will print the days of the week along with their temperature
    public void printTemps(){
        for(int i=0; i< temperatures.length; i++){
            System.out.println(days[i] + ":     " + temperatures[i]);
        }
    }

}