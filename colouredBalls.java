/* You will reaceive 'colour: n' - where n is the number of balls until the command End.
 * Every time you receive balls they are put in a box.
 * Calculate how many balls one has to take out from the box so that all balls 
 * remaining in the box are in the same colour.
  */
import java.util.*;


public class colouredBalls {
    public static int pickedBalls(){

        HashMap<String, Integer> map = new HashMap<String, Integer>() {
        };
    while (true) {
        Scanner sc = new Scanner(System.in);

        String colouredBalls = sc.nextLine();

        if (colouredBalls.equals("End")){
            break;
        }else{
            String[] new_ball = colouredBalls.split(": ");
            String colour = new_ball[0];
            int count = Integer.parseInt(new_ball[1]);
            if (!map.containsKey(colour)){
                map.put(colour, count);
            }else{
                int value = map.get(colour);
                int new_value = value + count;
                map.replace(colour, new_value);
            }
        }
    }
    if (map.size() > 1) {
        int result = (map.values().stream().mapToInt(Integer::intValue).sum() -1);
        return result;
    }else{
        return 0;
    }
    }

    public static void main(String args []){
        System.out.println(colouredBalls.pickedBalls());
    }
}
