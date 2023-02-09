package Training;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        List<String> climbedPeakList = new ArrayList<>();
        List<String> peakList = new ArrayList<>();
        peakList.add("Vihren");
        peakList.add("Kutelo");
        peakList.add("Banksi Suhodol");
        peakList.add("Polezhan");
        peakList.add("Kamenitza");

        List<Integer> peakMetresList = new ArrayList<>();
        peakMetresList.add(80);
        peakMetresList.add(90);
        peakMetresList.add(100);
        peakMetresList.add(60);
        peakMetresList.add(70);
        Scanner scanner = new Scanner(System.in);
        String[] foodArr = scanner.nextLine().split(", ");
        String[] staminaArr = scanner.nextLine().split(", ");
        Deque<Integer> foodDeque = new ArrayDeque<>();
        for (int i = 0; i < foodArr.length; i++) {
            int currentFood = Integer.parseInt(foodArr[i]);
            foodDeque.push(currentFood);
        }
        Deque<Integer> staminaDeque = new ArrayDeque<>();
        for (int i = staminaArr.length - 1; i >= 0; i--) {
            int currentStamina = Integer.parseInt(staminaArr[i]);
            staminaDeque.push(currentStamina);
        }
    
        int sum = 0;
        int currentPeak = 0;
        while (!foodDeque.isEmpty()) {
            if (peakMetresList.isEmpty()) {
                break;
            } else {
                sum = foodDeque.pop() + staminaDeque.pop();

                if (sum >= peakMetresList.get(currentPeak)) {
                    climbedPeakList.add(peakList.get(0));
                    peakList.remove(currentPeak);
                    peakMetresList.remove(currentPeak);
                }
            }
        }
        if (peakList.isEmpty()) {
            System.out.printf("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK%n");
            System.out.println("Conquered peaks:");
            for (int i = 0; i < climbedPeakList.size(); i++) {
                System.out.printf("%s%n", climbedPeakList.get(i));

            }
        }else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
            if (!climbedPeakList.isEmpty()){
                System.out.println("Conquered peaks:");
                for (int i = 0; i < climbedPeakList.size(); i++) {
                    System.out.printf("%s%n",climbedPeakList.get(i));

                }
            }
        }

    }

}
