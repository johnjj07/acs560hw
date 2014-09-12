from sys import argv

script, filename, outFile = argv

text = open(filename, "r")
newFile = open(outFile, "w")
replacedText = text.read()
replacedText = replacedText.replace('\r', '')
newFile.write(replacedText)
newFile.close()

