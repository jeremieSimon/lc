package string;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return isInterleave(s1, s2, s3, 0, 0);
    }

    public static boolean isInterleave(String s1, String s2, String s3, int i1, int i2) {
        if (i1 + i2 == s3.length()) {
            return true;
        }
        boolean status = false;
        if (i1 < s1.length()
            && s1.charAt(i1) == s3.charAt(i1 + i2)) {
            status |= isInterleave(s1, s2, s3, i1 + 1, i2);
        }
        if (i2 < s2.length()
            && s2.charAt(i2) == s3.charAt(i1 + i2)) {
            status |= isInterleave(s1, s2, s3, i1, i2 + 1);
        }
        return status;
    }
}
