class TrieNode:
    def __init__(self):
        self.isWord = False
        self.next = {}

class Trie:
    def __init__(self):
        self.root = TrieNode()        

    def insert(self, word: str) -> None:
        n = self.root
        for i in word:
            if i not in n.next:
                n.next[i] = TrieNode()
            n = n.next[i]
        n.isWord = True        

    def search(self, word: str) -> bool:
        n = self.root
        for i in word:
            if i not in n.next:
                return False
            else:
                n = n.next[i]
        return n.isWord

    def startsWith(self, prefix: str) -> bool:
        n = self.root
        for i in prefix:
            if i not in n.next:
                return False
            else:
                n = n.next[i]
        return True

''' Not using TrieNode
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.tree = {}
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        temp = self.tree
        for a in word:
            if a not in temp:
                temp[a] = {}

            temp = temp[a]
            
        temp["#"] = "#"   
        
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        temp = self.tree
        for let in word:
            if let in temp:
                temp = temp[let]
            else:
                return False
        if '#' in temp.keys():
            return True 
        return False   

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        temp = self.tree
        for let in prefix:
            if let in temp:
                temp = temp[let]
            else:
                return False
        return True
'''