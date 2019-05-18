// Solution from EddieCarrillo
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> bad = getBadSpots(obstacles);
        int up = 0;
        int right = 1;
        int down = 2;
        int left = 3;
        
        int dir = up;
        int[] pos = new int[]{0,0};
        int max = 0;
        
        for (int command: commands){
            if (command < 1) dir = updateDir(dir, command);
            else  max = Math.max(max, updatePos(pos, command, dir, bad));
        }        
        return max;        
    }
    
    /*0 -> up, 1 -> right, 2 -> down, 3 -> left**/
    int updatePos(int[] pos, int command, int dir,Set<String> obstacles){
        int[][] dirVectors = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        for (int i = 1; i <= command; i++){
            int nextRow = pos[0] + dirVectors[dir][0];
            int nextCol = pos[1] + dirVectors[dir][1];
            if (!obstacles.contains(encodeLoc(nextRow, nextCol))){ //If no obstacle is in the way then move robot "forward"
                pos[0] += dirVectors[dir][0];
                pos[1] += dirVectors[dir][1];
            }            
        }
        //Return the square distance
        return pos[0]*pos[0] + pos[1]*pos[1]; 
    }
    int updateDir(int cur, int change){
        //-90 degree === 270 degree
        if (change == -2) return (cur + 3) % 4;
        //change == 1
        return (cur + 1) % 4;
    }
    
    Set<String> getBadSpots(int[][] obstacles){
        Set<String> res = new HashSet<>();
           for (int[] loc : obstacles){
            res.add(encodeLoc(loc[0], loc[1]));
        }
        
        return res;
    }
    
    
    String encodeLoc(int i, int j){
        return i + "#" + j; 
    }
}

/* Much faster solution from ho-chih, using hashcode to compare corordinates.
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Cord> obscles = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obscles.add(new Cord(obstacles[i][0], obstacles[i][1]));
        }
        int orient = 0;
        int[] position = {0, 0};
        int max = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1 || commands[i] == -2) {
                orient = turn(orient, commands[i]);
            } else {
                walk(position, orient, commands[i], obscles);
            }
            max = maxUD(position, max);
        }
        return max;
    }

    private static int maxUD(int[] position, int currMax) {
        return Math.max(currMax, position[0] * position[0] + position[1] * position[1]);
    }

    private static void walk(int[] position, int orient, int steps, Set<Cord> obscles) {
        while (steps > 0) {
            switch (orient) {
                case 0:
                    if (!obscles.contains(new Cord(position[0], position[1] + 1))) {
                        position[1] = position[1] + 1;
                    } else {
                        return;
                    }
                    break;
                case 1:
                    if (!obscles.contains(new Cord(position[0] + 1, position[1]))) {
                        position[0] = position[0] + 1;
                    } else {
                        return;
                    }
                    break;
                case 2:
                    if (!obscles.contains(new Cord(position[0], position[1] - 1))) {
                        position[1] = position[1] - 1;
                    } else {
                        return;
                    }
                    break;
                case 3:
                    if (!obscles.contains(new Cord(position[0] - 1, position[1]))) {
                        position[0] = position[0] - 1;
                    } else {
                        return;
                    }
                    break;
            }
            steps = steps - 1;
        }
    }

    private static int turn(int raw, int direction) {
        if (direction == -1) {
            raw = raw + 1;
        } else if (direction == -2) {
            raw = raw - 1;
        }
        if (raw >= 4) {
            raw = 0;
        } else if (raw < 0) {
            raw = 3;
        }
        return raw;
    }

    private static class Cord {
        public int x;
        public int y;

        Cord(int X, int Y) {
            x = X;
            y = Y;
        }

        @Override
        public int hashCode() {
            int hash = 17;
            hash = hash * 31 + x;
            hash = hash * 31 + y;
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            return this.x == ((Cord) o).x && this.y == ((Cord) o).y;
        }
    }
}
*/