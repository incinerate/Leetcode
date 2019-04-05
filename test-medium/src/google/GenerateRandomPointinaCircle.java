package google;

public class GenerateRandomPointinaCircle {
	
	/*
	 * ˼·:�����귨�����ȡ�Ⱥ�r�����Ϊ[x+rcos(��),y+rsin(��)]��ע�����ȡrʱ����ֱ�Ӹ���R����random����Ϊ
	 * randomʵ�����Ǻ�Բ��������ȵ�(Rƽ��),�����ǰ뾶������random r��ʱ��Ҫ��Math.sqrt(Math.random()) * R��
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
