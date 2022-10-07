package designpatterns.factory;

public class MMT {

    enum Days {
        SUN,
        MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT;
    }

    public static void main(String[] args) {

        int a1[] = new int[]{900, 1000, 1000, 1000, 2700, 1200, 800};
        int a2[] = new int[]{1700, 1600, 1600, 1600, 1600, 1200, 800};

        Days days[] = Days.values();
        for(Days day: days) {


        }


        int i = 0;
        int j = 0;
        while (i < a1.length && j < a2.length) {

            if (a2[j] > a1[i]) {
                printValues(i, j,a1,a2);
                i++;
                j++;
            }
            if (a2[j] == a1[i]) {
                printValues(i, j,a1,a2);
                i++;
                j++;

            }

            if (a2[j] < a1[i]) {
                System.out.println("Mon: " + "Closed");
                i++;
                j++;

            }
        }
    }

        private static void printValues ( int i, int j,int a2[] , int a1[]){
            switch (i) {
                case 0:
                    System.out.println("Mon: " + a2[j] + "-" + a1[i]);
                    break;

                case 1:
                    System.out.println("Tue: " + a2[j] + "-" + a1[i]);
                    break;

                case 2 :
                    System.out.println("Wed: " + a2[j] + "-" + a1[i]);
                break;

                case 3 :
                System.out.println("Thu: " + a2[j] + "-" + a1[i]);
                break;

                case 4 :
                System.out.println("Fri: " + a2[j] + "-" + a1[i]);
                break;

                case 5 :
                System.out.println("Sat: " + a2[j] + "-" + a1[i]);
                break;

                case 6 :
                System.out.println("Sun: " + a2[j] + "-" + a1[i]);
                break;


            }
        }
    }





