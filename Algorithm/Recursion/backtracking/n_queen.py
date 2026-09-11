def safe(arr, r,c):
    def safe_col(r,c, arr):
        row_b = r-1
        while row_b >= 0:
            if(arr[row_b][c] == 1):
                return False
            row_b -= 1
        return True

    def safe_diag(r,c, arr):
        def upper_right(r,c, arr):
            while r >= 0 and c < len(arr):
                if arr[r][c] == 1:
                    return False
                r -= 1
                c += 1
            return True

        def upper_left(r,c, arr):
            while r >= 0 and c >= 0:
                if arr[r][c] == 1:
                    return False
                r -= 1
                c -= 1
            return True
        return upper_left(r,c,arr) and upper_right(r,c,arr)
    return safe_col(r,c,arr) and safe_diag(r,c,arr)

def solve(board, row):
    N = len(board)
    if row == N:
        print(board)
        return 

    for col in range(N):
        if safe(board, row, col):
            board[row][col] = 1
            solve(board, row+1)
            board[row][col] = 0
            
board = [[0 for _ in range(4)] for _ in range(4)]
solve(board, 0)