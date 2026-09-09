def backtrack(state):
    if len(state) == 2:
        print(state)
        return 
    for choice in ['A' , 'B']:
        state += choice
        backtrack(state)
        state = state[:-1]

backtrack("")