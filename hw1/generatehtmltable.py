from sys import argv

script, htmlFileName = argv
docType = '<?xml version="1.0" encoding="UTF-8"?>\n<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"\n"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd>\n'
htmlHead = '<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">\n'

def createFile():
	
	outFile = open(htmlFileName, "w")
	outFile.write(docType)
	outFile.write(htmlHead)
	outFile.write(createTable())
	outFile.write("</html>")
	outFile.close()

def createTable():
	bodyText = []
	bodyText.append('<body>\n<p>\n<table border="1" style="width:33%">\n')
	bodyText.append(createTableHeader())
	addAnother = True
	while addAnother:
		bodyText.append(addClass())
		addAnother = addAnotherClass()
	bodyText.append('</table>\n</p>\n</body>')
	return ''.join(bodyText)

def createTableHeader():
	tableHeaders = "<tr>\n<th>Semester</th>\n<th>Course</th>\n</tr>"
	return tableHeaders

def addClass():
	print('Lets add a new class')
	semester = raw_input("Enter semester and year (ie 'Fall 2014')")
	course = raw_input("Enter course name (ie 'Software Engineering')")
	classEntry = "<tr>\n<td>%s</td>\n<td>%s</td>\n</tr>" % (semester, course)
	return classEntry

def addAnotherClass():
	incorrectValue = True
	while incorrectValue:
		toContinue = raw_input("Would you like to enter another course? ('y' or 'n')")
		if 'y' is toContinue:
			return True
		elif toContinue is 'n':
			return False
		else:
			print("Invalid response, please enter 'y' or 'n'")

createFile()		
