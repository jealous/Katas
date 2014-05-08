from unittest import TestCase
from Node import Node
from SearchNode import SearchNode

__author__ = 'Cedric'

class TestSearchNode(TestCase):
    def setUp(self):
        self.searcher = SearchNode()

    def test_search(self):
        node = Node()
        self.assertEqual(self.searcher.search(node), 0);

    def test_search_not_Node(self):
        node = "t"
        self.assertEqual(self.searcher.search(node), -1);

    def test_setKey(self):
        node = Node()
        node.setKey(5)
        self.assertEqual(node.key, 5)
        self.assertEqual(node.value, 25)

    def test_setKeyAndValue(self):
        node = Node()
        node.setKeyAndValue(5, 10)
        self.assertEqual(node.key, 5)
        self.assertEqual(node.value, 10)

    def test_searchSingle(self):
        node = Node()
        node.setKey(3)
        result = node.search(3)
        self.assertEqual(node.value, 9)

    def test_searchFullTwoLevel(self):
        node = Node()
        node.setKey(3)
        node11 = Node()
        node11.setKey(2)
        node.left = node11
        node12 = Node()
        node12.setKey(4)
        node.right = node12
        node21 = Node()
        node21.setKey(5)
        node11.left = node21
        node22 = Node()
        node22.setKey(6)
        node11.right = node22
        node23 = Node()
        node23.setKeyAndValue(7, 14)
        node12.left = node23
        node24 = Node()
        node24.setKeyAndValue(8,16)
        node12.right = node24

        self.assertEqual(node.search(7).value, 14)