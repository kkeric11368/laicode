//Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

//Assumptions
//l, m, n >= 0

//Examples
//l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]




// My solution
//
public class Solution {
    public List<String> validParentheses(int l, int m, int n) {
        List<String> result = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        char[] paren = new char[]{'(', ')', '<', '>', '{', '}'};
        int[] remain = new int[]{l, l, m, m, n, n};
        int totalLen = 2 * l + 2 * m + 2 * n;
        permutation(totalLen, result, sb, stack, remain, paren);
        return result;
    }

    private void permutation(int totalLen, List<String> result, StringBuilder sb, Deque<Character> stack, int[] remain, char[] paren) {
        if (sb.length() == totalLen) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0) {
                    sb.append(paren[i]);
                    stack.push(paren[i]);
                    remain[i]--;
                    permutation(totalLen, result, sb, stack, remain, paren);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pop();
                    remain[i]++;
                }
            } else {
                if (!stack.isEmpty() && stack.peek() == paren[i - 1]) {
                    sb.append(paren[i]);
                    stack.pop();
                    remain[i]--;
                    permutation(totalLen, result, sb, stack, remain, paren);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.push(paren[i - 1]);
                    remain[i]++;
                }
            }
        }
    }
}





// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.bs2mmzibo8c6



