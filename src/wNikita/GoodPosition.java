package wNikita;

public class GoodPosition {
	public GoodPosition(int i, String string, String art, int j, float k) {
		// TODO Auto-generated constructor stub
		good=new Good(i,string,art);
		quan=j;
		price=k;
	}
	public GoodPosition() {
		
	}
	public Good good;
	public int quan;
	public float price;

}
