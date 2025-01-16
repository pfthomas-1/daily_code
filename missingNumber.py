import random

# Generate a random number between 1 and 15 (inclusive)
listLength = random.randint(1, 15)
print("List Length:", listLength)

# populate a list with all numbers up to listLength excluding 0
numList = []

for num in range(listLength):
    numList.append(num + 1)

print("List:", numList)

# remove a random number from the list
deadNumIndex = random.randint(0, listLength - 1)
print ("Index of Removed Number:", deadNumIndex)

deadNum = numList.pop(deadNumIndex)
print("List w/o Removed Number:", numList, "| Removed Number:", deadNum)

# create a function that iterates through the list, finds the missing number, and adds it back
def checkList(list, listLength):
    for item in range(listLength - 1):
        if list[item] == item + 1:
            continue
        else:
            list.insert(item, item + 1)

    if len(list) != listLength: # the for loop won't add the removed number back if it was the final number in the list or if the list is empty, this solves those problems
        list.append(listLength)

checkList(numList, listLength)

print("List w/ Number Added Back:", numList)