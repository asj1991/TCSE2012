public class Solution {
	public int removeDuplicates(int[] A) {
		if (A == null)
			return 0;
		int currentLength = A.length;
		for (int i = 0; i < A.length - 2; i++) {
			int countToDelete = applyRestrictionOfDuplicatingMoreThanOnce(getAmountOfDuplicatedIntegerWith(
					i, A, currentLength));
			applyRemovingForDuplicatedMoreThanOnce(countToDelete, i + 2, A,
					currentLength);
			currentLength -= countToDelete;
		}

		return currentLength;
	}

	private int getAmountOfDuplicatedIntegerWith(int currentIndex, int[] A,
			int currentLength) {
		int j = currentIndex + 1, result = 0;
		while (j < currentLength && A[j] == A[currentIndex]) {
			j++;
			result++;
		}
		return result;
	}

	private int applyRestrictionOfDuplicatingMoreThanOnce(int duplicatedAmount) {
		return duplicatedAmount > 1 ? duplicatedAmount - 1 : 0;
	}

	private void applyRemovingForDuplicatedMoreThanOnce(int countToDelete,
			int startPointOfDelete, int A[], int currentLength) {
		if (countToDelete == 0 || currentLength < countToDelete)
			return;
		for (int i = startPointOfDelete; i < currentLength - countToDelete; i++) {
			A[i] = A[i + countToDelete];
		}
	}
}