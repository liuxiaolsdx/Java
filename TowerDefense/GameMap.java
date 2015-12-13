package TowerDefense;

import java.util.*;

public class GameMap {
	private int line;
	private int row;
	private char[][] map;

	public GameMap(int l, int r) {
		// super(0,0);
		line = l;
		row = r;
		this.initialMap();
	}

	/**
	 * initial the map with wall 
	 * 初始化地图，围墙为'*',可建造地为'-'
	 */
	public void initialMap() {
		map = new char[line + 2][row + 2];

		// 初始化地图，围墙为'*',可建造地为'-'
		for (int i = 0; i < line + 2; ++i)
			map[i][0] = map[i][row + 1] = '*';
		for (int j = 0; j < row + 2; ++j)
			map[0][j] = map[line + 1][j] = '*';

		for (int i = 1; i <= line; ++i)
			for (int j = 1; j <= row; ++j)
				map[i][j] = '-';

	}

	public int getline() {
		return line;
	}

	public int getrow() {
		return row;
	}

	public char[][] getMap() {
		return map;
	}

	/**
	 * judge the point whether can build
	 * 
	 * @param x
	 * @param y
	 * @return true : can build
	 */
	public boolean canBuild(int x, int y) {
		if ((x == 1 && y == 1) || (x == line && y == row) || map[x][y] == '*')
			return false;
		else
			return true;
	}

	public void BuildTower(int x, int y) {
		map[x][y] = '*';
	}

	/**
	 * judge whether has access of the map implement of BFS 
	 * time complexity:O(n^2) 
	 * 此方法用来判断从入口到出口有通路，用队列和广度实现
	 */
	public boolean isPathAccess() {
		if (line < 2 || row < 2)
			return false;// 必须存在出口和入口

		Queue<Point> qTemp = new LinkedList<>();

		Point[] dir = new Point[4];// 四个方向，顺时针遍历
		dir[0] = new Point(0, 1);// 下
		dir[1] = new Point(1, 0);// 右
		dir[2] = new Point(0, -1);// 上
		dir[3] = new Point(-1, 0);// 左

		Point CurrtPos = new Point(0, 0);
		CurrtPos.setXPoint(1);
		CurrtPos.setYPoint(1);
		qTemp.offer(CurrtPos);

		// Point TemPos = new Point(0,0);

		int[][] flag = new int[line + 2][row + 2];
		flag[CurrtPos.getXPoint()][CurrtPos.getYPoint()] = 1;

		while (!qTemp.isEmpty()) {
			CurrtPos = qTemp.poll();
			for (int i = 0; i < 4; ++i) {
				// CurrtPos.Move(dir[i]);
				Point NextPos = new Point(0, 0);
				NextPos.Move(CurrtPos, dir[i]);
				if (NextPos.getXPoint() == line && NextPos.getYPoint() == row) {
					flag[CurrtPos.getXPoint()][CurrtPos.getYPoint()] = 1;
					return true;
				}
				if (map[NextPos.getXPoint()][NextPos.getYPoint()] == '-'
						&& flag[NextPos.getXPoint()][NextPos.getYPoint()] == 0) {
					// TemPos = (Point) NextPos.clone();
					qTemp.offer(NextPos);
					flag[CurrtPos.getXPoint()][CurrtPos.getYPoint()] = 1;
				}
			}
		}
		return false;
	}

	/**
	 * show the map field 此方法用来显示地图
	 */
	public void showMap() {
		for (int i = 0; i < (line + 2); ++i) {
			for (int j = 0; j < (row + 2); ++j) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	/**
	 * judge two GameMap object is same, include their map field
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (!(otherObject instanceof GameMap))
			return false;
		GameMap other = (GameMap) otherObject;

		return line == other.line && row == other.row && this.isSameMap(other.map);
	}

	/**
	 * judge the map is the same
	 * 
	 * @param other
	 * @return
	 */
	public boolean isSameMap(char[][] other) {
		if (this.map.length != other.length)
			return false;

		for (int i = 0; i < this.map.length; ++i) {
			if (this.map[i].length != other[i].length)
				return false;
			for (int j = 0; j < this.map[i].length; ++j)
				if (this.map[i][j] != other[i][j])
					return false;
		}
		return true;
	}

	/**
	 * for unit test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GameMap firstMap = new GameMap(3, 4);
		// firstMap.BuildTower(2, 2);
		System.out.println("创建一个3X4的游戏地图：");
		firstMap.showMap();

		GameMap secondMap = new GameMap(3, 4);
		secondMap.BuildTower(2, 2);
		System.out.println("创建一个3X4的游戏地图：");
		secondMap.showMap();

		if (secondMap.equals(firstMap))
			System.out.println("这两个游戏地图相等！");
		else
			System.out.println("这两个游戏地图不相等！");

	}

}
