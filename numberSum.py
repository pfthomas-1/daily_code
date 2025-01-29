while True: # error handling - ensure integer is inputted
    numbers = input("Enter a series of numbers as an integer (example: 123): ")

    try: 
        numbersInt = int(numbers) # exists only to check if the input is an integer
        break
    except:
        print("that is not an integer, please try again.")

sum = 0

numbersChain = f"" # String variable to format the inputted numbers for when they get printed

for num in numbers: 
    sum += int(num)
    numbersChain += f" {num},"

print(f"the sum of the digits{numbersChain[0:-1]} is {sum}")