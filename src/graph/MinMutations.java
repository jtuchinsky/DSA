package graph;

import java.util.*;

public class MinMutations {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)) return 0;
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startGene);
        visited.add(startGene);

        //boolean found = false;
        int mutationsCount = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();

            for(int i = 0; i < length; i++) {
                String gene = queue.poll();
                if(gene.equals(endGene)) return mutationsCount;
                for(String mutation : generateMutations(gene, bankSet, endGene)) {
                    if(!visited.contains(mutation)) {
                        queue.add(mutation);
                        visited.add(mutation);
                    }
                }
            }
            mutationsCount++;
        }
        return -1;
    }
    
    private List<String> generateMutations(String gene, Set<String> bankSet, String endGene){
        char[] symbols = {'A', 'C', 'G', 'T'};
        List<String> mutations = new ArrayList<>();
        for(int i = 0; i < gene.length(); i++){
            for(int j = 0; j < symbols.length; j++){
                if(gene.charAt(i) != symbols[j]){
                    String mutation = gene.substring(0, i) + symbols[j] + gene.substring(i + 1);
                    if(bankSet.contains(mutation) || mutation.equals(endGene))  mutations.add(mutation);
                } 
            }
        }
        return mutations;
    }
}
