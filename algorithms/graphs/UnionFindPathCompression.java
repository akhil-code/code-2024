package algorithms.graphs;

import java.util.Arrays;

public class UnionFindPathCompression {
    public static class Subset {
        int rank;
        int parent;

        public Subset(int number) {
            this.rank = 1;
            this.parent = number;
        }

        @Override
        public String toString() {
            return "Subset{" + rank + ", " + parent + '}';
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Subset[] sets = new Subset[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new Subset(i);
        }
        System.out.println(Arrays.toString(sets));
        System.out.println(areSameSet(sets, 0, 1));
        union(sets, 0, 1);
        System.out.println(Arrays.toString(sets));
        System.out.println(areSameSet(sets, 0, 1));


    }

    public static boolean areSameSet(Subset[] sets, int x, int y) {
        return findParent(sets, x) == findParent(sets, y);
    }

    public static void union(Subset[] sets, int x, int y) {
        int xroot = findParent(sets, x);
        int yroot = findParent(sets, y);
        if(sets[xroot].rank > sets[yroot].rank) {
            sets[yroot].parent = xroot;
        } else if(sets[yroot].rank > sets[xroot].rank) {
            sets[xroot].parent = yroot;
        } else {
            sets[yroot].parent = xroot;
            sets[xroot].rank++;
        }
    }

    public static int findParent(Subset[] sets, int x) {
        if(sets[x].parent != x) {
            sets[x].parent = findParent(sets, sets[x].parent);
        }
        return sets[x].parent;
    }
}
