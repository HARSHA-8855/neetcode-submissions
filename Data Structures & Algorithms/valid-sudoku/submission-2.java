class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Create 9 sets for the 9 rows
        Set<Character>[] rows = new HashSet[9];

        // Create 9 sets for the 9 columns
        Set<Character>[] cols = new HashSet[9];

        // Create 9 sets for the 9 boxes
        Set<Character>[] boxes = new HashSet[9];

        // Initialize every set
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Visit every cell of the Sudoku board
        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                // Ignore empty cells
                if (board[r][c] == '.') {
                    continue;
                }

                // Get the current digit
                char num = board[r][c];

                // Find which 3x3 box this cell belongs to
                int box = (r / 3) * 3 + (c / 3);

                // If the digit already exists in the row,
                // the Sudoku is invalid
                if (rows[r].contains(num)) {
                    return false;
                }

                // If the digit already exists in the column,
                // the Sudoku is invalid
                if (cols[c].contains(num)) {
                    return false;
                }

                // If the digit already exists in the 3x3 box,
                // the Sudoku is invalid
                if (boxes[box].contains(num)) {
                    return false;
                }

                // Add the digit to its row
                rows[r].add(num);

                // Add the digit to its column
                cols[c].add(num);

                // Add the digit to its box
                boxes[box].add(num);
            }
        }

        // No duplicates were found
        return true;
    }
}