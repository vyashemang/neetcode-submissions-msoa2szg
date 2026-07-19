class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();

        if (len1 < len2) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        String res = "";
        int zero = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            String cur = mul(num1, num2.charAt(i), zero);
            res = add(res, cur);
            zero++;
        }

        return res;
    }

    private String mul(String s, char d, int zero) {
        int i = s.length() - 1, carry = 0;
        int digit = d - '0';

        StringBuilder curr = new StringBuilder();
        
        while (i >= 0 || carry > 0) {
            int n = (i >= 0) ? s.charAt(i) - '0' : 0;
            int prod = n * digit + carry;
            curr.append(prod % 10);
            carry = prod / 10;
            i--;
        }

        return curr.reverse().toString() + "0".repeat(zero);

    }

    private String add(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int total = n1 + n2 + carry;
            res.append(total % 10);
            carry = total / 10;
            i--;
            j--;
        }

        return res.reverse().toString();


    }
}
