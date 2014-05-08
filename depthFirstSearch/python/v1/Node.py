__author__ = 'Cedric'

class Node():

    def __init__(self):
        self.left = None
        self.right = None
        self.key = 0
        self.value = 0

    def setKeyAndValue(self, key, rvalue):
        self.key = key
        self.value = rvalue

    def setKey(self, key):
        self.key = key
        self.value = key * key

    def searchSelf(self, key, retVal):
        retVal = None
        if self.key == key:
            retVal = self
        return retVal

    def searchLeftNode(self, key):
        retVal = None
        if self.left is not None:
            retVal = self.left.search(key)
        return retVal

    def searchRightNode(self, key):
        retVal = None
        if self.right is not None:
            retVal = self.right.search(key)
        return retVal

    def search(self, key):
        retVal = None
        retVal = self.searchSelf(key, retVal)
        if retVal is None:
            retVal = self.searchLeftNode(key)
        if retVal is None:
            retVal = self.searchRightNode(key)
        return retVal

