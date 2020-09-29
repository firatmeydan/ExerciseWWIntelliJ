package thirdQuestion;

public class Question3 {
	double[] ranNumArr;
	double smallestNumber;
	int placeOfSmallestNumber;

	public void smallestRandomNumber() {

		ranNumArr = new double[500];

		for (int i = 0; i < ranNumArr.length; i++) {

			ranNumArr[i] = Math.random();
			System.out.println(ranNumArr[i]);

		}

		smallestNumber = ranNumArr[0];
		placeOfSmallestNumber = 0;

		for (int i = 1; i <= ranNumArr.length; i++) {

			if (ranNumArr[i - 1] < smallestNumber) {

				smallestNumber = ranNumArr[i - 1];
				placeOfSmallestNumber = i;
			}
		}

		System.out
				.println("\n" + placeOfSmallestNumber + "th number is the smallest number which is " + smallestNumber);

	}

	public static void main(String[] args) {
		Question3 question3 = new Question3();
		question3.smallestRandomNumber();
	}

}
