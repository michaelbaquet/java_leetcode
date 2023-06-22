package old;

public class FindIfPathExists {

    public static void main(String[] args) {
        int n = 10;
        int[][] input = {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        int source = 7;
        int destination = 5;

        System.out.println(validPath(n, input, source, destination));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        int[] comps = new int[n];
        int components = 0;

        for(int i = 0; i < edges.length; i++) {

            if(comps[edges[i][0]] == 0) {
                if(comps[edges[i][1]] == 0) {
                    components++;
                    comps[edges[i][0]] = components;
                    comps[edges[i][1]] = components;
                } else {
                    comps[edges[i][0]] = comps[edges[i][1]];
                }
            } else if(comps[edges[i][1]] == 0) {
                comps[edges[i][1]] = comps[edges[i][0]];
            } else if (comps[edges[i][0]] != comps[edges[i][1]]) {
                for(int j = 0; j < comps.length; j++) {
                    if(comps[j] != 0 && comps[j] == comps[edges[i][1]]) {
                        comps[j] = comps[edges[i][0]];
                    }
                }
            }
        }
        System.out.println("THIS IS COMPS:");
        System.out.println("comps[source]" + comps[source] + "    comps[destination]: " + comps[destination]);
        return comps[source] == comps[destination];

    }

}
