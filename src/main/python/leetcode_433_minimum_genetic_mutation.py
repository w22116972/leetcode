"""
433. Minimum Genetic Mutation
https://leetcode.com/problems/minimum-genetic-mutation/

A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string. For example, "AACCGGTT" --> "AACCGGTA" is one mutation.

There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

Example 1:
Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1

Example 2:
Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2

Constraints:
0 <= bank.length <= 10
startGene.length == endGene.length == bank[i].length == 8
startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
"""
from collections import deque

class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        gene_set = set(bank)
        if endGene not in gene_set:
            return -1

        number = 0
        queue = deque([startGene])
        visited = set(startGene)

        while queue:
            for _ in range(len(queue)):
                gene = queue.popleft()
                if gene == endGene:
                    return number

                for neighbor in self.find_genes(gene, gene_set):
                    if neighbor not in visited:
                        visited.add(neighbor)
                        queue.append(neighbor)
            number += 1
        return -1

    def find_genes(self, gene: str, gene_set: set) -> List[str]:
        neighbors = []
        for i in range(len(gene)):
            for c in 'ACGT':
                if c != gene[i]:
                    new_gene = gene[:i] + c + gene[i+1:]
                    if new_gene in gene_set:
                        neighbors.append(new_gene)
        return neighbors
