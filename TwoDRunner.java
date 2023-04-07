public class TwoDRunner {
	public static void main(String [] args) {
		//1
		System.out.println(new TwoDArrayProbs(new int[] [] {{1, 2}, {10, 11}}).sum());
		
		//2
		System.out.println(new TwoDArrayProbs(new int[] [] {{1,2,3},{1,2,3},{1,2,3}}).isSquare());
		
		//3
		new TwoDArrayProbs(new int[][] {{1,2,3},{3,2,1}}).addMatrix(new int[][] {{2,3,1},{3,1,2}});
		System.out.println(" ");
		
		//4
		System.out.println(new TwoDArrayProbs(new int[][] {{1, 2, 3}, {4, 5, 6}, {6}}).columnSum(2));
		
		//5
		System.out.println(new TwoDArrayProbs(new int[][] {{1,2,3}, {1},{2,2,1}}).isColumnMagic());
		
		//6
		System.out.println(new TwoDArrayProbs(new int[][] {{1,2,3},{3,2,1},{7,2,2}}).diagDifference());
	}
}
