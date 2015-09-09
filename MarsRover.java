import java.io.*;
import java.util.*;
import java.util.StringTokenizer;



public class MarsRover {

    static String instructions1, instructions2;
    static Terrain mars;
    static Rover rover1, rover2;

    public static void main(String[] args) throws IOException {

        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        String line;
        int count = 1;

        while( (line = file.readLine()) != null) {
            String[] st = line.split("\\s");
            int x, y;
            String letter;

            switch (count) {
                case 1:
                        x = Integer.parseInt(st[0]);
                        y = Integer.parseInt(st[1]);
                        mars = new Terrain(x,y);
                        break;
                case 2:
                        x = Integer.parseInt(st[0]);
                        y = Integer.parseInt(st[1]);
                        letter = st[2];
                        rover1 = new Rover(x, y, letter);
                        break;
                case 3:
                        instructions1 = st[0];
                        break;
                case 4:
                        x = Integer.parseInt(st[0]);
                        y = Integer.parseInt(st[1]);
                        letter = st[2];
                        rover2 = new Rover(x, y, letter);
                        break;
                case 5:
                        instructions2 = st[0];
                        break;
                default:
                        System.out.println("You should never see this message.");
                        break;
            }
            count += 1;
        }

        runApp();
    }

    public static void runApp(){

        rover1.setTerrain(mars);
        rover1.executeInstructions(instructions1);
        int[] rover1Position = rover1.getPosition();
        System.out.println(rover1Position[0] + " " + rover1Position[1] + " " + rover1.getDirection());

        rover2.setTerrain(mars);
        rover2.executeInstructions(instructions2);
        int[] rover2Position = rover2.getPosition();
        System.out.println(rover2Position[0] + " " + rover2Position[1] + " " + rover2.getDirection());
    }

}
