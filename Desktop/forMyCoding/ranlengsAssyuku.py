
def ranlengs(iputWord):
    assert input != ""
    inputWords=list(inputWord)
    #inputWords=[b,b,b,a,a,c,c,c,c,c,f,f] if input==bbbaacccccff
    befchar=inputWords[0] #=b
    i=0 #index for looking list
    count=0 #count rennzokusuu
    result=""# for output
    while i <len(inputWords):
        if befchar==inputWords[i]:
            count+=1
        else:
            result+=befchar
            result+=str(count)
            befchar=inputWords[i]
            count=1
        i+=1
    result+=befchar
    result+=str(count)
    print(result)

inputWord = input("inputWord:")
print(inputWord)
ranlengs(inputWord)
