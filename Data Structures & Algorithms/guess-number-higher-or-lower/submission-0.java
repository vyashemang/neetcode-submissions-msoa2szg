/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;

        while (true) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);

            if (0 == res) {
                return mid;
            } else if (1 == res) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

    }
}