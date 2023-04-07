import java.util.*;

public class TwoDArrayProbs {
	private int[][] nums;

	public TwoDArrayProbs(int[][] arr) {
		nums = arr;
	}

	public int sum() {
		int sum = 0;

		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[r].length; c++) {
				sum += nums[r][c];
			}
		}

		return sum;
	}

	public boolean isSquare() {
		int tot = nums.length;
		int subTot = 0;
		int fin;

		for (int r = 0; r < nums.length; r++) {
			subTot += nums[r].length;
		}

		fin = subTot / tot;

		if (fin == tot) {
			return true;
		} else {
			return false;
		}
	}

	public void addMatrix(int[][] set) {

		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[r].length; c++) {
				nums[r][c] += set[r][c];
			}
		}

		print();

	}

	private void print() {
		for (int[] p : nums) {
			System.out.print(Arrays.toString(p) + " ");
		}
	}

	public int columnSum(int col) {
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i].length < col)
				continue;
			sum += nums[i][col];
		}

		return sum;
	}

	public boolean isColumnMagic() {
		int sum = 0;
		int sum1 = 0;
		boolean first = true;
		int col = 0;

		for (int j = 0; j < nums[0].length; j++) {
			for (int i = 0; i < nums.length; i++) {
				if (col < nums[i].length)
					sum += nums[i][col];
			}

			col++;
			if (first) {
				sum1 = sum;
				sum = 0;
				first = false;
				continue;
			}
			if (sum1 != sum)
				return false;
			sum1 = sum;
			sum = 0;
		}
		return true;
	}

	public int diagDifference() {
		int sum1 = 0;
		int sum2 = 0;
		int ret = 0;

		for (int i = 0; i < nums.length; i++) {
			sum1 += nums[i][i];
		}
		for (int i = 0; i < nums.length; i++) {
			sum2 += nums[i][nums.length - 1 - i];
		}

		ret = Math.abs(sum1 - sum2);
		return ret;

	}
}
