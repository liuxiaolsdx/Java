package TowerDefense;

import java.util.*;

/**
 * The TowerDefense console version.
 * 
 * @version 1.2 11/15/2015
 * @author Sean
 */

public class GameMapTest {
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
		GameMap TowerDefense;
		int line, row;
		try (Scanner in = new Scanner(System.in))
		{
			System.out.println("请输入需要创建的地图行数：");
			line = in.nextInt();
			System.out.println("请输入需要创建的地图列数：");
			row = in.nextInt();
			TowerDefense = new GameMap(line, row);

			System.out.println("带围墙的游戏地图为：");
			TowerDefense.showMap();

			int xBuild, yBuild;
			while (true) {
				//get x  
				System.out.println("请输入需要建造的塔的横坐标，范围：" + "1 ~ " + line + "（如果终止游戏请输入0）： ");
				xBuild = in.nextInt();
				
				if (xBuild == 0) // 退出入口
					break;
				else if (xBuild > line || xBuild < 0) {
					System.out.println("建造的塔的横坐标超出地图外！");
					continue;
				}
				
				//get y
				System.out.println("请输入需要创建的塔的纵坐标，范围：" + "1 ~ " + row + "（如果终止游戏请输入0）： ");
				yBuild = in.nextInt();
				if (yBuild == 0) // 退出入口
					break;
				else if (yBuild > row || yBuild < 0) {
					System.out.println("建造的塔的棕坐标超出地图外！");
					continue;
				}
				
				//judge whether can build
				if (!TowerDefense.canBuild(xBuild, yBuild))
					System.out.println("\n错误：此处不能建造！");
				else
					TowerDefense.BuildTower(xBuild, yBuild);
				
				//judge whether the monster can go through
				if (TowerDefense.isPathAccess())
					System.out.println("\n本次建造位置为：(" + xBuild + "," + yBuild + ")，" + "此时怪物可以通过！");
				else
					System.out.println("\n本次建造位置为：(" + xBuild + "," + yBuild + ")，" + "此时怪物不可通过！");
				System.out.println("\n游戏地图为：");
				TowerDefense.showMap();

			} // end while()
//			in.close();
		} catch (InputMismatchException e) {
			// e.getMessage();
			System.out.println("输入错误格式，请输入整数！");
		} catch (NegativeArraySizeException e) {
			// e.printStackTrace();
			System.out.println("输入错误，请输入正整数！");
		}

	}
}
