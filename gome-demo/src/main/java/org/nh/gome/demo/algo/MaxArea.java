package org.nh.gome.demo.algo;

/**
 * @program: MaxArea.java
 * @description: 11. 盛最多水的容器
 * @author: yindanqing
 * @create: 2020/9/22 17:21
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] area = {1,8,6,2,5,4,8,3,7};
        System.out.println(new MaxArea().maxArea3(area));
    }

    public int maxArea(int[] height) {
        if(height.length==2){
            return Math.min(height[0], height[1]);
        }
        int area = 0;
        for (int i = 0; i < height.length; i++){
            for (int j = i + 1; j < height.length; j++){
                int tmpArea = Math.min(height[i], height[j]) * (j-i);
                area = Math.max(tmpArea, area);
            }
        }
        return area;
    }

    public int maxArea2(int[] height) {
        if(height.length==2){
            return height[0]>=height[1]?height[1]:height[0];
        }
        int area = 0;
        for (int i = 0; i < height.length; i++){
            for (int j = i + 1; j < height.length; j++){
                int tmpArea = (height[i] >= height[j] ? height[j] : height[i]) * (j-i);
                area = tmpArea >= area ? tmpArea : area;
            }
        }
        return area;
    }

    public int maxArea3(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int i = 0, j = height.length - 1;
        int area = 0;
        while (i < j) {
            int tmpArea = (Math.min(height[i], height[j])) * (j - i);
            area = Math.max(tmpArea, area);
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return area;
    }



}
