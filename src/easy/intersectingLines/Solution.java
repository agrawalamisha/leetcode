package easy.intersectingLines;

public class Solution {
    public boolean intersecting(double x1, double y1,
                                double x2, double y2,
                                double x3, double y3,
                                double x4, double y4) {
        boolean result = true;

        // both lines of form x = k, c = 0
        if (x4 - x3 == 0 && x2 - x1 == 0) {
            return false;
        }
        double m1, m2;
        try {
            m1 = (y2 - y1) / (x2 - x1);
        } catch (ArithmeticException ae) {
            m1 = Double.MAX_VALUE;
        }
        try {
            m2 = (y4 - y3) / (x4 - x3);
        } catch (ArithmeticException ae) {
            m2 = Double.MAX_VALUE;
        }
        // both lines parallel (or collinear)
        if (m1 == m2) {
            return false;
        }

        // non-parallel, check if
        if (false) {

        }
        return result;
    }
}
