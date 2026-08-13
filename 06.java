class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        String[] rows = new String[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }

        int row = 0;
        boolean down = true;

        for (int i = 0; i < s.length(); i++) {

            rows[row] += s.charAt(i);

            if (row == numRows - 1) {
                down = false;
            }

            if (row == 0) {
                down = true;
            }

            if (down) {
                row++;
            } else {
                row--;
            }
        }

        String answer = "";

        for (int i = 0; i < numRows; i++) {
            answer += rows[i];
        }

        return answer;
    }
}
