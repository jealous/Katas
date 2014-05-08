__author__ = 'Cedric'

from Node import Node

class SearchNode():
    def isNode(self, node):
        return type(node) == Node

    def search(self, node):
        if not (self.isNode(node)):
            print("Input is not a Node.  Exit.")
            return -1;
        return 0


