/**
 * @param {string} pat
 * @param {string} txt
 * @return {number}
*/

class Solution {
    
    search(pat,txt){
       
       function createPatList(str) {
           for(var ch of str) {
               // Create the list
               if(m.get(ch) === undefined) {
                m.set(ch,1);
            }
            else {
                m.set(ch,(m.get(ch)+1));
            }
            if (m.get(ch) === 1) {
                count++;
            }
           }
       }
       
       function removeFromList(ch) {
        if(m.get(ch) !== undefined) {
            m.set(ch,(m.get(ch)-1));
            if(m.get(ch) == 0) {
                count--;
            }
        }
       }
       
       function addToList(ch) {
        if(m.get(ch) !== undefined) {
            m.set(ch,(m.get(ch)+1));
            if (m.get(ch) == 1) {
                count++;
                }
            }
        }
    
        let m = new Map();
        let count = 0;
        createPatList(pat);
        let ans = 0;
        let i = 0, j = 0;
        let k = pat.length;
        let n = txt.length;
        while(j<n){
            removeFromList(txt.charAt(j));
            if(j-i+1 < k){
                j++;
            }
            else{
                if(j-i+1 === k){
                    if (count === 0){
                        ans++;
                    }
                    addToList(txt.charAt(i));
                    i++;
                    j++;
                }
            }
            
        }
        return ans;
    }
}