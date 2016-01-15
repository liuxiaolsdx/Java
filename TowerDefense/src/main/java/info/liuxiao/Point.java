package info.liuxiao;

public class Point {
	private int XPoint;
	private int YPoint;
	
	public Point(int x, int y)
	{
		XPoint = x;
		YPoint = y;
	}
	
	public int getXPoint()
	{
		return XPoint;
	}
	
	public int getYPoint()
	{
		return YPoint;
	}
	
	public void setXPoint(int x)
	{
		XPoint = x;
	}
	
	public void setYPoint(int y)
	{
		YPoint =y;
	}
	
	public void Move(Point Step)
	{
		XPoint += Step.getXPoint();
		YPoint += Step.getYPoint();
	}
	
	public void Move(Point src, Point Step)
	{
		XPoint = src.getXPoint() + Step.getXPoint();
		YPoint = src.getYPoint() + Step.getYPoint();
	}
	
	@Override
	public String toString()
	{
		return getClass().getName()+"("+XPoint+","+YPoint+")";
	}
	
	@Override 
	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (!(otherObject instanceof Point)) return false;
		Point other = (Point) otherObject;
		return XPoint == other.XPoint && YPoint == other.YPoint;
	}
	/*	
 	public Object clone() 
	{ 
		Object o=null; 
		try
		{ 
			o=(Point)super.clone();
		} 
		catch(CloneNotSupportedException e) 
		{ 
			System.out.println(e.toString()); 
		} 
		return o; 
	}
	*/
	public static void main(String[] args)
	{
		Point pos = new Point(1,1);
		System.out.println("创建一个点:"+pos);
		
		int x = pos.getXPoint();
		int y = pos.getYPoint();
		System.out.println("点的横坐标为："+x);
		System.out.println("点的纵坐标为："+y);
		
		pos.setXPoint(3);
		pos.setYPoint(4);
		System.out.println("设置点为:" + pos);
		
		pos.Move(new Point(1,0));
		System.out.println("向下移动一个点为：" + pos);
		
			
	}
	
}
