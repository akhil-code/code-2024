package algorithms.dynamicprogramming;

public class ChoiceOfArea {
    public static void main(String args[]) {
        Area X = new Area(3, 2);
        Area Y = new Area(-5, -10);
        Area Z = new Area(-20, 5);

        int A = 20;
        int B = 8;
        char lastArea = 'n';
        System.out.println(getMaxSurvivalTime(A, B, X, Y, Z, lastArea));
    }

    public static int getMaxSurvivalTime(int a, int b, Area x, Area y, Area z, char lastArea) {
        if(a > 0 && b > 0) {
            int xSurvivalTime = lastArea != 'x' ? getMaxSurvivalTime(a + x.i, b + x.j, x, y, z, 'x') : 0;
            int ySurvivalTime = lastArea != 'y' ? getMaxSurvivalTime(a + y.i, b + y.j, x, y, z, 'y') : 0;
            int zSurvivalTime = lastArea != 'z' ? getMaxSurvivalTime(a + z.i, b + z.j, x, y, z, 'z') : 0;
            return 1 + Math.max(xSurvivalTime, Math.max(ySurvivalTime, zSurvivalTime));
        }
        return 0;

    }

    static class Area {
        int i;
        int j;

        public Area(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
