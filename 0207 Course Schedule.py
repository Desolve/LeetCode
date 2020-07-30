# Adapted from lee215, BFS Topological Sorting, O(N+E)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = [[] for _ in range(numCourses)]
        degree = [0] * numCourses
        
        for j, i in prerequisites:
            graph[i].append(j)
            degree[j] += 1
        
        bfs = [i for i in range(numCourses) if degree[i] == 0]
        for i in bfs:
            for j in graph[i]:
                degree[j] -= 1
                if degree[j] == 0:
                    bfs.append(j)
        
        return len(bfs) == numCourses