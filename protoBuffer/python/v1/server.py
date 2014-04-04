from addressBook_pb2 import *

def newPhone(person, number, type = MOBILE):
    phone = person.phone.add()
    phone.number = number
    phone.type = type
    return phone

def newAddressBook():
    addressBook = AddressBook()
    
    person = addressBook.people.add()
    person.name = "Jerry"
    person.id = 1
    person.email = "jerry.shao@gmail.com"
    
    mobile = newPhone(person, "13917812345")
    home = newPhone(person, "61235485", HOME)

    return addressBook

def printInfo(addressBook):
    print("IsInitialized: %s" % addressBook.IsInitialized())
    print(addressBook)
    
def writeFile(filename):
    f = open(filename, "wb")
    f.write(newAddressBook().SerializeToString())
    f.close()
    
#book = newAddressBook()
#printInfo(book)
writeFile("jerry.save")



