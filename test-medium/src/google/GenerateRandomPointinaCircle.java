package google;

public class GenerateRandomPointinaCircle {
	
	/*
	 * 思路:极坐标法，随机取θ和r，结果为[x+rcos(θ),y+rsin(θ)]。注意的是取r时不能直接根据R进行random，因为
	 * random实际上是和圆面积成正比的(R平方),并不是半径。所以random r的时候要用Math.sqrt(Math.random()) * R。
	 */
	
	double R;
	double x_center; 
	double y_center;

	public GenerateRandomPointinaCircle(double radius, double x_center, double y_center) {
        this.R = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double r = Math.sqrt(Math.random()) * R;
        double theta = Math.random()*2*Math.PI;
        double x = x_center + r*Math.cos(theta);
        double y = y_center + r*Math.sin(theta);
        return new double[] {x,y};
    }
}
