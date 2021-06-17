import java.io.*;
import java.util.*;

class DriverMain {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);
            System.out.println(ans);
        }
    }
}

class Solution {

    HashMap<Character, Integer> m = new HashMap<Character, Integer>();

    // Variable to check whether the count of unique letters in the map created is zero
    int count = 0;
    
    // Function to first create a map containing all the unique letters in the pattern and their frequencies
    void createPatList(String str) {
        for(char ch : str.toCharArray()) {
            if(this.m.get(ch) == null) {
                this.m.put(ch,1);
            }
            else {
                this.m.put(ch,(this.m.get(ch)+1));
            }
            if (this.m.get(ch) == 1) {
                this.count++;
            }
        }
    }
    
    // Function to deduct from the frequency of the unique letters created in the previous function
    void removeFromList(char ch) {
        if(this.m.get(ch) != null) {
            this.m.put(ch,(this.m.get(ch)-1));
            if(this.m.get(ch) == 0) {
                this.count--;
            }
        }
    }
    
    // Function to add to the frequency of unique letters
    void addToList(char ch) {
        if(this.m.get(ch) != null) {
            this.m.put(ch,(this.m.get(ch)+1));
            if (this.m.get(ch) == 1) {
                this.count++;
            }
        }
    }
    
    int search(String pat, String txt) {
        
        this.createPatList(pat);
        int ans = 0;
        int i = 0, j = 0;
        int k = pat.length();
        int n = txt.length();
        while(j<n){
            this.removeFromList(txt.charAt(j));
            if(j-i+1 < k){
                j++;
            }
            else{
                if(j-i+1 == k){
                    if (this.count == 0){
                        ans++;
                    }
                    this.addToList(txt.charAt(i));
                    i++;
                    j++;
                }
            }
            
        }
        return ans;
    }
}
