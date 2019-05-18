// Brute-force solution
class Solution {
    public double largestTriangleArea(int[][] points) {
        double res = 0.0;
        for (int[] i : points)
            for (int[] j : points)
                for (int[] k : points)
                    res = Math.max(res, 0.5 * Math.abs(i[0] * j[1] + j[0] * k[1] + k[0] * i[1] - j[0] * i[1] - k[0] * j[1] - i[0] * k[1]));
        return res;
    }
}

/* 
// Slightly better solution
class Solution {
    public double largestTriangleArea(int[][] points) {
        double res = 0.0;
        for (int i = 0; i < points.length; ++i)
            for (int j = i + 1; j < points.length; ++j)
                for (int k = j + 1; k < points.length; ++k) {
                    double area = calArea(points[i], points[j], points[k]);
                    if (area > res)
                        res = area;
                }                    
        return res;
    }
    public double calArea(int[] i, int[] j, int[] k) {
        return 0.5 * Math.abs(i[0] * j[1] + j[0] * k[1] + k[0] * i[1] - j[0] * i[1] - k[0] * j[1] - i[0] * k[1]);
    }
}

// Fastest solution by kirj
// 使用梯型面積計算較三角形快。

class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = 0;
        
        for (int i = 0; i < n; ++i) 
            for (int j = i + 1; j < n; ++j)
                for (int k = j + 1; k < n; ++k) {
                    double area = area(points, i, j, k);
                    if (area > max) {
                        max = area;
                    }
                }
        
        
        return max;
    }
    
    // triangle
    double area(int[][] points, int i, int j, int k) {
        int[] p1 = points[i];
        int[] p2 = points[j];
        int[] p3 = points[k];
        
        double area = 0;
        area += area(p1, p2);
        area += area(p2, p3);
        area += area(p3, p1);
        
        return Math.abs(area);
    }
    
    // parallelogram
    double area(int[] p1, int[] p2) {
        int w = p2[0] - p1[0];
        double h = (p1[1] + p2[1] + 200) / 2.0;
        return w * h;
    }
}
*/