package easy.visitallpoints;

class Solution {
    public int minTimeToVisitAllPoints2(int[][] points) {
        int time = 0;

        for (int i = 0; i < points.length - 1; i++) {
            // points[i][0]
            // points[i][1]
            // points[i + 1][0]
            // points[i + 1][1]

            int xMove = 0, yMove = 0;
            while (!(points[i + 1][0] == xMove + points[i][0] &&
                    points[i + 1][1] == yMove + points[i][1])) {
                int xDiff = points[i + 1][0] - (points[i][0] + xMove);
                int yDiff = points[i + 1][1] - (points[i][1] + yMove);
                if (xDiff == 0) {
                    time += Math.abs(yDiff);
                    yMove += yDiff;
                } else if (yDiff == 0) {
                    time += Math.abs(xDiff);
                    xMove += xDiff;
                } else if (Math.abs(xDiff) < Math.abs(yDiff)) {
                    time += Math.abs(xDiff);
                    xMove += xDiff;
                    yMove += (Math.signum(yDiff) == -1 ?
                            -1 * Math.abs(xDiff) :
                            Math.abs(xDiff));
                } else if (Math.abs(xDiff) > Math.abs(yDiff)) {
                    time += Math.abs(yDiff);
                    yMove += yDiff;
                    xMove += (Math.signum(xDiff) == -1 ?
                            -1 * Math.abs(yDiff) :
                            Math.abs(yDiff));
                } else if (Math.abs(xDiff) == Math.abs(yDiff)) {
                    time += Math.abs(xDiff);
                    xMove += xDiff;
                    yMove += yDiff;
                }
            }
        }
        return time;
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        for (int i = 0; i < points.length - 1; i++) {
            // points[i][0]
            // points[i][1]
            // points[i + 1][0]
            // points[i + 1][1]
            int xDiff = Math.abs(points[i + 1][0] - points[i][0]);
            int yDiff = Math.abs(points[i + 1][1] - points[i][1]);
//            time += Math.min(xDiff, yDiff) + Math.abs(xDiff - yDiff);
            time += Math.max(xDiff, yDiff);
        }
        return time;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] ar = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(solution.minTimeToVisitAllPoints(ar));
    }
}