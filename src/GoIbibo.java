import designpatterns.factory.MMT;

import java.util.ArrayList;
import java.util.List;

public class GoIbibo {

    enum Days {
        MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT,
        SUN;
    }

    public static void main(String[] args) {

        int a1[] = new int[]{900, 1000, 1000, 1000, 2700, 1200, 800};
        int a2[] = new int[]{1700, 1600, 1600, 1600, 1600, 1200, 800};
        Days days[] = Days.values();

        int i = 0;
        int j = 0;
        while (i < a1.length && j < a2.length) {
            for(Days day: days) {
                List<String> enumDays = new ArrayList<>();
                if (a2[j] > a1[i]) {
                    if((a1[i] != a1[i+1]) && (a2[j] != a2[j+1])) {
                        System.out.println(day.toString() + " : " + a1[i] + "-" + a2[j]);
                    }else{
                        enumDays.add(day.toString());
                    }
                    i++;
                    j++;
                    /*if(enumDays.size() >=2)
                        System.out.println(enumDays.get(0) + "-" + enumDays.get(enumDays.size() - 1) + " : " + a1[i] + "-" + a2[j]);*/
                }
                else if (a2[j] == a1[i]) {
                    System.out.println(day.toString() +" : "+ "Open 24 Hours");
                    i++;j++;
                }
                else if(a2[j] < a1[i]) {
                    System.out.println(day.toString() + " : " + "Closed");
                    i++;j++;
                }
            }

            }
        }

    }

